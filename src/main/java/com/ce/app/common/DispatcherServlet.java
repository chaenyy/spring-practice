package com.ce.app.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ce.app.common.exception.MethodNotAllowException;
import com.ce.app.student.model.dao.StudentDao;
import com.ce.app.student.model.dao.StudentDaoImpl;
import com.ce.app.student.model.service.StudentService;
import com.ce.app.student.model.service.StudentServiceImpl;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, AbstractController> urlCommandMap = new HashMap<>();
       
    public DispatcherServlet() throws FileNotFoundException, IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // 1. url-command.properties -> Properties 객체
    	String filename = DispatcherServlet.class.getResource("/url-command.properties").getPath(); // / -> target/class 의미
    	Properties prop = new Properties();
    	prop.load(new FileReader(filename));
    	
    	// 2. Properties 객체 -> urlCommandMap에 요소추가 (String=AbstractController객체)    	
    	Set<String> urls = prop.stringPropertyNames();	// 모든 키 셋을 리턴
    	
    	StudentDao studentDao = new StudentDaoImpl();
    	StudentService studentService = new StudentServiceImpl(studentDao);
    	
    	for(String url : urls) {
    		String className = prop.getProperty(url);
    		Class<?> clz = Class.forName(className);
    		Constructor<?> constructor = clz.getDeclaredConstructor(StudentService.class);
    		AbstractController controller = (AbstractController) constructor.newInstance(studentService);
    		urlCommandMap.put(url, controller);
    	}
    	System.out.println("urlCommandMap = " + urlCommandMap);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 주소
		String uri = request.getRequestURI();		// /hello-maven2/student/selectList.do
		uri = uri.replace(request.getContextPath(), ""); // student/selectList.do
		AbstractController controller = urlCommandMap.get(uri);
		
		if(controller == null) {
			throw new RuntimeException("해당 요청을 처리할 Controller가 존재하지 않습니다.");
		}
		
		// 2. 해당 controller 호출
		String method = request.getMethod(); // GET 요청 시 GET, POST 요청 시 POST 리턴
		String viewName = null;
		
		switch(method) {
		case "GET" : viewName = controller.doGet(request, response); break;
		case "POST" : viewName = controller.doPost(request, response); break;
		default : throw new MethodNotAllowException();
		}
		
		// 3. viewName에 따라 forward/redirect처리
		if(viewName != null) {
			if(viewName.startsWith("redirect:")) {
				// redirect 처리
				String location = request.getContextPath() + viewName.replace("redirect:", "");
				response.sendRedirect(location);
			} else {
				// forward 처리
				String prefix = "/WEB-INF/views/";
				String suffix = ".jsp";
				viewName = prefix + viewName + suffix;
				request.getRequestDispatcher(viewName).forward(request, response);
			}
		}
		
		// viewName이 null인 경우 컨트롤러에서 응답메세지를 직접 작성한 경우 (비동기) 아무것도 하지 않는다.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

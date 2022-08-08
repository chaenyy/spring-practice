package com.ce.app.student.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ce.app.common.AbstractController;
import com.ce.app.student.model.service.StudentService;
import com.google.gson.Gson;

public class StudentUpdateController extends AbstractController {
	static final Logger log = Logger.getLogger(StudentUpdateController.class);
	private StudentService studentService;
	
	public StudentUpdateController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		Map<String, Object> data = new HashMap<>();
		data.put("no", no);
		data.put("name", name);
		data.put("tel", tel);
		
		int result = studentService.updateStudent(data);
		
		response.setContentType("application/json; charset=utf-8");
		Map<String, Object> msg = new HashMap<>();
		msg.put("msg", "학생 정보를 성공적으로 수정하였습니다.");
		new Gson().toJson(msg, response.getWriter());
		
		return null;
	}
}

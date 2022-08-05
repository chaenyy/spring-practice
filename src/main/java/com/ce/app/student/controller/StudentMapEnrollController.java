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

public class StudentMapEnrollController extends AbstractController {
	static final Logger log = Logger.getLogger(StudentMapEnrollController.class);
	private StudentService studentService;
	
	public StudentMapEnrollController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	/**
	 * Student DTO -> Map<String, Object>
	 */
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("tel", tel);
		
		int result = studentService.insertStudentMap(map);
		
		request.getSession().setAttribute("msg", "학생을 성공적으로 등록하였습니다.");
		return "redirect:/student/studentEnroll.do";
	}
}

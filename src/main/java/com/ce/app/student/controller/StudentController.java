package com.ce.app.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ce.app.common.AbstractController;
import com.ce.app.student.model.dto.Student;
import com.ce.app.student.model.service.StudentService;
import com.google.gson.Gson;

public class StudentController extends AbstractController {
	static final Logger log = Logger.getLogger(StudentController.class);
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		log.debug("no = " + no);
		Student student = studentService.selectOneStudent(no);
		
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(student, response.getWriter());
		
		return null;
	}
}

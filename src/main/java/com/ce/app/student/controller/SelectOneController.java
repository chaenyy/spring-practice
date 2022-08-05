package com.ce.app.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ce.app.common.AbstractController;
import com.ce.app.student.model.service.StudentService;

public class SelectOneController extends AbstractController {
	static final Logger log = Logger.getLogger(SelectOneController.class);
	private StudentService studentService;
	
	public SelectOneController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int totalCount = studentService.getTotalCount();
		request.setAttribute("totalCount", totalCount);
		return "student/selectOne";
	}
}

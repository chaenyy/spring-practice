package com.ce.app.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ce.app.common.AbstractController;
import com.ce.app.student.model.service.StudentService;

public class SelectListController extends AbstractController {
	private StudentService studentService;
	
	public SelectListController (StudentService studentService) {
		this.studentService = studentService;
	}
	
	@Override
	public String doGet(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
		
		return "student/selectList";
	}
}

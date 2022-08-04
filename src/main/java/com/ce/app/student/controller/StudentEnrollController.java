package com.ce.app.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ce.app.common.AbstractController;
import com.ce.app.student.model.service.StudentService;

public class StudentEnrollController extends AbstractController {
	private StudentService studentService;
	
	@Override
	public String doPost(HttpServletRequest requset, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		return "redirect:/";
	}
}

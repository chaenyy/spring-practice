package com.ce.app.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ce.app.common.AbstractController;
import com.ce.app.student.model.dto.Student;
import com.ce.app.student.model.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequiredArgsConstructor // 꼭 필요한 인자만 받는 생성자
public class StudentEnrollController extends AbstractController {
	private final StudentService studentService; // final -> 필수
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "student/studentEnroll";
	}
	
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		Student student = new Student();
		student.setName(name);
		student.setTel(tel);
		log.debug("student = " + student);
		
		int result = studentService.insertStudent(student);
		
		request.getSession().setAttribute("msg", "학생을 성공적으로 등록하였습니다.");
		
		return "redirect:/student/studentEnroll.do";
	}
}

package com.ce.app.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ce.app.common.exception.MethodNotAllowException;

/**
 * 전략 클래스
 */
public abstract class AbstractController {
	
	public String doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// GET방식만 구현하였는데 POST를 요청한다면 예외던짐!
		
		throw new MethodNotAllowException("GET");
	}
	
	public String doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// POST방식만 구현하였는데 GET를 요청한다면 예외던짐!
		
		throw new MethodNotAllowException("POST");
	}
}

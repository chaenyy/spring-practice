package com.ce.app.emp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ce.app.common.AbstractController;
import com.ce.app.emp.model.service.EmpService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequiredArgsConstructor
public class EmpSearchController1 extends AbstractController {
	private final EmpService empService;
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 입력값 처리
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		Map<String, Object> param = new HashMap<>();
		param.put("searchType", searchType);
		param.put("searchKeyword", searchKeyword);
		log.debug("param = " + param);
		
		List<Map<String, Object>> list = null;
		
		// 2. 업무로직
		if(searchType != null && searchKeyword != null) {
			list = empService.search1(param);
		} else {
			list = empService.selectEmpList();
		}
		
		log.debug("list = " + list);
		request.setAttribute("list", list);
		
		return "emp/search1";
	}
}

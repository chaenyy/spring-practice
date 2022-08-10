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
public class EmpSearchController2 extends AbstractController {
	private final EmpService empService;
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("searchType"); // "검색어" | "" | null
		String searchKeyword = request.getParameter("searchKeyword"); // "검색어" | "" | null
		String gender = request.getParameter("gender");	// "성별" | null
		int salary = 0;
		try {
			salary = Integer.parseInt(request.getParameter("salary")); // "금액" | "" | null
		} catch(NumberFormatException e) {}
		String salaryCompare = request.getParameter("salaryCompare"); // "범위" | null
		
		Map<String, Object> param = new HashMap<>();
		param.put("searchType", searchType);
		param.put("searchKeyword", searchKeyword);
		param.put("gender", gender);
		param.put("salary", salary);
		param.put("salaryCompare", salaryCompare);
		
		List<Map<String, Object>> list = empService.search2(param);
		log.debug("list = " + list);
		request.setAttribute("list", list);
		
		return "emp/search2";
	}
}

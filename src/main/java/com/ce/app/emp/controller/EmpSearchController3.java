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
public class EmpSearchController3 extends AbstractController {
	private final EmpService empService;
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] jobCodes = request.getParameterValues("jobCode");
		String[] deptCodes = request.getParameterValues("deptCode");
		Map<String, Object> param = new HashMap<>();
		param.put("jobCodes", jobCodes);
		param.put("deptCodes", deptCodes);
		
		// 직급/부서별 검색
		List<Map<String, Object>> list = empService.search3(param);
		log.debug("list = " + list);
		
		// 폼에 나열할 직급 리스트 조회
		List<Map<String, Object>> jobCodeList = empService.selectJobList();
		// 폼에 나열할 부서 리스트 조회
		List<Map<String, Object>> deptCodeList = empService.selectDeptList();
		log.debug("jobCodeList = " + jobCodeList);
		log.debug("deptCodeList = " + deptCodeList);
		
		request.setAttribute("jobCodeList", jobCodeList);
		request.setAttribute("deptCodeList", deptCodeList);
		request.setAttribute("list", list);
		
		return "emp/search3";
	}
}

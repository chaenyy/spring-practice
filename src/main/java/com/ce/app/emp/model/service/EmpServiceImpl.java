package com.ce.app.emp.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import static com.ce.app.common.SqlSessionUtils.*;
import com.ce.app.emp.model.dao.EmpDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {
	private final EmpDao empDao;
	
	@Override
	public List<Map<String, Object>> selectEmpList() {
		try(SqlSession sqlSession = getSqlSession()) {
			return empDao.selectEmpList(sqlSession);			
		}
	}
}

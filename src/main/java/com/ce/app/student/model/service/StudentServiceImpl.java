package com.ce.app.student.model.service;

import com.ce.app.student.model.dao.StudentDao;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;
	
	public StudentServiceImpl(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
}

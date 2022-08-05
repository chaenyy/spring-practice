package com.ce.app.student.model.service;

import java.util.Map;

import com.ce.app.student.model.dto.Student;

public interface StudentService {

	int insertStudent(Student student);

	int insertStudentMap(Map<String, Object> map);

	int getTotalCount();

	Student selectOneStudent(int no);
	
}

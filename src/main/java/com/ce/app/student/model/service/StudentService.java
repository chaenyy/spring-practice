package com.ce.app.student.model.service;

import java.util.List;
import java.util.Map;

import com.ce.app.student.model.dto.Student;

public interface StudentService {

	int insertStudent(Student student);

	int insertStudentMap(Map<String, Object> map);

	int getTotalCount();

	Student selectOneStudent(int no);

	int updateStudent(Map<String, Object> data);

	int deleteStudent(int no);

	Map<String, Object> selectOneStudentMap(int no);

	List<Student> selectStudentList();
	
}

package com.ce.app.student.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ce.app.student.model.dto.Student;

public interface StudentDao {

	int insertStudent(SqlSession sqlSession, Student student);

	int insertStudentMap(SqlSession sqlSession, Map<String, Object> map);

	int getTotalCount(SqlSession sqlSession);

	Student selectOneStudent(SqlSession sqlSession, int no);

	int updateStudent(SqlSession sqlSession, Map<String, Object> data);

	int deleteStudent(SqlSession sqlSession, int no);

	Map<String, Object> selectOneStudentMap(SqlSession sqlSession, int no);

	List<Student> selectStudentList(SqlSession sqlSession);
	
}

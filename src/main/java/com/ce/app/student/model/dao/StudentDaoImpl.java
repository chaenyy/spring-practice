package com.ce.app.student.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ce.app.student.model.dto.Student;

public class StudentDaoImpl implements StudentDao {
	@Override
	public int insertStudent(SqlSession sqlSession, Student student) {
		return sqlSession.insert("student.insertStudent", student);
	}
	
	@Override
	public int insertStudentMap(SqlSession sqlSession, Map<String, Object> map) {
		return sqlSession.insert("student.insertStudentMap", map);
	}
	
	@Override
	public int getTotalCount(SqlSession sqlSession) {
		return sqlSession.selectOne("student.getTotalCount");
	}
	
	@Override
	public Student selectOneStudent(SqlSession sqlSession, int no) {
		return sqlSession.selectOne("student.selectOneStudent", no);
	} 
	
	@Override
	public int updateStudent(SqlSession sqlSession, Map<String, Object> data) {
		return sqlSession.update("student.updateStudent", data);
	}
	
	@Override
	public int deleteStudent(SqlSession sqlSession, int no) {
		return sqlSession.update("student.deletStudent", no);
	}
	
	@Override
	public Map<String, Object> selectOneStudentMap(SqlSession sqlSession, int no) {
		return sqlSession.selectOne("student.selectOneStudentMap", no);
	}
	
	@Override
	public List<Student> selectStudentList(SqlSession sqlSession) {
		return sqlSession.selectList("student.selectStudentList");
	}
}

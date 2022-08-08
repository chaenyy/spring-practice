package com.ce.app.student.model.service;

import org.apache.ibatis.session.SqlSession;

import static com.ce.app.common.SqlSessionUtils.getSqlSession;

import java.util.Map;

import com.ce.app.student.model.dao.StudentDao;
import com.ce.app.student.model.dto.Student;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;
	
	public StudentServiceImpl(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	@Override
	public int insertStudent(Student student) {
		SqlSession sqlSession = getSqlSession();
		int result = 0;
		try {
			result = studentDao.insertStudent(sqlSession, student);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	@Override
	public int insertStudentMap(Map<String, Object> map) {
		SqlSession sqlSession = getSqlSession();
		int result = 0;
		
		try {
			result = studentDao.insertStudentMap(sqlSession, map);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	@Override
	public int getTotalCount() {
		try(SqlSession sqlSession = getSqlSession()) {			
			return studentDao.getTotalCount(sqlSession);
		}
	}
	
	@Override
	public Student selectOneStudent(int no) {
		try(SqlSession sqlSession = getSqlSession()) {
			return studentDao.selectOneStudent(sqlSession, no);
		}
	}
	
	@Override
	public int updateStudent(Map<String, Object> data) {
		SqlSession sqlSession = getSqlSession();
		int result = 0;
		try {
			result = studentDao.updateStudent(sqlSession, data);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	@Override
	public int deleteStudent(int no) {
		SqlSession sqlSession = getSqlSession();
		int result = 0;
		try {
			result = studentDao.deleteStudent(sqlSession, no);
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		return result;
	}
}

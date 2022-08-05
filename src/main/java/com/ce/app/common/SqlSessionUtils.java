package com.ce.app.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtils {

	public static SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		String resource = "/mybatis-config.xml";
		
		// 1. FactoryBuilder
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		// 2. Factory
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(resource); // resource를 읽어와서 stream으로 반환
		} catch (IOException e) {
			e.printStackTrace();
		} 
		SqlSessionFactory factory = builder.build(is);
		
		// 3. SqlSession
		sqlSession = factory.openSession(false); // autoCommit 여부
		
		// 한 줄로도 가능!
//		try {
//			sqlSession = builder.build(Resources.getResourceAsStream(resource)).openSession(false);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return sqlSession;
	}
	
}

package com.ce.app.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtils {
	
	static SqlSessionFactory factory;
	
	static {
		String resource = "/mybatis-config.xml";
		
		// 1. FactoryBuilder
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		// 2. Factory
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(resource); // resource를 읽어서 stream으로 반환
		} catch (IOException e) {
			e.printStackTrace();
		} 
		factory = builder.build(is);
	}

	public static SqlSession getSqlSession() {
		// 3. SqlSession
		return factory.openSession(false); // autoCommit 여부
		
//		 try {
//            sqlSession = 
//                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource)).openSession(false);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
		
	}
}

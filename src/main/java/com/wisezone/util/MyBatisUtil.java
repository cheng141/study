package com.wisezone.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 初始化mybatis实例
 * @author Administrator
 *
 */
public class MyBatisUtil {

	//每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为核心的
	private static SqlSessionFactory  sessionFactory;
	  
	static {		 
		InputStream inputStream;
		try {
			inputStream = MyBatisUtil.class.getResourceAsStream("/mybatis.xml");
			//只能实例化一个
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);			
		} catch (Exception e) {
			e.printStackTrace();
		}		 
	}
	
	
	/**
	 * 打开一个数据库的连接
	 * @return
	 */
	public static SqlSession  getSession() {
		return sessionFactory.openSession();
	}
	
	
}

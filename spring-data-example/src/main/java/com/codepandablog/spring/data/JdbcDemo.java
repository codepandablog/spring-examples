package com.codepandablog.spring.data;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codepandablog.spring.data.dao.JdbcDaoImpl;
import com.codepandablog.spring.data.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		Circle circle;
		try {
			JdbcDaoImpl dao=context.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
			circle = dao.getCircle(1,context);
			System.out.println("Circle Name:"+circle.getName());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

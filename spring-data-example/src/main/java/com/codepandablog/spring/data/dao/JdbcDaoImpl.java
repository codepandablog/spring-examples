package com.codepandablog.spring.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.codepandablog.spring.data.factory.ConnectionFactory;
import com.codepandablog.spring.data.model.Circle;

@Component
public class JdbcDaoImpl {

	public Circle getCircle(int circleId,ApplicationContext context) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		ConnectionFactory factory=context.getBean("connectionFactory", ConnectionFactory.class);
		Connection conn=factory.getConnection("oracle");
		PreparedStatement stmt=conn.prepareStatement("select id,name from circle where id=?");
		stmt.setInt(1, circleId);
		ResultSet rset=stmt.executeQuery();
		Circle circle=null;
		
		if(rset.next()){
			circle=new Circle(circleId,rset.getString("name"));
		}
		return circle;
	}
}

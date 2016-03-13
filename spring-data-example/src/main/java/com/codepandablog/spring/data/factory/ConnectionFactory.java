package com.codepandablog.spring.data.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConnectionFactory {

	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Connection getConnection(String db)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		if (db.equals("oracle")) {
			return getOracleConnection();
		} else {
			throw new java.lang.UnsupportedOperationException("only oracle DB supported");
		}
	}

	private Connection getOracleConnection()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return dataSource.getConnection();
	}
}

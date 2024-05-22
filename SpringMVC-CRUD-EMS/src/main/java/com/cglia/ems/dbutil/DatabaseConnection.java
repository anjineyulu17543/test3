package com.cglia.ems.dbutil;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DatabaseConnection {

	private static BasicDataSource dataSource;

	static {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/cgliadb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
	}

	public static Connection getConnection() throws SQLException {
		Connection connection = dataSource.getConnection();
		return connection;
	}

}

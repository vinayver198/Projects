package com.cg.brs.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {

	static InitialContext context;
	static DataSource dataSource;
	static Connection connection;
	
	static
	{
		try {
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:/jdbc/MyDS");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection()
	{
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	
}

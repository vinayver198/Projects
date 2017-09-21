package com.cg.lab5.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DButil {

	static InitialContext context;
	static DataSource dataSource;
	static Connection connection;
	
	static
	{
		try {
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:/jdbc/MyDS");
			
		}
		catch (NamingException e) {
			
			
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

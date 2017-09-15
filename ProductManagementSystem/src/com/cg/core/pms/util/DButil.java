package com.cg.core.pms.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DButil 
{
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
	
	Connection con = null;
	String path ="dataBase.properties";
	
	InputStream propsFile = null;
	
	Properties dbProperties = new Properties();
	
	try {
		propsFile = new FileInputStream(path);
		dbProperties.load(propsFile);
		propsFile.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Class.forName(dbProperties.getProperty("driver"));
	//Acquire Database Connection
			con = DriverManager.getConnection(
					dbProperties.getProperty("url"),
					dbProperties.getProperty("username"),
					dbProperties.getProperty("password"));
			return con;
}
}

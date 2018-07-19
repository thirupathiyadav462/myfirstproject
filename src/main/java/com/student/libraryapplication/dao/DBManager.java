package com.student.libraryapplication.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	protected static Connection conn = null;
	
	public void getConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "javaapps",
					"javaapps123");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}

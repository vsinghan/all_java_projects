package com.cg.frs.dao;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DemoClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String query = "";
		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system" ,"system");
		System.out.println(connection);
		
//		try
//		{
//			
//		}
//		catch(Exception e)
//		{
//			System.out.println("Exception");
//		}
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(query);
		
		String name = resultSet.getString();
		
	}

}

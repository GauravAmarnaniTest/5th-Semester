package com.durga.demoprogram;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertSingleRowDemo 
{
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "system";
	String pass = "1234";
	String className = "oracle.jdbc.OracleDriver";
	
	public static void main(String...args)
	{
		String sqlQuery = "insert into employee values(10,'Bhatia',100,'Ulhas')";
		InsertSingleRowDemo isrd = new InsertSingleRowDemo();
		isrd.getOracleConnection(sqlQuery);
	}
	
	public void getOracleConnection(String sqlQuery)
	{
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Class.forName(className);
			Statement st = con.createStatement();
			int updatedRows = st.executeUpdate(sqlQuery);
			out.println(updatedRows + " no. of row inserted successfully");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

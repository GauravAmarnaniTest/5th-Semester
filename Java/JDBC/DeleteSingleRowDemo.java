package com.durga.demoprogram;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteSingleRowDemo 
{
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "system";
	String pass = "1234";
	String className = "oracle.jdbc.OracleDriver";
	
	public static void main(String...args)
	{
		Scanner sc = new Scanner(System.in);
		out.println("Enter the name of the Employee whose data you want to delete : ");
		String name = sc.next();
		String sqlQuery = String.format("delete from employee where name = '%s'",name);
		DeleteSingleRowDemo dsrd = new DeleteSingleRowDemo();
		dsrd.getOracleConnection(sqlQuery);
	}
	
	public void getOracleConnection(String sqlQuery)
	{
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Class.forName(className);
			Statement st = con.createStatement();
			st.executeUpdate(sqlQuery);
			out.println("Record deleted successfully.");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

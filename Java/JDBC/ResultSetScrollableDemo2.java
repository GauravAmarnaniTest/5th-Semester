//This is a program to show that refreshRow() is not supported by Type 4 Driver.

package com.jdbc.byGaurav;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import static java.lang.System.out;
import java.util.Scanner;

public class ResultSetScrollableDemo2
{
	public static void main(String...args)throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		GetOracleConnection goc = new GetOracleConnection();
		String url = goc.getUrl();
		String user = goc.getUser();
		String pass = goc.getPass();
		try(Connection con = DriverManager.getConnection(url, user, pass))
		{
			Statement st = con.createStatement(1005,1007);
			ResultSet rs = st.executeQuery("select * from employee");
			out.println("---------------------------------------");
			out.println("Original Table : ");
			out.println("ID:\tNAME:\tSALARY:\tADDRESS:");
			while(rs.next())
			{
				out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
			}
			out.println("Waiting now for changes to be made in Database. Enter Proceed to continue.");
			String choice = sc.next();
			if(choice.equalsIgnoreCase("proceed"))
			{
				rs.refreshRow();
				out.println("---------------------------------------");
				out.println("Original Table after changes : ");
				out.println("ID:\tNAME:\tSALARY:\tADDRESS:");
				while(rs.next())
				{
					out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
				}
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
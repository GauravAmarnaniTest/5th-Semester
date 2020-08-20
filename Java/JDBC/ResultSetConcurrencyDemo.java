package com.jdbc.byGaurav;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import static java.lang.System.out;

public class ResultSetConcurrencyDemo 
{
	public static void main(String...args)throws Exception 
	{
		GetOracleConnection goc = new GetOracleConnection();
		String url = goc.getUrl();
		String user = goc.getUser();
		String pass = goc.getPass();
		try(Connection con = DriverManager.getConnection(url, user, pass))
		{
			DatabaseMetaData dbmd = con.getMetaData();
			Statement st = con.createStatement();
			out.println("READ_ONLY MODE : " + dbmd.supportsResultSetConcurrency(1003, 1007));
			out.println("UPDATABLE MODE : " + dbmd.supportsResultSetConcurrency(1003, 1008));
			out.println("FORWARD_ONLY TYPE : " + dbmd.supportsResultSetType(1003));
			out.println("SCROLL INSENSITIVE TYPE : " + dbmd.supportsResultSetType(1004));
			out.println("SCROLL SENSITIVE TYPE : " + dbmd.supportsResultSetType(1005));
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

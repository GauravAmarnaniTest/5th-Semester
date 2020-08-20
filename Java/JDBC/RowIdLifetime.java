package com.jdbc.byGaurav;

import java.sql.*;
import static java.lang.System.out;

public class RowIdLifetime 
{
	public static void main(String...args)throws Exception
	{
		GetOracleConnection goc = new GetOracleConnection();
		String url = goc.getUrl();
		String user = goc.getUser();
		String pass = goc.getPass();
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Statement st = con.createStatement();
			DatabaseMetaData dbmd = con.getMetaData();
			out.println(dbmd.getRowIdLifetime());
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

package com.jdbc.byGaurav;

import static java.lang.System.out;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseMetaDataDemo2 
{
	public static void main(String...args)throws Exception
	{
		int count = 0;
		int tablenumber = 0;
		GetOracleConnection goc = new GetOracleConnection();
		String url = goc.getUrl();
		String user = goc.getUser();
		String pass = goc.getPass();
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Statement st = con.createStatement();
			DatabaseMetaData dbmd = con.getMetaData();
			String catalog = null;
			String schemaPattern = null;
			String tableNamePattern = null;
			String[] types = null;
			ResultSet rs = dbmd.getTables(catalog, schemaPattern, tableNamePattern, types);
			out.println("Table Name : ");
			while(rs.next())
			{
				if(rs.getString(3).equalsIgnoreCase("programs"))
				{
					out.println("Success.");
					tablenumber = count;
				}
				count++;
			}
			out.println("Total number of Tables : " + count);
			out.println("Table number : " + tablenumber);
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

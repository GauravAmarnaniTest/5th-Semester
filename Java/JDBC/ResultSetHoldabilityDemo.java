//This is a program to demonstrate that Oracle & MySQL Database both only support 
//HOLD_CURSORS_AFTER_COMMIT.

package com.jdbc.byGaurav;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import static java.lang.System.out;

public class ResultSetHoldabilityDemo 
{
	public static void main(String...args)throws Exception 
	{
		GetOracleConnection goc = new GetOracleConnection();
		String url = goc.getUrl();
		String user = goc.getUser();
		String pass = goc.getPass();
		try(Connection con = DriverManager.getConnection(url, user, pass))
		{
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE,ResultSet.CLOSE_CURSORS_AT_COMMIT);
			ResultSet rs = st.executeQuery("select * from employee");
			out.println("---------------------------------------");
			out.println("Original Table : ");
			out.println("ID:\tNAME:\tSALARY:\tADDRESS:");
			while(rs.next())
			{
				out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
			}
			con.commit();
			out.println("---------------------------------------");
			rs.first();
			out.println(rs.getRow() + "--->" + rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
			out.println("---------------------------------------");
			rs.last();
			out.println(rs.getRow() + "--->" + rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
			out.println("---------------------------------------");
			rs.absolute(3);
			out.println(rs.getRow() + "--->" + rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
			out.println("---------------------------------------");
			rs.relative(0);
			out.println(rs.getRow() + "--->" + rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));		
			out.println("---------------------------------------");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

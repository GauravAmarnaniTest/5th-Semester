//User friendly Retrieval
package com.jdbc.byGaurav;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.lang.System.out;

public class DateDemo2 
{
	public static void main(String...args)
	{
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String pass = "1234";
		String className = "oracle.jdbc.OracleDriver";
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{	
			Class.forName(className);
			PreparedStatement pst = con.prepareStatement("select * from users");
			ResultSet rs = pst.executeQuery();
			out.println("NAME:\tDATE OF BIRTH:");
			while(rs.next())
			{
				out.println(rs.getString(1) + "\t" + rs.getDate(2));
			}
		}
		catch(Exception e)
		{
			out.println("No records found in Table Users.");
		}
	}
}

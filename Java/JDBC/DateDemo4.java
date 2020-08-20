//SQL Date Format Retrieval.
package com.jdbc.byGaurav;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import static java.lang.System.out;

public class DateDemo4
{
	public static void main(String...args)
	{
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String pass = "1234";
		String className = "oracle.jdbc.OracleDriver";
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			Class.forName(className);
			PreparedStatement pst = con.prepareStatement("select * from users");
			ResultSet rs = pst.executeQuery();
			out.println("NAME:\tDATE OF BIRTH:");
			while(rs.next())
			{
				java.sql.Date sdate = rs.getDate(2);
				String date = sdf.format(sdate);
				out.println(rs.getString(1) + "\t" + date);
			}
		}
		catch(Exception e)
		{
			out.println("No records found in Table Users.");
		}
	}
}

//User friendly Insertion.
package com.jdbc.byGaurav;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateDemo1 
{
	public static void main(String...args)
	{
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String pass = "1234";
		String className = "oracle.jdbc.OracleDriver";
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			PreparedStatement pst = con.prepareStatement("insert into users values(?,?)");
			Scanner sc = new Scanner(System.in); 
			Class.forName(className);
			out.println("Enter Name of the User : ");
			String name = sc.next();
			out.println("Enter Dirthdate of User : (DD-MM-YYYY)");
			String dob = sc.next();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date ud = sdf.parse(dob);
			long l = ud.getTime();
			java.sql.Date sd = new java.sql.Date(l);
			pst.setString(1, name);
			pst.setDate(2, sd);
			int count = pst.executeUpdate();
			if(count==1)
			{
				out.println("Row inserted.");
			}
			else
			{
				out.println("Row not inserted.");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

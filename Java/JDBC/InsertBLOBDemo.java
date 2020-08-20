package com.jdbc.byGaurav;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.File;
import java.io.FileInputStream;
import static java.lang.System.out;

public class InsertBLOBDemo 
{
	public static void main(String...args)
	{
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String pass = "1234";
		String className = "oracle.jdbc.OracleDriver";
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			File f = new File("D:\\Database_Servlets\\JDBCDemo2\\src\\com\\jdbc\\byGaurav\\Gaurang.png");
			FileInputStream fis = new FileInputStream(f);
			PreparedStatement pst = con.prepareStatement("insert into persons values(?,?)");
			Class.forName(className);
			pst.setString(1, "Gaurang");
			pst.setBinaryStream(2, fis);
			out.println("Inserting file... " + f.getAbsolutePath());
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

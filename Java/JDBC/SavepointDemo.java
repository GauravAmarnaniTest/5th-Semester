package com.jdbc.byGaurav;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.ResultSet;
import static java.lang.System.out;

public class SavepointDemo 
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
			con.setAutoCommit(false);
			st.executeUpdate("insert into politicians values('Modi','BJP')");
			st.executeUpdate("insert into politicians values('Amit','BJP')");
			Savepoint sp = con.setSavepoint();
			st.executeUpdate("insert into politicians values('Rahul','BJP')");
			con.rollback(sp);
			out.println("Rollback with Savepoint successful.");
			con.commit();
			out.println("The following is the table of Politicians : ");
			out.println("NAME:\tPARTY:");
			ResultSet rs = st.executeQuery("select * from politicians");
			while(rs.next())
			{
				out.println(rs.getString(1) + "\t" + rs.getString(2));
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

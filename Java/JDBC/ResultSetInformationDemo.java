package com.jdbc.byGaurav;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import static java.lang.System.out;

public class ResultSetInformationDemo 
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
			out.println("Type : " + rs.getType());
			out.println("Concurrency : " + rs.getConcurrency());
			out.println("Holdability : " + rs.getHoldability());
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

//This is a program to show that Type 4 Driver does not support Updatabe ResultSet and hence 
//does not support updateXxx() , insertRow() , deleteRow() methods.

//Author : Gaurav Amarnani.

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import static java.lang.System.out;

public class ResultSetScrollableDemo3
{
	public static void main(String...args)throws Exception 
	{
		GetOracleConnection goc = new GetOracleConnection();
		String url = goc.getUrl();
		String user = goc.getUser();
		String pass = goc.getPass();
		try(Connection con = DriverManager.getConnection(url, user, pass))
		{
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("select * from employee");
			out.println(rs.getConcurrency());
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
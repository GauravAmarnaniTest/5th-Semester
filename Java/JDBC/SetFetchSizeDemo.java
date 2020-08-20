//Author : Gaurav Amarnani.

import java.sql.*;
import static java.lang.System.out;

public class SetFetchSizeDemo 
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
			st.setFetchSize(500);
			//Now all the ResultSet that will be created with this Statement Object will have a 
			//by default fetch size of 500 rather than 10.
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

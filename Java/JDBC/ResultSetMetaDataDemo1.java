//Author : Gaurav Amarnani.

import static java.lang.System.out;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ResultSetMetaDataDemo1 
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
			ResultSet rs = st.executeQuery("select * from employee");
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			for(int i = 1; i<=count ;i++)
			{
				out.println("---------------------------");
				out.println("Column Number : " + i);
				out.println("Column Name : " + rsmd.getColumnName(i));
				out.println("Column Type : " + rsmd.getColumnType(i));
				out.println("Column Display Size : " + rsmd.getColumnDisplaySize(i));
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

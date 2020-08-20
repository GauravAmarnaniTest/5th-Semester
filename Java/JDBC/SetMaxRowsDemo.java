//Author : Gaurav Amarnani.

import java.sql.*;
import static java.lang.System.out;

public class SetMaxRowsDemo
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
			st.setMaxRows(10);
			//Now all the ResultSet that will be created with this Statement Object will have a 
			//by default Max size of 10 rather than the total number of rows that are available.
			ResultSet rs = st.executeQuery("select * from employee");
			out.println("No matter how many records are available only 10 will be displayed : ");
			out.println("ID:\tNAME:\tSALARY:\tADDRESS:");
			out.println("----------------------------------------");
			while(rs.next())
			{
				out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

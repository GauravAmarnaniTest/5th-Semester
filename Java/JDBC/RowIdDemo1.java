//Author : Gaurav Amarnani.

import java.sql.*;
import static java.lang.System.out;

public class RowIdDemo1 
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
			ResultSet rs = st.executeQuery("select rowid , id , name , salary , address from employee");
			while(rs.next())
			{
				RowId rid = rs.getRowId(1);
				byte[] b = rid.getBytes();
				String s = new String(b);
				out.println("RowId : " + s.toString());
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

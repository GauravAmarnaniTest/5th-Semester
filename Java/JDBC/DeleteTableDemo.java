//Author : Gaurav Amarnani.

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteTableDemo 
{
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "system";
	String pass = "1234";
	String className = "oracle.jdbc.OracleDriver";
	
	public static void main(String...args)
	{
		String sqlQuery = "drop table managers";
		DeleteTableDemo dtd = new DeleteTableDemo();
		dtd.getOracleConnection(sqlQuery);
	}
	
	public void getOracleConnection(String sqlQuery)
	{
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Class.forName(className);
			Statement st = con.createStatement();
			st.executeUpdate(sqlQuery);
			out.println("Table deleted successfully.");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

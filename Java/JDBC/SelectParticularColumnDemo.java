//Author : Gaurav Amarnani.

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class SelectParticularColumnDemo 
{
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "system";
	String pass = "1234";
	String className = "oracle.jdbc.OracleDriver";
	
	public static void main(String...args)
	{
		String sqlQuery = "select * from programs";
		SelectParticularColumnDemo spcd = new SelectParticularColumnDemo();
		spcd.getOracleConnection(sqlQuery);
	}
	
	public void getOracleConnection(String sqlQuery)
	{
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Class.forName(className);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sqlQuery);
			out.println("The following are the name of the programs in programs table : ");
			while(rs.next())
			{
				out.println(rs.getString(1));
			}
			out.println("All the program names displayed successfully.");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

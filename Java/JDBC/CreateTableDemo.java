//Author : Gaurav Amarnani.

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableDemo 
{
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "system";
	String pass = "1234";
	String className = "oracle.jdbc.OracleDriver";
	
	public static void main(String...args)
	{
		String sqlQuery = "create table employee(id number(2) , name varchar2(10) , salary number(10,2) , address varchar2(10))";
		CreateTableDemo ctd = new CreateTableDemo();
		ctd.getOracleConnection(sqlQuery);
	}
	
	public void getOracleConnection(String sqlQuery)
	{
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Class.forName(className);
			Statement st = con.createStatement();
			st.executeUpdate(sqlQuery);
			out.println("Table created successfully.");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

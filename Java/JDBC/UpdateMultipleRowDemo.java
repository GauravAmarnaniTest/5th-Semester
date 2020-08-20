//Author : Gaurav Amarnani.

import static java.lang.System.out;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class UpdateMultipleRowDemo 
{
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "system";
	String pass = "1234";
	String className = "oracle.jdbc.OracleDriver";
	
	public static void main(String...args)
	{
		UpdateMultipleRowDemo umrd = new UpdateMultipleRowDemo();
		Scanner sc = new Scanner(System.in);
		out.println("Enter the Salary limit : ");
		int limit = sc.nextInt();
		out.println("Limit : " + limit);
		out.println("Enter the amount of raise : ");
		int raise = sc.nextInt();
		out.println("Raise : " + raise);
		String sqlQuery = String.format("update employee set salary = salary + %d where salary < %d",raise,limit);
		out.println("1");
		umrd.getOracleConnection(sqlQuery);
		out.println("End of program");
	}
	
	public void getOracleConnection(String sqlQuery)
	{
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Class.forName(className);
			Statement st = con.createStatement();
			int updatedRows = st.executeUpdate(sqlQuery);
			out.println(updatedRows + " no of rows effected.");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

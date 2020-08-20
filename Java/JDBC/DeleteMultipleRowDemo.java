//Author : Gaurav Amarnani.

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteMultipleRowDemo 
{
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "system";
	String pass = "1234";
	String className = "oracle.jdbc.OracleDriver";
	
	public static void main(String...args)
	{
		Scanner sc = new Scanner(System.in);
		out.println("Enter the limit of Salary of Employee whose data you want to delete : ");
		int salary = sc.nextInt();
		String sqlQuery = String.format("delete from employee where salary > %d",salary);
		DeleteMultipleRowDemo dsrd = new DeleteMultipleRowDemo();
		dsrd.getOracleConnection(sqlQuery);
	}
	
	public void getOracleConnection(String sqlQuery)
	{
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Class.forName(className);
			Statement st = con.createStatement();
			int updatedRows = st.executeUpdate(sqlQuery);
			out.println(updatedRows + " no. of Record deleted successfully.");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

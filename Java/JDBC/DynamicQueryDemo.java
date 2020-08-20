//Author : Gaurav Amarnani.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import static java.lang.System.out;

public class DynamicQueryDemo 
{
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "system";
	String pass = "1234";
	String className = "oracle.jdbc.OracleDriver";
	
	public static void main(String...args)
	{
		DynamicQueryDemo dqd = new DynamicQueryDemo();
		Scanner sc = new Scanner(System.in);
		out.println("Enter ID : ");
		int id = sc.nextInt();
		out.println("Enter name : ");
		String name = sc.next();
		out.println("Enter Salary : ");
		int salary = sc.nextInt();
		out.println("Enter city name : ");
		String address = sc.next();
		String sqlQuery = String.format("insert into employee values(%d,'%s',%d,'%s')",id,name,salary,address);
		dqd.getOracleConnection(sqlQuery);
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

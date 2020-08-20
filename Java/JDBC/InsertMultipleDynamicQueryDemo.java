//Author : Gaurav Amarnani.

import static java.lang.System.out;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class InsertMultipleDynamicQueryDemo 
{
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "system";
	String pass = "1234";
	String className = "oracle.jdbc.OracleDriver";
	
	public static void main(String...args)
	{
		InsertMultipleDynamicQueryDemo imdqd = new InsertMultipleDynamicQueryDemo();
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			out.println("Enter ID : ");
			int id = sc.nextInt();
			out.println("Enter name : ");
			String name = sc.next();
			out.println("Enter Salary : ");
			int salary = sc.nextInt();
			out.println("Enter city name : ");
			String address = sc.next();
			String sqlQuery = String.format("insert into employee values(%d,'%s',%d,'%s')",id,name,salary,address);
			imdqd.getOracleConnection(sqlQuery);
			out.println("Do you want to add more data?");
			String choice = sc.next();
			if(choice.equalsIgnoreCase("No"))
			{
				out.println("Thanks for adding data. Program ended.");
				break;
			}
		}
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

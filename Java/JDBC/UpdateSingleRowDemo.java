//Author : Gaurav Amarnani.

import static java.lang.System.out;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class UpdateSingleRowDemo 
{
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "system";
	String pass = "1234";
	String className = "oracle.jdbc.OracleDriver";
	
	public static void main(String...args)
	{
		UpdateSingleRowDemo usrd = new UpdateSingleRowDemo();
		Scanner sc = new Scanner(System.in);
		out.println("Enter the ID of the employee : ");
		int id = sc.nextInt();
		out.println("Enter the new name for the employee : ");
		String name = sc.next();
		String sqlQuery = String.format("update employee set name = '%s' where id = %d",name,id);
		int number = usrd.getOracleConnection(sqlQuery,1);
		if(number == -1)
		{
			out.println("Enter proper ID. The provided ID was not found in the Database.");
		}
		if(number == 0)
		{
			out.println("Please enter a valid name.");
		}
	}
	
	public int getOracleConnection(String sqlQuery, int number)
	{
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Class.forName(className);
			Statement st = con.createStatement();
			int updatedRows = st.executeUpdate(sqlQuery);
			if(updatedRows == 0)
			{
				return -1;
			}
			else 
			{
				out.println(updatedRows + " no of rows effected.");
				return number;
			}
		}
		catch(Exception e)
		{
			out.println(e);
			return 0;
		}
	}
	
}

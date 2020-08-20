import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BatchUpdateUsingPreparedStatementDemo 
{
	public static void main(String...args)
	{
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String pass = "1234";
		String className = "oracle.jdbc.OracleDriver";
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Scanner sc = new Scanner(System.in); 
			Class.forName(className);
			PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?,?)");
			while(true)
			{
				out.println("Enter ID : \n");
				int id = sc.nextInt();
				out.println("Enter Name : \n");
				String name = sc.next();
				out.println("Enter Salary : \n");
				int salary = sc.nextInt();
				out.println("Enter Address : \n");
				String address = sc.next();
				pst.setInt(1, id);
				pst.setInt(3, salary);
				pst.setString(2, name);
				pst.setString(4, address);
				pst.addBatch();
				out.println("Do you want to continue? Enter 'No' to stop.\n");
				if(sc.next().equalsIgnoreCase("No"))
				{
					break;
				}
			}
			int updatedRows = 0;
			int[] count = pst.executeBatch();
			for(int each : count)
			{
				updatedRows = updatedRows + each;
			}
			out.println("The number of rows that were affected are : " + updatedRows);
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

} 

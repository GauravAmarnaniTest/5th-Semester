//Author : Gaurav Amarnani.
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchUpdateUsingStatementDemo 
{
	public static void main(String...args)
	{
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String pass = "1234";
		String className = "oracle.jdbc.OracleDriver";
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Class.forName(className);
			Statement st = con.createStatement();
			st.addBatch("insert into employee values(1,'Gaurav',10000,'NewYork')");
			st.addBatch("insert into employee values(2,'Archita',20000,'Chembur')");
			st.addBatch("insert into employee values(3,'Neha',30000,'Ghatkopar')");
			st.addBatch("insert into employee values(4,'Komal',40000,'Kurla')");
			st.addBatch("insert into employee values(5,'Vishnu',50000,'Chembur')");
			st.addBatch("insert into employee values(6,'Aryan',60000,'Kurla')");
			st.addBatch("insert into employee values(7,'Vaishnavi',70000,'Kurla')");
			st.addBatch("insert into employee values(7,'Bhatia',70000,'Ulhasnagar')");
			st.addBatch("insert into employee values(8,'Om',80000,'Ulhasnagar')");
			st.addBatch("update employee set salary = 1000000 where name = 'Gaurav'");
			st.addBatch("delete from employee where name = 'Vaishnavi'");
			int updatedRows = 0;
			int[] count = st.executeBatch();
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

//Author : Gaurav Amarnani.

import static java.lang.System.out;
import java.sql.DriverManager;
import java.sql.Connection;

public class TransactionIsolationDemo 
{
	public static void main(String...args)throws Exception
	{
		GetOracleConnection goc = new GetOracleConnection();
		String url = goc.getUrl();
		String user = goc.getUser();
		String pass = goc.getPass();
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			out.println("Default Isolation level : " + con.getTransactionIsolation());
			con.setTransactionIsolation(8);
			out.println("New Isolation level : " + con.getTransactionIsolation());
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

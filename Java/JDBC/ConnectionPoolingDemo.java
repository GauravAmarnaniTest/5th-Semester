//Author : Gaurav Amarnani.

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import static java.lang.System.out;

public class ConnectionPoolingDemo 
{
	public static void main(String...args) throws Exception
	{
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String pass = "1234";
		String className = "oracle.jdbc.OracleDriver";
		OracleConnectionPoolDataSource ds = new OracleConnectionPoolDataSource();
	  //DataSource ds = new MySQLConnectionPoolDatasource();
		ds.setURL(url);
		ds.setUser(user);
		ds.setPassword(pass);
		try(Connection con = ds.getConnection())
		{
			Class.forName(className);
			PreparedStatement pst = con.prepareStatement("select * from employee");
			ResultSet rs = pst.executeQuery();
			out.println("ID:\tNAME:\t\tSALARY:\tADDRESS:");
			while(rs.next())
			{
				out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getInt(3) + "\t" + rs.getString(4));
			}
			out.println("All records displayed successfully");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

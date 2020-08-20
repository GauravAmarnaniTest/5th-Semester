//To show Database connectivity even after closing the connection.

//Author : Gaurav Amarnani.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import static java.lang.System.out;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetDemo 
{
	public static void main(String...args)throws Exception
	{
		GetOracleConnection goc = new GetOracleConnection();
		String url = goc.getUrl();
		String user = goc.getUser();
		String pass = goc.getPass();
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from employee");
			RowSetFactory rsf = RowSetProvider.newFactory();
			CachedRowSet crs = rsf.createCachedRowSet();
			crs.populate(rs);
			out.println("Original Table Data with Connection : ");
			out.println("ID:\tNAME:\tSALARY:\tADDRESS:");
			while(crs.next())
			{
				out.println(crs.getInt(1) + "\t" + crs.getString(2) + "\t" + crs.getInt(3) + "\t" + crs.getString(4));
			}
			con.close();
			out.println("-----------------------------------------------");
			crs.beforeFirst();
			out.println("Original Table Data without Connection : ");
			out.println("ID:\tNAME:\tSALARY:\tADDRESS:");
			while(crs.next())
			{
				out.println(crs.getInt(1) + "\t" + crs.getString(2) + "\t" + crs.getInt(3) + "\t" + crs.getString(4));
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

//Author : Gaurav Amarnani.

import javax.sql.rowset.*;
import java.sql.*;
import static java.lang.System.out;

public class JoinRowSetDemo 
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
			RowSetFactory rsf = RowSetProvider.newFactory();
			ResultSet rs1 = st.executeQuery("select * from employeePrivate");
			CachedRowSet crs1 = rsf.createCachedRowSet();
			crs1.populate(rs1);			
			ResultSet rs2 = st.executeQuery("select * from employeePublic");
			CachedRowSet crs2 = rsf.createCachedRowSet();
			crs2.populate(rs2);
			JoinRowSet jrs = rsf.createJoinRowSet();
			jrs.addRowSet(crs1 , 1);
			jrs.addRowSet(crs2 , 1);
			out.println("ID:\tNAME:\tADDRESS:");
			while(jrs.next())
			{
				out.println(jrs.getString(1) + "\t" + jrs.getString(2) + "\t" + jrs.getString(3));
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

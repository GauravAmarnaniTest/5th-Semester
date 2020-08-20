//Author : Gaurav Amarnani.

import javax.sql.rowset.WebRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.io.File;
import java.io.FileReader;
import java.sql.DriverManager;
import java.sql.Connection;
import static java.lang.System.out;

/* To make this code work we have to make the following changes in the xml file.
 * change <deleteRow> with <deleteRow> , 
 * and change </deleteRow> with </deleteRow>.
 */

public class WebRowSetDeleteDemo 
{
	public static void main(String...args)throws Exception
	{
		GetOracleConnection goc = new GetOracleConnection();
		String url = goc.getUrl();
		String user = goc.getUser();
		String pass = goc.getPass();
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			RowSetFactory rsf = RowSetProvider.newFactory();
			WebRowSet wrs = rsf.createWebRowSet();
			wrs.setUrl(goc.getUrl());
			wrs.setUsername(goc.getUser());
			wrs.setPassword(goc.getPass());
			wrs.setCommand("select * from employee");
			wrs.execute(con);
			File f = new File("Employee1.xml");
			FileReader fr = new FileReader(f);
			wrs.readXml(fr);
			wrs.moveToCurrentRow();
			wrs.acceptChanges();
			out.println("Data deleted successfully.");
			fr.close();
			wrs.close();
			int x = 10;
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

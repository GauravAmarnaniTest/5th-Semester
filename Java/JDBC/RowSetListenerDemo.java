package com.jdbc.byGaurav;

import javax.sql.rowset.*;
import javax.sql.*;
import java.sql.*;
import static java.lang.System.out;

public class RowSetListenerDemo 
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
			wrs.setUrl(url);
			wrs.setUsername(user);
			wrs.setPassword(pass);
			wrs.setCommand("select * from employee");
			wrs.addRowSetListener(new RowSetListenerImplementation());
			wrs.execute();//---> rowSetChanged().
			out.println("Original Table Data with Connection : ");
			out.println("ID:\tNAME:\tSALARY:\tADDRESS:");
			while(wrs.next())
			{
				out.println(wrs.getInt(1) + "\t" + wrs.getString(2) + "\t" + wrs.getInt(3) + "\t" + wrs.getString(4));
				//---> cursorMoved().
			}
			wrs.moveToInsertRow();
			wrs.updateInt(1, 14);
			wrs.updateString(2, "Nikhil");
			wrs.updateInt(3, 14000);
			wrs.updateString(4, "Kurla");
			wrs.insertRow();
			//----> rowChanged().'
			wrs.moveToCurrentRow();
			wrs.acceptChanges();
			wrs.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
class RowSetListenerImplementation implements RowSetListener
{
	public void rowSetChanged(RowSetEvent re)
	{
		out.println("RowSet Changed.");
	}
	public void rowChanged(RowSetEvent re)
	{
		out.println("Row Changed.");
	}
	public void cursorMoved(RowSetEvent re)
	{
		out.println("Cursor Moved.");
	}
}

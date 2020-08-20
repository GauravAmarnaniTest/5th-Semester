package com.jdbc.byGaurav;

import javax.sql.rowset.WebRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;

public class WebRowSetInsertDemo 
{
	public static void main(String...args)throws Exception
	{
		GetOracleConnection goc = new GetOracleConnection();
		String url = goc.getUrl();
		String user = goc.getUser();
		String pass = goc.getPass();
		try
		{
			RowSetFactory rsf = RowSetProvider.newFactory();
			WebRowSet wrs = rsf.createWebRowSet();
			wrs.setUrl(goc.getUrl());
			wrs.setUsername(goc.getUser());
			wrs.setPassword(goc.getPass());
			wrs.setCommand("select * from employee");
			wrs.execute();
			File f = new File("Employee.xml");
			FileWriter fw = new FileWriter(f);
			wrs.writeXml(fw);
			out.println("Data inputed in file Employee.xml");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

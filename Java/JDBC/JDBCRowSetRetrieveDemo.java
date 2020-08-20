package com.jdbc.byGaurav;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.JdbcRowSet;
import static java.lang.System.out;

public class JDBCRowSetRetrieveDemo 
{
	public static void main(String...args)throws Exception
	{
		try
		{
			GetOracleConnection goc = new GetOracleConnection();
			RowSetFactory rsf = RowSetProvider.newFactory();
			JdbcRowSet jdbcrs = rsf.createJdbcRowSet();
			jdbcrs.setUrl(goc.getUrl());
			jdbcrs.setUsername(goc.getUser());
			jdbcrs.setPassword(goc.getPass());
			jdbcrs.setCommand("Select * from employee");
			jdbcrs.execute();
			out.println("The Original Table : ");
			out.println("ID:\tNAME:\tSALARY:\tADDRESS:");
			while(jdbcrs.next())
			{
				out.println(jdbcrs.getInt(1) + "\t" + jdbcrs.getString(2) + "\t" + jdbcrs.getInt(3) + "\t" + jdbcrs.getString(4));
			}
			out.println("-------------------------------------------");
			out.println("The Reversed form of Original Table : ");
			out.println("ID:\tNAME:\tSALARY:\tADDRESS:");
			while(jdbcrs.previous())
			{
				out.println(jdbcrs.getInt(1) + "\t" + jdbcrs.getString(2) + "\t" + jdbcrs.getInt(3) + "\t" + jdbcrs.getString(4));
			}
			out.println("-------------------------------------------");
			out.println("Accessing Data : ");
			jdbcrs.absolute(5);
			out.println(jdbcrs.getRow() + "--->" + jdbcrs.getInt(1) + "\t" + jdbcrs.getString(2) + "\t" + jdbcrs.getInt(3) + "\t" + jdbcrs.getString(4));
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

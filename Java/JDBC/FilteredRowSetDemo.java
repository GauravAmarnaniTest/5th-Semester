package com.jdbc.byGaurav;

import javax.sql.*;
import javax.sql.rowset.*;
import java.sql.*;
import static java.lang.System.out;

public class FilteredRowSetDemo 
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
			FilteredRowSet frs = rsf.createFilteredRowSet();
			frs.setUrl(url);
			frs.setUsername(user);
			frs.setPassword(pass);
			frs.setCommand("select * from employee");
			frs.execute();
			out.println("Data Before Filtering : ");
			out.println("---------------------------------");
			out.println("ID:\tNAME:\tSALARY:\tADDRESS:");
			while(frs.next())
			{
				out.println(frs.getInt(1) + "\t" + frs.getString(2) + "\t" + frs.getInt(3) + "\t" + frs.getString(4));
			}
			EmployeeSalaryFilter esf = new EmployeeSalaryFilter(5000,11000);
			frs.setFilter(esf);
			frs.beforeFirst();
			out.println("Data After Filtering : ");
			out.println("---------------------------------");
			out.println("ID:\tNAME:\tSALARY:\tADDRESS:");
			while(frs.next())
			{
				out.println(frs.getInt(1) + "\t" + frs.getString(2) + "\t" + frs.getInt(3) + "\t" + frs.getString(4));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
class EmployeeSalaryFilter implements Predicate 
{
	int high;
	int low;
	EmployeeSalaryFilter(int high , int low)
	{
		this.high = high;
		this.low = low;
	}
	public boolean evaluate(RowSet rs) 
	{
		boolean eval = false;
		try
		{
		FilteredRowSet frs = (FilteredRowSet) rs;
		int esal = frs.getInt(3);
		if(esal>high && esal<low)
		{
			eval = true;
		}
		else 
		{
			eval = false;
		}
		}
		catch(Exception e)
		{
			out.println(e);
		}
		return eval;
	}
	public boolean evaluate(Object value, int column) throws SQLException 
	{
		return false;
	}
	public boolean evaluate(Object value, String columnName) throws SQLException 
	{
		return false;
	}
}

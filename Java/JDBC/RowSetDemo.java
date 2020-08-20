package com.jdbc.byGaurav;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.WebRowSet;
import static java.lang.System.out;

public class RowSetDemo 
{
	public static void main(String...args) throws Exception
	{
		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet jdbcrs = rsf.createJdbcRowSet();
		CachedRowSet crs = rsf.createCachedRowSet();
		WebRowSet wrs = rsf.createWebRowSet();
		FilteredRowSet frs = rsf.createFilteredRowSet();
		JoinRowSet jrs = rsf.createJoinRowSet();
		out.println(rsf.getClass().getName());
		out.println(jdbcrs.getClass().getName());
		out.println(wrs.getClass().getName());
		out.println(crs.getClass().getName());
		out.println(frs.getClass().getName());
		out.println(jrs.getClass().getName());
	}
}

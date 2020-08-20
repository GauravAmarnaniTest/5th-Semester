//We can't Delete Data in the JDBCRowSet for Oracle Database.

//Author : Gaurav Amarnani.

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.JdbcRowSet;
import static java.lang.System.out;

import java.sql.ResultSet;

public class JDBCRowSetDeleteDemo 
{
	public static void main(String...args)
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
			jdbcrs.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
			jdbcrs.setConcurrency(ResultSet.CONCUR_UPDATABLE);
			out.println("Type : " + jdbcrs.getType());
			out.println("Concurrency : " + jdbcrs.getConcurrency());
			while(jdbcrs.next())
			{
				int salary = jdbcrs.getInt(3);
				if(salary > 100000)
				{
					jdbcrs.deleteRow();
					out.println("Row Deleted.");
				}
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
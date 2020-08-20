//We can't Update Data in the JDBCRowSet for Oracle Database.

//Author : Gaurav Amarnani.

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.JdbcRowSet;
import static java.lang.System.out;

public class JDBCRowSetUpdateDemo 
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
			out.println("Type : " + jdbcrs.getType());
			out.println("Concurrency : " + jdbcrs.getConcurrency());
			while(jdbcrs.next())
			{
				int salary = jdbcrs.getInt(3);
				if(salary < 70000)
				{
					salary = salary + 5555;
					jdbcrs.updateInt(3, salary);
					jdbcrs.updateRow();
					out.println("Final Success.");
				}
			}
			out.println("Success.");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
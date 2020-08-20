//We can't Insert Data in the JDBCRowSet for Oracle Database. 

//Author : Gaurav Amarnani.

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.JdbcRowSet;
import static java.lang.System.out;

public class JDBCRowSetInsertDemo 
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
			jdbcrs.setConcurrency(1008);
			out.println(jdbcrs.getConcurrency());
			jdbcrs.moveToInsertRow();
			jdbcrs.updateInt(1, 13);
			jdbcrs.updateString(1, "Gaurang");
			jdbcrs.updateInt(1, 130000);
			jdbcrs.updateString(4, "Thane");
			jdbcrs.insertRow();
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

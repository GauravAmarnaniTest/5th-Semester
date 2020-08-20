//We can't Delete Data in the JDBCRowSet for Oracle Database.

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.CachedRowSet;
import static java.lang.System.out;

import java.sql.ResultSet;

public class CachedRowSetDeleteDemo 
{
	public static void main(String...args)
	{
		try
		{
			GetOracleConnection goc = new GetOracleConnection();
			RowSetFactory rsf = RowSetProvider.newFactory();
			CachedRowSet crs = rsf.createCachedRowSet();
			crs.setUrl(goc.getUrl());
			crs.setUsername(goc.getUser());
			crs.setPassword(goc.getPass());
			crs.setCommand("Select * from employee");
			crs.execute();
			crs.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
			crs.setConcurrency(ResultSet.CONCUR_UPDATABLE);
			out.println("Type : " + crs.getType());
			out.println("Concurrency : " + crs.getConcurrency());
			while(crs.next())
			{
				int salary = crs.getInt(3);
				if(salary > 100000)
				{
					crs.deleteRow();
					out.println("Row Deleted.");
				}
			}
			crs.moveToCurrentRow();
			crs.acceptChanges();
			crs.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
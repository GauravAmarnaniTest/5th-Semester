import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.CachedRowSet;
import static java.lang.System.out;

public class CachedRowSetUpdateDemo 
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
			out.println("Type : " + crs.getType());
			out.println("Concurrency : " + crs.getConcurrency());
			while(crs.next())
			{
				int salary = crs.getInt(3);
				if(salary < 70000)
				{
					salary = salary + 5555;
					crs.updateInt(3, salary);
					crs.updateRow();
					out.println("Final Success.");
				}
			}
			crs.moveToCurrentRow();
			crs.acceptChanges();
			crs.close();
			out.println("Success.");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
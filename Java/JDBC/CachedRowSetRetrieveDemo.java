import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.CachedRowSet;
import static java.lang.System.out;

public class CachedRowSetRetrieveDemo 
{
	public static void main(String...args)throws Exception
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
			out.println("The Original Table : ");
			out.println("ID:\tNAME:\tSALARY:\tADDRESS:");
			while(crs.next())
			{
				out.println(crs.getInt(1) + "\t" + crs.getString(2) + "\t" + crs.getInt(3) + "\t" + crs.getString(4));
			}
			out.println("-------------------------------------------");
			out.println("The Reversed form of Original Table : ");
			out.println("ID:\tNAME:\tSALARY:\tADDRESS:");
			while(crs.previous())
			{
				out.println(crs.getInt(1) + "\t" + crs.getString(2) + "\t" + crs.getInt(3) + "\t" + crs.getString(4));
			}
			out.println("-------------------------------------------");
			out.println("Accessing Data : ");
			crs.absolute(5);
			out.println(crs.getRow() + "--->" + crs.getInt(1) + "\t" + crs.getString(2) + "\t" + crs.getInt(3) + "\t" + crs.getString(4));
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

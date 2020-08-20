//We can't Insert Data in the CachedRowSet for Oracle Database. 

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.CachedRowSet;
import static java.lang.System.out;
import javax.sql.rowset.spi.SyncProviderException;

public class CachedRowSetInsertDemo 
{
	public static void main(String...args)
	{
		try
		{
			GetOracleConnection goc = new GetOracleConnection();
			RowSetFactory rsf = RowSetProvider.newFactory();
			CachedRowSet crs = rsf.createCachedRowSet();
			crs.setUrl(goc.getUrl());//Error because of this extra String.
			crs.setUsername(goc.getUser());
			crs.setPassword(goc.getPass());
			crs.setCommand("Select * from employee");
			crs.execute();
			crs.moveToInsertRow();
			crs.updateInt(1, 13);
			crs.updateString(1, "Gaurang");
			crs.updateInt(1, 130000);
			crs.updateString(4, "Thane");
			crs.insertRow();
			out.println("Inserted Successfully");
			crs.moveToCurrentRow();
			out.println("Inserted Successfully");
			crs.acceptChanges();
			out.println("Successful");
		}
		catch(javax.sql.rowset.spi.SyncProviderException ee)
		{
			out.println(ee.getMessage());
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

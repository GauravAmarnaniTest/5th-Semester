import static java.lang.System.out;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

public class DatabaseMetaDataDemo1 
{
	public static void main(String...args)throws Exception
	{
		GetOracleConnection goc = new GetOracleConnection();
		String url = goc.getUrl();
		String user = goc.getUser();
		String pass = goc.getPass();
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			DatabaseMetaData dbmd = con.getMetaData();
			out.println("Database Product Name : " + dbmd.getDatabaseProductName());
			out.println("Database Product Version : " + dbmd.getDatabaseProductVersion());
			out.println("Database Major Version" + dbmd.getDatabaseMajorVersion());
			out.println("Database Minor Version" + dbmd.getDatabaseMinorVersion());
			out.println("JDBC Major Version" + dbmd.getJDBCMajorVersion());
			out.println("JDBC Minor Version" + dbmd.getJDBCMinorVersion());
			out.println("Driver Name : " + dbmd.getDriverName());
			out.println("Driver Major Version : " + dbmd.getDriverMajorVersion());
			out.println("Driver Minor Version" + dbmd.getDriverMinorVersion());
			out.println("URL : " + dbmd.getURL());
			out.println("Username : " + dbmd.getUserName());
			out.println("Max number of columns in a Table : " + dbmd.getMaxColumnsInTable());
			out.println("Max number of rows : " + dbmd.getMaxRowSize());
			out.println("Max number of letters in a Query : " + dbmd.getMaxStatementLength());
			out.println("Max number of Tables we can get in Select Query : " + dbmd.getMaxTablesInSelect());
			out.println("Max number of characters in a Table Name : " + dbmd.getMaxTableNameLength());
			out.println("SQL Keywords : " + dbmd.getSQLKeywords());
			out.println("Numeric Function : " + dbmd.getNumericFunctions());
			out.println("String Functions : " + dbmd.getStringFunctions());
			out.println("System Functions : " + dbmd.getSystemFunctions());
			out.println("Whether it supports Full Outer Join or not : " + dbmd.supportsFullOuterJoins());
			out.println("Whether it supports Stored Procedure or not : " + dbmd.supportsStoredProcedures());
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

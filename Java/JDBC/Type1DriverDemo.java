
/*
This program compiles fine but it does not work due to several reasons like : 
1.It is 13th Version of JDK , while Type1 driver works only till 1.7 Version.
2.This is Windows 10 but the Type1 Driver works only till Windows XP Version.
3.There is no "demodsn" configured file in this pc cause it does not provide the support to do so. 
*/

import static java.lang.System.out;
import java.sql.*;
class Type1DriverDemo1
{
	public static void main(String...args)
	{
		try(Connection con = DriverManager.getConnection("jdbc:odbc:demodsn","gaurav","1234"))
		{
			Class.forName("Sun.jdbc.odbc.JdbcOdbcDriver");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from movies");
			while(rs.next())
			{
				out.println("Movie Number : " + rs.getInt(1) +
					"\nMovie Name : " + rs.getString(2) + 
					"\nMovie Hero : " + rs.getString(3) + 
					"\nMovie Heroin : " + rs.getString(4)); 
			}	
		}
		catch(Exception e)
		{
			out.println("Some unknown error occured.\nRestarting the complete process.\nPlease wait.");
			main();
		}
	}
}	
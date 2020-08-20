//Author : Gaurav Amarnani.
/*
This program compiles fine but it does not work due to several reasons like :
1.There is no Database downloaded, so there are no Oracle classes or System ID (@XE) provided. 
*/

import static java.lang.System.out;
import java.sql.*;
class Type2DriverDemo1
{
	public static void main(String...args)
	{
		try(Connection con = DriverManager.getConnection("jdbc:oracle:oci:@XE","gaurav","1234"))
		{
			Class.forName("oracle.jdbc.OracleDriver");
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
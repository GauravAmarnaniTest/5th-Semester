//Author : Gaurav Amarnani.

/*

This program compiles fine but it does not work due to several reasons like :
1.There is no IDS Server installed in this PC.
2.There is no Database installed in this PC.
3.There is no configured file named "demodsn1".

*/
import java.sql.*;
import static java.lang.System.out;
class Type3DriverDemo1
{
	public static void main(Sting...args)
	{
		try(Connection con = DriverManager.getConnection("jdbc:ids://localhost:12/conn?dsn=demodsn1","gaurav","1234"))
		{
			Class.forName("ids.sql.IDSDriver");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from movies");
			while(rs.next())
			{
				out.println("Movie Number : " + rs.getInt(1)
					+ "\nMovie Name : " + rs.getString(2) 
					+ "\nHero Name : " + rs.getString(3)
					+ "\nHeroin Name : " + rs.getString(4));
			}
		}
		catch(Exception e)
		{
			out.println("Something went wrong. Restarting again. Please wait.");
			main();
		}
	}
}
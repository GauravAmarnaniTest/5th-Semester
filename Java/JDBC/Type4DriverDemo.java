import static java.lang.System.out;
import java.sql.*;
class Type4DriverDemo1
{
	public static void main(String...args)throws Exception
	{
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1121:XE","system","1234");
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
}
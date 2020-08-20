//Author : Gaurav Amarnani.

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.File;
import java.io.FileReader;
import static java.lang.System.out;

public class InsertCLOBDemo 
{
	public static void main(String...args)
	{
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String pass = "1234";
		String className = "oracle.jdbc.OracleDriver";
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			File f = new File("C:\\Users\\Gaurav\\Desktop\\Java Programming\\Collections Framework"
					+ "\\WeakHashMapDemo1.java");
			FileReader fr = new FileReader(f);
			PreparedStatement pst = con.prepareStatement("insert into programs values(?,?)");
			Class.forName(className);
			pst.setString(1, "WeakHashMapDemo1");
			pst.setCharacterStream(2, fr);
			out.println("Inserting file... " + f.getAbsolutePath());
			int count = pst.executeUpdate();
			if(count==1)
			{
				out.println("Row inserted.");
			}
			else
			{
				out.println("Row not inserted.");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

//Author : Gaurav Amarnani.

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.FileWriter;
import java.io.Reader;
import java.io.File;
import static java.lang.System.out;

public class RetrieveCLOBDemo 
{
	public static void main(String...args)throws Exception
	{
		File f = new File("test.txt");
		FileWriter fw = new FileWriter(f);
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String pass = "1234";
		String className = "oracle.jdbc.OracleDriver";
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Class.forName(className);
			PreparedStatement pst = con.prepareStatement("select * from programs where name = 'VectorDemo1'");
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				Reader r = rs.getCharacterStream(2);
				int i = r.read();
				while(i != -1)
				{
					fw.write(i);
					i = r.read();
				}
				fw.flush();
			}
			fw.close();
			out.println("File is available in : " + f.getAbsolutePath());
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

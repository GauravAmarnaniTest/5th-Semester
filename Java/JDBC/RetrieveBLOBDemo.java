//Author : Gaurav Amarnani.

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.File;
import static java.lang.System.out;

public class RetrieveBLOBDemo 
{
	public static void main(String...args)throws Exception
	{
		File f = new File("Gaurav_DB.png");
		FileOutputStream fos = new FileOutputStream(f);
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "system";
		String pass = "1234";
		String className = "oracle.jdbc.OracleDriver";
		try(Connection con = DriverManager.getConnection(url,user,pass))
		{
			Class.forName(className);
			PreparedStatement pst = con.prepareStatement("select * from persons where name = 'Gaurav'");
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				InputStream is = rs.getBinaryStream(2);
				byte[] buffer = new byte[2048];
				while(is.read(buffer)>0)
				{
					fos.write(buffer);
				}
				fos.flush();
			}
			fos.close();
			out.println("Image is available in : " + f.getAbsolutePath());
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}

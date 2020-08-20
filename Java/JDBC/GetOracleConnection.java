//Author : Gaurav Amarnani.

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class GetOracleConnection 
{
	public static void main(String...args)throws Exception 
	{
		GetOracleConnection g = new GetOracleConnection();
	}
	
	private String url;
	private String user;
	private String pass;

	GetOracleConnection() throws Exception
	{
		Properties p = new Properties();
		File f = new File("C:\\Users\\Gaurav\\Desktop\\Java Programming\\Collections Framework\\db.txt");
		FileInputStream fis = new FileInputStream(f);
		p.load(fis);
		setUrl(p.getProperty("url"));
		setUser(p.getProperty("user"));
		setPass(p.getProperty("pass"));	
	}

	private void setUrl(String url){
		this.url = url;
	}
	public String getUrl() {
		return url;
	}
	
	private void setUser(String user){
		this.user = user;
	}
	public String getUser() {
		return user;
	}
	
	private void setPass(String pass){
		this.pass = pass;
	}
	public String getPass() {
		return pass;
	}
}

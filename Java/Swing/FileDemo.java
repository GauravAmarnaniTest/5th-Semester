//Author : Gaurav Amarnani. 

//Importing : 
import java.io.*;

//Main Class :
public class FileDemo 
{
	public static void main(String...args)
	{
		File f = new File("abc.txt");
		out.println(f.exists());
		f.createNewFile();
		out.println(f.exists());
	}
} 
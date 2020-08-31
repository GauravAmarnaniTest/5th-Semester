//Author : Gaurav Amarnani.

import java.awt.*;
import java.applet.*;
import static java.lang.System.out;
import java.util.Date;
/*
<applet code="AppletDemo.class" width="400" height="400">
</applet>
*/

public class AppletDemo extends Applet 
{
	long start , end;
	public void init()
	{
		setBackground(Color.BLACK);
		start = System.currentTimeMillis( );
		try
		{
			//Thread.sleep(1000);
		}
		catch(Exception e)
		{
			out.println("Opsie.");
		}
	}
	public void start()
	{
		setBackground(Color.YELLOW);
		end = System.currentTimeMillis( );
            	long diff = end - start;
            	out.println("Difference is : " + diff);
	}
	public void paint(Graphics g)
	{
		//out.println("----->paint().");
	}
	public void stop()
	{
		//out.println("----->stop().");
	}
	public void destroy()
	{
		//out.println("----->destroy().");
	}
}
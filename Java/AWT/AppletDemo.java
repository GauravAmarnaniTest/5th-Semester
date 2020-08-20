//Author : Gaurav Amarnani.

import java.awt.*;
import java.applet.*;
import static java.lang.System.out;

/*
<applet code="AppletDemo.class" width="100" height="100">
</applet>
*/

public class AppletDemo extends Applet 
{
	public void init()
	{
		setBackground(Color.BLACK);
		setForeground(Color.YELLOW);
		out.println("----->init().");
	}
	public void start()
	{
		out.println("----->start().");
	}
	public void paint(Graphics g)
	{
		out.println("----->paint().");
	}
	public void stop()
	{
		out.println("----->stop().");
	}
	public void destroy()
	{
		out.println("----->destroy().");
	}
}
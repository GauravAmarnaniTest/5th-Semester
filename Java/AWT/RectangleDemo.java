//Performed by Gaurav Amarnani.
import java.awt.*;
import java.applet.*;
/*
<applet code="RectangleDemo" width="1000" height="1000">
</applet>
*/
public class RectangleDemo extends Applet
{
	public void paint(Graphics g)
	{
		g.drawRect(0,0,1000,500);
		g.fillRect(0,500,1000,500);
		g.drawString("This is a white Rectangle." , 0 , 10);
		g.drawString("This is a black Rectangle." , 0 , 500);
	}
}
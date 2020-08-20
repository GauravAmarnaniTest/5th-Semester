//Author : Gaurav Amarnani.
import java.awt.*;
import java.applet.*;
/*
<applet code="LineDemo" width=1000 height=1000>
</applet>
*/
public class LineDemo extends Applet
{
	public void paint(Graphics g)
	{
		g.drawLine(0,500,1000,500);
		g.drawLine(500,0,500,1000);
	}
}
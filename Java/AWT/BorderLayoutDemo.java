//Performed by Gaurav Amarnani.
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="BorderLayoutDemo" width=500 height=500>
</applet>
*/

public class BorderLayoutDemo extends Applet
{
	public void init() 
    	{
		setLayout(new BorderLayout());
        	add(new Label("North Border Layout."), BorderLayout.NORTH);
        	add(new Label("South Border Layout."), BorderLayout.SOUTH);
        	add(new Label("East Border Layout."), BorderLayout.EAST);
        	add(new Label("West Border Layout."), BorderLayout.WEST);
        	String msg = "Center Border Layout";
        	add(new TextArea(msg), BorderLayout.CENTER);
    	}
}

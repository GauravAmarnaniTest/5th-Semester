//Performed by Gaurav Amarnani.
import java.applet.*;
import java.awt.*;

/*
<applet code="LabelDemo" width=1000 height=1000>
</applet>
*/

public class LabelDemo extends Applet 
{

    public void init() 
    {
        Label l = new Label("This is an example of Label.");
	add(l);
    }
    
    public void paint(Graphics g)
    {
	g.drawLine(0,30,1000,30);
    }
}
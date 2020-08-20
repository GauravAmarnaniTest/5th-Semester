//Performed by Gaurav Amarnani.
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="FlowLayoutDemo" width=1000 height=1000>
</applet>
*/

public class FlowLayoutDemo extends Applet 
{
	public void init()
	{
		//Example of using FlowLayout with Left Alignment.
        	setLayout(new FlowLayout(FlowLayout.LEFT));
        	Label lleft = new Label("This is a Left Layout.");
        	add(lleft);
		
		//Example of using FlowLayout with Right Alignment.
        	//setLayout(new FlowLayout(FlowLayout.RIGHT));
        	//Label lright = new Label("This is a Right FlowLayout.");
        	//add(lright);
		
		//Example of using FlowLayout with Center Alignment.
        	//setLayout(new FlowLayout(FlowLayout.CENTER));
        	//Label lcenter = new Label("This is a Center FlowLayout.");
        	//add(lcenter);
		
	} 
}
//Author : Gaurav Amarnani.

import javax.swing.*;
import java.awt.*;

/*
<applet code="JTextAreaDemo.class" width="1000" height="1000">
</applet>
*/

public class JTextAreaDemo extends JApplet 
{
	public void start()
	{
		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());
		JTextArea jtf = new JTextArea("You can type here.",20,20);
		ct.add(jtf);
	}
} 
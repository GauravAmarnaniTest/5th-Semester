//Author : Gaurav Amarnani.

import javax.swing.*;
import java.awt.*;

/*
<applet code="JTextFieldDemo.class" width="1000" height="1000">
</applet>
*/

public class JTextFieldDemo extends JApplet 
{
	public void init()
	{
		setBackground(Color.BLACK);
		setForeground(Color.YELLOW);
	}
	public void start()
	{
		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());
		JTextField jtf = new JTextField("You can type here.",20);
		ct.add(jtf);
		setBackground(Color.BLACK);
		setForeground(Color.YELLOW);
	}
} 
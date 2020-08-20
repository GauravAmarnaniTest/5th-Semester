//Author : Gaurav Amarnani.

import javax.swing.*;
import java.awt.*;

/*
<applet code="JAppletDemo.class" width="400" height="400">
</applet>
*/

public class JAppletDemo extends JApplet 
{
	public void start()
	{
		Container ct = getContentPane();
		JLabel jl = new JLabel("JApplet class extends Applet class of AWT package.");
		add(jl);
	}
}
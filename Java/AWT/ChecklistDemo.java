//Performed by Gaurav Amarnani.
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="CheckboxGroupDemo" width=1000 height=1000>
</applet>
*/

public class CheckboxGroupDemo extends Applet implements ItemListener
{
	String msg;
	Checkbox Java, Python, C, JavaScript;
	CheckboxGroup language;
	public void init()
	{
		language = new CheckboxGroup();
		Java = new Checkbox("Java Programming language.", language, true);
		Python = new Checkbox("Python.", language, false);
		C = new Checkbox("C.", language, false);
		JavaScript = new Checkbox("JavaScript.", language, false);
		add(Java);
		add(Python);
		add(C);
		add(JavaScript);
		Java.addItemListener(this);
		Python.addItemListener(this);
		C.addItemListener(this);
		JavaScript.addItemListener(this);
	}
	public void itemStateChanged(ItemEvent ie)
	{
		repaint();
	}
	// Display current state of the check boxes.
	public void paint(Graphics g)
	{
		msg = "Select a programming language : ";
		msg += cbg.getSelectedCheckbox().getLabel();
		g.drawString(msg, 6, 100);
	}
}
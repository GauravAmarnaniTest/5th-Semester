//Author : Gaurav Amarnani.
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
		Java = new Checkbox("Java Programming language.", language, false);
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

	public void paint(Graphics g)
	{
		g.drawString("List of Programming languages : " , 10, 20);
		g.drawLine(0,30,1000,30);
		msg = "Selected programming language : ";
		msg += language.getSelectedCheckbox().getLabel();
		g.drawString(msg, 10, 100);
		if(language.getSelectedCheckbox().getLabel().equalsIgnoreCase("Java Programming language."))
		{
			g.drawString("Nice choice!" , 10, 120);
		}
	}
}
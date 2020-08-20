//Performed by Gaurav Amarnani.
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="ButtonDemo" width=1000 height=1000>
</applet>
*/

public class ButtonDemo extends Applet implements ActionListener
{
	Button yes , no , maybe;
	String msg;
    	public void init() 
    	{
        	Label l = new Label("Choose any one from below: ");
        	yes = new Button("Yes");
        	no = new Button("No");
        	maybe = new Button("Maybe");
        	add(yes);
        	add(no);
        	add(maybe);
        	yes.addActionListener(this);
        	no.addActionListener(this);
        	maybe.addActionListener(this);
        	add(l);
		add(yes);
		add(no);
		add(maybe);
	}
   
    	public void actionPerformed(ActionEvent e) 
    	{
		String str = e.getActionCommand();
        	if(str.equalsIgnoreCase("yes"))
        	{
        		msg = "You have pressed Yes.";
        	}
        	else if(str.equalsIgnoreCase("no"))
        	{
        	 	msg = "You have pressed No.";
        	}
        	else
        	{
        		msg = "You have pressed Maybe.";
        	}
		repaint();
    	}

    	public void paint(Graphics g)
    	{
		g.drawLine(0,50,1000,50);
		g.drawString(msg,500,500);
    	}
}

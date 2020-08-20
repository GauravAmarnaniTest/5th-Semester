//Performed by Gaurav Amarnani.
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="CheckboxDemo" width=1000 height=1000>
</applet>
*/

public class CheckboxDemo extends Applet implements ItemListener
{
    Checkbox Java , Python , C , HTML , JavaScript;
    String msg;
    public void init() 
    {
        Label l = new Label("Choose your favorite languages from below : ");
        add(l);
        Java = new Checkbox("Java");
        Python = new Checkbox("Python");
        C = new Checkbox("C");
        HTML = new Checkbox("HTML");
        JavaScript = new Checkbox("JavaScript");
        add(Java);
        add(Python);
        add(C);
        add(HTML);
        add(JavaScript);
        Java.addItemListener(this);
        Python.addItemListener(this);
        C.addItemListener(this);
        HTML.addItemListener(this);
        JavaScript.addItemListener(this);
    }
    
    public void paint(Graphics g)
    {
        String msg = "Your Choice : ";
        String choice = "Java : " + Java.getState();
        g.drawString(choice , 20 , 50);
        choice = "Python : " + Python.getState();
        g.drawString(choice, 20, 70);
        choice = "C : " + C.getState();
        g.drawString(choice , 20 , 90);
        choice = "HTML : " + HTML.getState();
        g.drawString(choice, 20, 110);
        choice = "JavaScript : " + JavaScript.getState();
        g.drawString(choice , 20 , 130);
        if(HTML.getState())
        {
            g.drawString("You Chose HTML. Seriously! Get a life." , 400 , 150);
        }
	g.drawLine(0,30,1000,30);
    }

    public void itemStateChanged(ItemEvent e) 
    {
        repaint();
    }
}

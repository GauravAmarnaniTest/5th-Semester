//Performed by Gaurav Amarnani.
import java.applet.*;
import java.awt.*;

/*
<applet code="GridLayoutDemo.java" height="600" width="900">
</applet>
*/

public class GridLayoutDemo extends Applet
{
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
	public void init()
	{
		setLayout(new GridLayout(5,3,10,10));
		setFont(new Font("SansSerif", Font.BOLD, 48));
		l1 = new Label("Name : ");
		l2 = new Label("Roll no. ");
		l3 = new Label("Address : ");
		l4 = new Label("Gaurav.");
		l5 = new Label("01.");
		l6 = new Label("Ulhasnagar.");
		l7 = new Label("Archita.");
		l8 = new Label("02.");
		l9 = new Label("Chembur.");
		l10 = new Label("Neha.");
		l11 = new Label("03.");
		l12 = new Label("Ghatkopar.");
		l13 = new Label("Komal.");
		l14 = new Label("04.");
		l15 = new Label("Kurla.");
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);	
		add(l9);
		add(l10);
		add(l11);
		add(l12);
		add(l13);
		add(l14);
		add(l15);		
	}
	public void paint(Graphics g)
	{
		g.drawLine(0,80,900,80);
	}
}
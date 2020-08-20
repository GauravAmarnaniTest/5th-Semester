//Performed by Gaurav Amarnani.
import java.awt.*;
import java.applet.*;

/*
<applet code="Exp_1.java" width="600" height="200">
</applet>
*/

public class Exp_1 extends Applet 
{
	public void init()
	{	
		setLayout(new GridLayout(2,3,10,10));
		setFont(new Font("SansSerif", Font.BOLD, 20));
		Label l1 = new Label("Choose OS : ");
		Checkbox w = new Checkbox("Window.");
		Checkbox l = new Checkbox("Linux.");
		CheckboxGroup g2 = new CheckboxGroup();
		Label l2 = new Label("Choose a gender : ");
		Checkbox m = new Checkbox("Male." , g2 , true);
		Checkbox f = new Checkbox("Female." , g2 , false);
		add(l1);
		add(w);
		add(l);
		add(l2);
		add(m);
		add(f);
	}
}
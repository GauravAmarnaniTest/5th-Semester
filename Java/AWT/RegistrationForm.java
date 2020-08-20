//Performed by Gaurav Amarnani.
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

//<applet code="RegistrationForm.java" height="250" width="230"></applet>

public class RegistrationForm extends Applet implements ActionListener
{
	String fname = " " , sname = " " , gender = " ";
	int age;
	TextField fn = new TextField(15);
	TextField sn = new TextField(15);
	CheckboxGroup g = new CheckboxGroup();
	Checkbox m = new Checkbox("Male" , g , true);
	Checkbox f = new Checkbox("Female" , g , false);
	Choice c = new Choice();
	Label l = new Label("REGISTRATION FORM : ");
	Label l1 = new Label("Enter First Name : ");
	Label l2 = new Label("Enter Second Name : ");
	Label l3 = new Label("Select Gender : ");
	Label l4 = new Label("Age : ");
	Button b1 = new Button("Submit.");
	Label l5 = new Label(" ");  
	public void init()
	{
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(l);
		add(l1);
		add(fn);
		add(l2);
		add(sn);
		add(l3);
		add(m);
		add(f);
		add(l4);
		add(c);
		c.add("18");
		c.add("19");
		c.add("20");
		c.add("21");
		add(b1);
		add(l5);
		b1.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		fname = fn.getText();
		sname = sn.getText();
		gender = g.getSelectedCheckbox().getLabel();
		age = Integer.parseInt(c.getSelectedItem());
		l5.setText("SUCCESS");
		repaint();
	}
}

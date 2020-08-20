//Performed by Gaurav Amarnani
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="Exp_3.java" width="1500" height="670">
</applet>
*/

public class Exp_3 extends Applet implements ActionListener
{
	Label lhead , lname , lgender , lstate , lhobby , laddress;
	Label dhead , dname , dgender , dstate , dhobby , daddress;
	Label uname , ugender , ustate , uhobby , uaddress , greeting;
	TextField tname;
	CheckboxGroup gen;
	Checkbox male , female;
	Choice st ,hob;
	TextArea add , uadd;
	Button submit;
	public void init()
	{
		setLayout(null);
		setFont(new Font("SansSerif", Font.BOLD, 20));

		//Getting Data.
		//Heading.
		lhead = new Label("Enter all your details: ");
		
		//Name.
		lname = new Label("Name :");
		tname = new TextField();
		
		//Gender.
		lgender = new Label("Gender : ");
		gen = new CheckboxGroup();
		male = new Checkbox("Male." , gen , true);
		female = new Checkbox("Female." , gen , false);
		
		//State.
		lstate = new Label("State : ");
		st = new Choice();
		st.add("Maharashtra.");
		st.add("Goa.");
		st.add("Karnataka.");
		st.add("Rajasthan.");
		st.add("Delhi.");
		st.add("Madhya Pradesh.");
		st.add("Uttar Pradesh.");
		
		//Hobby.
		lhobby = new Label("Hobby : ");
		hob = new Choice();
		hob.add("Coding.");
		hob.add("Reading.");
		hob.add("Writing.");
		hob.add("Singing.");
		hob.add("Dancing.");
		hob.add("None.");
		
		//Address.
		laddress = new Label("Address : ");
		add = new TextArea();
		
		//Submit.
		submit = new Button("Submit.");
	
		//Setting Location and Size.
		lhead.setBounds(20,15,220,30);
		lname.setBounds(20,60,100,30);
		tname.setBounds(130,60,200,30);
		lgender.setBounds(20,115,100,30);
		male.setBounds(130,120,100,20);
		female.setBounds(250,120,100,20);
		lstate.setBounds(20,155,100,30);
		st.setBounds(130,155,200,30);
		lhobby.setBounds(20,200,100,30);
		hob.setBounds(130,200,100,30);
		laddress.setBounds(20,370,100,30);
		add.setBounds(130,250,500,300);
		submit.setBounds(300,600,150,30);
		
		//Adding Components.
		add(lhead);
		add(lname);
		add(tname);
		add(lgender);
		add(male);
		add(female);
		add(st);
		add(lstate);
		add(lhobby);
		add(hob);
		add(laddress);
		add(add);
		add(submit);
		submit.addActionListener(this);


		//Displaying Data.
		//Heading.
		dhead = new Label("Get all your Data : ");

		//Name.
		dname = new Label("Name : ");
		uname = new Label();

		//Gender.
		dgender = new Label("Gender : ");
		ugender = new Label();

		//State.
		dstate = new Label("State : ");
		ustate = new Label();

		//Hobby.
		dhobby = new Label("Hobby : ");
		uhobby = new Label();

		//Address.
		daddress = new Label("Address : ");
		uadd = new TextArea();

		//Greeting.
		greeting = new Label("Thankyou for Visiting. Take Care.");
		
		//Setting Location and Size.
		dhead.setBounds(770,15,220,30);
		dname.setBounds(770,60,100,30);
		dgender.setBounds(770,100,100,30);
		dstate.setBounds(770,140,100,30);
		dhobby.setBounds(770,180,100,30);
		daddress.setBounds(770,220,100,30);
		uname.setBounds(900,60,300,30);
		ugender.setBounds(900,100,100,30);
		ustate.setBounds(900,140,200,30);
		uhobby.setBounds(900,180,100,30);
		uadd.setBounds(900,220,500,300);
		greeting.setBounds(970,600,350,30);
		
		//Adding Components.
		add(dhead);
		add(dname);
		add(dgender);
		add(dstate);
		add(dhobby);
		add(daddress);
		add(uname);
		add(ugender);
		add(ustate);
		add(uhobby);
		add(uadd);
		add(greeting);
		greeting.setVisible(false);
		uadd.setVisible(false);
	}
	public void paint(Graphics g)
	{
		g.drawLine(0,50,1500,50);
		g.drawLine(750,0,750,670);
	}
	public void actionPerformed(ActionEvent e) 
    	{
		String name , gender , state , hobby , address;
		name = tname.getText();
		gender = gen.getSelectedCheckbox().getLabel();
		state = st.getSelectedItem();
		hobby = hob.getSelectedItem();
		address = add.getText();
		
		uname.setText(name);
		ugender.setText(gender);
		ustate.setText(state);
		uhobby.setText(hobby);
		uadd.setText(address);
		uadd.setEditable(false);
		uadd.setVisible(true);
		greeting.setVisible(true);
		repaint();
    	}	
}
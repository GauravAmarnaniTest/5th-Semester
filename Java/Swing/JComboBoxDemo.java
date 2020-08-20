//Author : Gaurav Amarnani.

import javax.swing.*;
import java.awt.*;

/*
<applet code="JComboBoxDemo.class" width="550" height="450">
</applet>
*/

public class JComboBoxDemo extends JApplet
{
	public void start()
	{
		Container ct = getContentPane();
		ct.setLayout(null);
		setFont(new Font("SansSerif", Font.BOLD, 40));
		JLabel jl = new JLabel("List of World War 2 Countries : ");
		//Creating Axis JComboBox. 
		JLabel axisl = new JLabel("Select Axis Nation : ");
		JComboBox axiscb = new JComboBox();
		axiscb.addItem("Germany.");
		axiscb.addItem("Japan.");
		axiscb.addItem("Italy.");
		
		//Creating Allies JComboBox.
		JLabel alliesl = new JLabel("Select Allied Nation : ");
		JComboBox alliescb = new JComboBox();
		alliescb.addItem("USA.");
		alliescb.addItem("UK.");
		alliescb.addItem("France.");
		alliescb.addItem("British Raj.");

		//Creating Commintern JComboBox.
		JLabel comminternl = new JLabel("Select Commintern Nation : ");
		JComboBox comminterncb = new JComboBox();
		comminterncb.addItem("Soviet.");
		comminterncb.addItem("China.");
		comminterncb.addItem("Tanu Tuva.");
		comminterncb.addItem("Mongolia.");
		
		//Setting Alignment.
		jl.setBounds(100,50,400,40);
		axisl.setBounds(100,100,200,40);
		axiscb.setBounds(350,100,100,40);
		alliesl.setBounds(100,200,200,40);
		alliescb.setBounds(350,200,100,40);
		comminternl.setBounds(100,300,200,40);
		comminterncb.setBounds(350,300,100,40);
		
		//Adding Components
		add(jl);
		add(axisl);
		add(axiscb);
		add(alliesl);
		add(alliescb);
		add(comminternl);
		add(comminterncb);
	}
}
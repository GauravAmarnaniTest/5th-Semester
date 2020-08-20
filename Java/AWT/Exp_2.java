//Author : Gaurav Amarnani.
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;
import static java.lang.System.out;

/*
<applet code="Exp_2.java" width="900" height="350">
</applet>
*/

public class Exp_2 extends Applet implements ActionListener
{
	TextArea t = new TextArea();
	String address;
	public void init()
	{	
		setLayout(null);
		setFont(new Font("SansSerif", Font.BOLD, 20));
		Label l = new Label("Enter Address : ");
		l.setBounds(20,20,150,30);
		add(l);	
		t.setBounds(200,20,500,300);
		add(t);
		Button b = new Button("Submit.");
		b.setBounds(720,150,150,30);
		add(b);
		b.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) 
    	{
		address = t.getText();
		try
		{
			Date d = new Date();
			File f = new File("C:\\Users\\Gaurav\\Desktop\\Java Programming\\AWT\\AddressInfo.txt");
        		FileWriter fw = new FileWriter(f,true);
        		fw.write("\nTime of submission : " + d + "\nAddress : " + address + "\n");
        		fw.close();
			t.setText("Successfully Recorded Response!");
		}
		catch(IOException ioe)
		{
			out.println("Some exception occurred. \n" + ioe);
		}
		repaint();
    	}
	public void paint(Graphics g)
	{
		g.drawString("Address : " + address, 20 , 500);
	}
}
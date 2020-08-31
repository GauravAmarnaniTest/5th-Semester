//Author : Gaurav Amarnani.

import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

class DisplayMarksheet extends JFrame
{
	public static void main(String...args)
	{
		DisplayMarksheet g = new DisplayMarksheet ();
		g.setVisible(true);
		g.setSize(1300,400);
		g.setLocation(100,250);
		g.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		g.setTitle("Marksheet.");
	}
	JTable t;
	public DisplayMarksheet()
	{		
        	Font f = new Font("Comics Sans MS" , Font.BOLD , 22);
		Container c = this.getContentPane();
		c.setLayout(null);

		JLabel lname = new JLabel("Name           : ");
		lname.setFont(f);
		lname.setBounds(20, 20, 200, 30);
		JLabel uname = new JLabel("Guarav Amarnani.");
		uname.setFont(f);
		uname.setBounds(250, 20, 400, 30);
					
					
		JLabel lpercentage = new JLabel("Percentage  : ");
		lpercentage.setFont(f);
		lpercentage.setBounds(20, 50, 200, 30);
		JLabel upercentage = new JLabel("95.20%.");
		upercentage.setFont(f);
		upercentage.setBounds(250, 50, 400, 30);


		JLabel lcourse = new JLabel("Course         : ");
		lcourse.setFont(f);
		lcourse.setBounds(20,80, 200, 30);
		JLabel ucourse = new JLabel("Computer Engineering.");
		ucourse.setFont(f);
		ucourse.setBounds(250,80, 400, 30);


		JLabel lsemester = new JLabel("Semester     : ");
		lsemester.setFont(f);
		lsemester.setBounds(20,110, 200, 30);
		JLabel usemester = new JLabel("Fourth.");
		usemester.setFont(f);
		usemester.setBounds(250,110, 400, 30);


        	String[] columnNames = {"Title of Course : " , "Max Marks : " , "Obtained Marks : " , "Credit :"};
		Object[][] data = {
			{"JAVA PROGRAMMING."  , 100 , 95 , 7} ,
			{"SOFTWARE ENGINEERING." , 100,  95, 5},
			{"DATA COMMUNICATION." , 100, 93, 6},
			{"MICROPROCESSORS." , 100, 93, 6},
			{"GUI APP DEVELOPMENT." , 100, 96, 6},
		}; 
		DefaultTableModel dtm = new DefaultTableModel(data , columnNames);
        	t = new JTable();
        	t.setModel(dtm);
		t.setRowHeight(30);
		TableColumnModel tcm = t.getColumnModel();
        	tcm.getColumn(0).setPreferredWidth(250);
        	tcm.getColumn(1).setPreferredWidth(250);
        	tcm.getColumn(2).setPreferredWidth(250);
        	tcm.getColumn(3).setPreferredWidth(250);
		t.setEnabled(false);
        	t.setPreferredScrollableViewportSize(new Dimension(1250,150));
        	t.setFillsViewportHeight(true);
		t.setFont(f);
		JScrollPane sp = new JScrollPane(t);
		sp.setEnabled(false);
		sp.setFont(f);
		sp.setBounds(20, 150, 1250, 173);
		add(lname);
		add(lpercentage);
		add(lcourse);
		add(lsemester);
		add(uname);
		add(upercentage);
		add(ucourse);
		add(usemester);
		add(sp);
	}
}
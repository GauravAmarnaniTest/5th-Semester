//Performed by Gaurav Amarnani
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="CardLayoutDemo.java" height="500" width="500">
</applet>
*/

public class CardLayoutDemo extends Applet implements ActionListener , MouseListener
{
	Button border , grid; 
	Panel borderPanel , gridPanel , mainPanel;
	CardLayout cl;
	public void init()
	{
		border = new Button("Border.");
		grid = new Button("Grid.");
		cl = new CardLayout();
		
		
		//Border Layout.
		setLayout(new BorderLayout());
		add(border , BorderLayout.WEST);
		add(grid , BorderLayout.EAST);
		add(mainPanel , BorderLayout.CENTER);
		border.addActionListener(this);
		grid.addActionListener(this);

		gridPanel = new Panel(new GridLayout(2,2));
		//adding components to Grid Panel.
		gridPanel.add(new Button("Button 1."));
		gridPanel.add(new Button("Button 2."));
		gridPanel.add(new Button("Button 3."));
		gridPanel.add(new Button("Button 4."));
		
		borderPanel = new Panel(new BorderLayout());
		//adding components to Border Panel.
		borderPanel.add(new Button("Button 1.") , BorderLayout.NORTH);
		borderPanel.add(new Button("Button 2.") , BorderLayout.SOUTH);
		borderPanel.add(new Button("Button 3.") , BorderLayout.CENTER);
		
		mainPanel = new Panel(cl);
		//adding Border and Grid Panels to Main Panel
		mainPanel.add(gridPanel , "Grid");
		mainPanel.add(borderPanel , "Border");
	}
	
	public void mousePressed(MouseEvent me)
	{
		cl.next(borderPanel);
	}
	
	public void mouseEntered(MouseEvent me)
	{
		
	}
		
	public void mouseClicked(MouseEvent me)
	{
		
	}

	public void mouseExited(MouseEvent me)
	{
		
	}
	
	public void mouseReleased(MouseEvent me)
	{
		
	}
	
	public void actionPerformed(ActionEvent ae) 
    	{
		if(ae.getSource() == border)
		{
			cl.show(borderPanel , "Border");
		}
		else
		{
			cl.show(gridPanel , "Grid");
		}
		repaint();
    	}
}
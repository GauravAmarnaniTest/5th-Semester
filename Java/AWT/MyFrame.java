//Author : Gaurav Amarnani.
import java.awt.*;
import java.awt.Frame;

class MyFrame extends Frame
{
	MyFrame()
	{
		
	}
	public static void main(String...args)
	{
		MyFrame frame = new MyFrame();
		frame.setSize(200,200);
		frame.setVisible(true);
		frame.setTitle("Frame Demo.");
	}
	
}
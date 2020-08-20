//Author : Gaurav Amarnani.
import java.awt.*;
import java.applet.*;

/*
<applet code="TextAreaDemo.java" width="500" height="500">
</applet>
*/

public class TextAreaDemo extends Applet 
{
	public void init()
	{
		TextArea t = new TextArea("Gaurav Amarnani is a genius.");
		add(t);
		t.setEditable(false);
	}
}
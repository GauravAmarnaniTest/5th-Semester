//Author : Gaurav Amarnani.

package com.byGaurav;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo extends JFrame 
{
	public static void main(String...args)
	{
		JFrameDemo jfd = new JFrameDemo();
		jfd.setSize(500,500);
		jfd.setVisible(true);
		jfd.setTitle("JFrame Demo.");
		jfd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	 public JFrameDemo()
	{
		Container ct = getContentPane();
		JLabel jl = new JLabel("Swing Components have a pluggable look and feel.");
		ct.add(jl);
	}
} 
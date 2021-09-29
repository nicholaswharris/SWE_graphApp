package edu.unca.csci338.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

public class ColorController implements ActionListener
{
	
	private Container pane;
	private Color color;

	public ColorController(JFrame frame, Color color)
	{
		super();
		this.color = color;
		this.pane = frame.getContentPane();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.pane.setBackground(this.color);
	}

}

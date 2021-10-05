package edu.unca.csci338.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

import edu.unca.csci338.ColorModel;

public class ColorController implements ActionListener {
	private Container pane;
	private ColorModel colorModel;
	private Color color;

	public ColorController(ColorModel colorModel, JFrame frame, Color color) {
		super();
		this.pane = frame.getContentPane();
		this.colorModel = colorModel;
		this.color = color;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (colorModel.getColor() != this.color) {
			this.pane.setBackground(this.color);
		}
	}
}

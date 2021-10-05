package edu.unca.csci338;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

public class ColorController implements ActionListener {
	private Container pane;
	private ColorModel colorModel;

	public ColorController(ColorModel colorModel, JFrame frame, Color color) {
		super();
		this.pane = frame.getContentPane();
		this.colorModel = colorModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.pane.setBackground(colorModel.getColor());
	}
}
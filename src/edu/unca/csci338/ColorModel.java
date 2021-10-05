package edu.unca.csci338;

import java.awt.Color;

public class ColorModel {
	private Color currentColor;
	
	public Color getColor() {
		return currentColor;
	}
	
	public void setColor(Color newColor) {
		currentColor = newColor;
	}
	
	public ColorModel(Color color) {
		setColor(color);
	}
}
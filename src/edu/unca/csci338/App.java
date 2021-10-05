package edu.unca.csci338;

import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.*;

import edu.unca.csci338.controller.ColorController;
import edu.unca.csci338.controller.AudioController;

public class App {
	File wavFile;
	static URL defaultSound;
	public static Clip clip;
	public static AudioInputStream audioInputStream;
	static AudioController audio;
	static ColorController color;
	static ColorModel colorModel;

	public static JFrame createFrame() {
		JFrame frame = new JFrame("CSCI338 Graphical Application");
		frame.setSize(400, 280);
		frame.setLayout(null);
		frame.setVisible(true);
		try {
			audio = new AudioController("http://www.gros-prout.fr/son/triple.wav");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		colorModel = new ColorModel(Color.YELLOW);
		color = new ColorController(colorModel, frame, colorModel.getColor());
		color.actionPerformed(null);
		return frame;
	}

	public static JButton createRed(JFrame frame) {
		JButton red = new JButton("Make Red");
		red.setBounds(140, 50, 120, 30);
		red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorModel.setColor(Color.RED);
				color.actionPerformed(null);
				audio.actionPerformed(null);
			}
		});
		return red;
	}

	public static JButton createGreen(JFrame frame) {
		JButton green = new JButton("Make Green");
		green.setBounds(140, 100, 120, 30);
		green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorModel.setColor(Color.GREEN);
				color.actionPerformed(null);
				audio.actionPerformed(null);
			}
		});
		return green;
	}
	
	public static JButton createBlue(JFrame frame) {
		JButton blue = new JButton("Make Blue");
		blue.setBounds(140, 150, 120, 30);
		blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorModel.setColor(Color.BLUE);
				color.actionPerformed(null);
				audio.actionPerformed(null);
			}
		});
		return blue;
	}

	public static void main(String[] args) {
		JFrame f = createFrame();
		f.add(createRed(f));
		f.add(createGreen(f));
		f.add(createBlue(f));
	}
}

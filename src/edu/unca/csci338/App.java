package edu.unca.csci338;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.*;

import edu.unca.csci338.controller.ColorController;
import edu.unca.csci338.model.AudioModel;
import edu.unca.csci338.controller.AudioController;

public class App {
	File wavFile;
	static URL defaultSound;
	public static Clip clip;
	public static AudioInputStream audioInputStream;
	static AudioController audio;
	static ColorModel colorModel;

	public static JFrame createFrame() {
		JFrame frame = new JFrame("CSCI338 Graphical Application");
		frame.setSize(400, 280);
		frame.setLayout(null);
		try {
			audio = new AudioController(new AudioModel("http://www.gros-prout.fr/son/triple.wav"));
		} catch (IOException e) {
			System.out.println("IOException: Audio Not Available");
		}
		frame.getContentPane().setBackground(Color.YELLOW);
		colorModel = new ColorModel(Color.YELLOW);
		return frame;
	}

	public static JButton createRed(JFrame frame) {
		JButton red = new JButton("Make Red");
		red.setBounds(140, 50, 120, 30);
		red.addActionListener(new ColorController(colorModel, frame, Color.RED));
		red.addActionListener(audio);
		return red;
	}

	public static JButton createGreen(JFrame frame) {
		JButton green = new JButton("Make Green");
		green.setBounds(140, 100, 120, 30);
		green.addActionListener(new ColorController(colorModel, frame, Color.GREEN));
		green.addActionListener(audio);
		return green;
	}
	
	public static JButton createBlue(JFrame frame) {
		JButton blue = new JButton("Make Blue");
		blue.setBounds(140, 150, 120, 30);
		blue.addActionListener(new ColorController(colorModel, frame, Color.BLUE));
		blue.addActionListener(audio);
		return blue;
	}

	public static void main(String[] args) {
		JFrame f = createFrame();
		f.add(createRed(f));
		f.add(createGreen(f));
		f.add(createBlue(f));
		f.setVisible(true);
	}
}

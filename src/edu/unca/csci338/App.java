package edu.unca.csci338;

import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class App {
	File wavFile;
	static URL defaultSound;
	public static Clip clip;
	public static AudioInputStream audioInputStream;
	static AudioController audio;
	static ColorController color;

	public static JFrame createFrame() {
		JFrame frame = new JFrame("CSCI338 Graphical Application");
		frame.setSize(400, 350);
		frame.setLayout(null);
		frame.setVisible(true);
		try {
			audio = new AudioController("http://www.gros-prout.fr/son/triple.wav");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return frame;
	}

	public static JButton createRed(JFrame frame) {
		JButton red = new JButton("Make Red");
		red.setBounds(140, 50, 120, 30);
		red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().setBackground(Color.RED);
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
				frame.getContentPane().setBackground(Color.GREEN);
				audio.actionPerformed(null);
			}
		});
		return green;
	}

	public static JButton createText(JFrame frame) {
		JButton text = new JButton("Change Text");
		JLabel label1 = new JLabel("I'll never change.");
		label1.setBounds(150, 200, 200, 20);
		text.setBounds(140, 150, 120, 30);
		text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (label1.getText().equals("LOL. I changed.")) {
					label1.setText("STOP CHANGING ME!");
				} else {
					label1.setText("LOL. I changed.");
				}
				audio.actionPerformed(null);
			}
		});
		frame.add(label1);
		return text;
	}

	public static void main(String[] args) {
		JFrame f = createFrame();
		
		color = new ColorController(f, Color.YELLOW);
		color.actionPerformed(null);

		JButton red = createRed(f);
		JButton green = createGreen(f);
		JButton text = createText(f);

		f.add(red);
		f.add(green);
		f.add(text);
	}
}

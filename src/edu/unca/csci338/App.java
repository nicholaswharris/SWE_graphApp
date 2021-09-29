package edu.unca.csci338;

import java.applet.*;
import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;
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
	public static void play() {
		try {
            audioInputStream = AudioSystem.getAudioInputStream(defaultSound);

            try {
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.loop(20000);
                clip.start();
                try{
                	Thread.sleep(1000);
                }catch(InterruptedException l) {
                	System.out.println("You done it wrong");
                }
                clip.stop();
            } catch (LineUnavailableException e) {
            }

        } catch (UnsupportedAudioFileException | IOException e) {
        }
	}

	public static void main(String[] args) {
		JFrame f = new JFrame("CSCI338 Graphical Application");

		f.getContentPane().setBackground(Color.YELLOW);
		JLabel label1 = new JLabel("I'll never change.");
		label1.setBounds(150, 200, 200, 20);
		try {defaultSound = new URL ("https://www.soundjay.com/human/fart-01.wav");}
		catch (MalformedURLException ex) {
            System.out.println("Fart no workie.");
        }
		JButton red = new JButton("Make Red");
		JButton green = new JButton("Make Green");
		JButton text = new JButton("Change Text");

		red.setBounds(140, 50, 120, 30);
		red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.getContentPane().setBackground(Color.RED);
				play();
			}
		});

		green.setBounds(140, 100, 120, 30);
		green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.getContentPane().setBackground(Color.GREEN);
				play();
			}
		});

		text.setBounds(140, 150, 120, 30);
		text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (label1.getText().equals("LOL. I changed.")) {
					label1.setText("STOP CHANGING ME!");
				} else {
					label1.setText("LOL. I changed.");
				}
			}
		});

		f.add(red);
		f.add(green);
		f.add(text);
		f.add(label1);

		f.setSize(400, 350);
		f.setLayout(null);
		f.setVisible(true);
	}
}

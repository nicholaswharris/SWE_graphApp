package edu.unca.csci338;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class App {
	public static void main(String[] args) {

		JFrame f = new JFrame("CSCI338 Graphical Application");

		f.getContentPane().setBackground(Color.YELLOW);
		JLabel label1 = new JLabel("I'll never change.");
		label1.setBounds(150, 200, 200, 20);

		JButton red = new JButton("Make Red");
		JButton green = new JButton("Make Green");
		JButton text = new JButton("Change Text");

		red.setBounds(140, 50, 120, 30);
		red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.getContentPane().setBackground(Color.RED);
			}
		});

		green.setBounds(140, 100, 120, 30);
		green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.getContentPane().setBackground(Color.GREEN);
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
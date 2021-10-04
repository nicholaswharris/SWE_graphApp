package edu.unca.csci338;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioController implements ActionListener {
	private static URL defaultSound = null;
	private URL soundUrl;
	private Clip clip;
	private AudioInputStream audioInputStream;

	public AudioController() {
		this(AudioController.defaultSound);
	}

	public AudioController(String urlPath) throws MalformedURLException {
		this(new URL(urlPath));
	}

	public AudioController(URL url) {
		super();
		this.soundUrl = url;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			audioInputStream = AudioSystem.getAudioInputStream(this.soundUrl);

			try {
				clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException l) {
					System.out.println("You done it wrong");
				}
			} catch (LineUnavailableException e) {
				System.out.println("FAILED Line Exception");

			}
		} catch (UnsupportedAudioFileException | IOException e) {
			System.out.println("FAILED");
		}
	}

}
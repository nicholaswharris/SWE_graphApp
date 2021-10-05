package edu.unca.csci338.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import edu.unca.csci338.model.AudioModel;

public class AudioController implements ActionListener
{
	private AudioModel model;
	private AudioPlaybackThread playbackThread;
	
	public AudioController(AudioModel model)
	{
		this.model = model;
		this.playbackThread = null;
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		try {
			this.play(this.model.getAudio());
		} catch (UnsupportedAudioFileException| IOException e) {
			System.out.println("Audio Error: Line Exception");
		} catch (LineUnavailableException e) {
			System.out.println("Audio Error: Unsupported Audio File/IO Exception");
		}
	}

	public void play(AudioInputStream audioStream) throws IOException, LineUnavailableException
	{
		if (this.playbackThread != null) {
			this.playbackThread.interrupt();
			try {
				this.playbackThread.join();
			} catch (InterruptedException e) {
				System.out.println("Audio Error: Interrupted Exception");
			}
		}
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		this.playbackThread = new AudioPlaybackThread(clip);
		playbackThread.start();
	}
}

class AudioPlaybackThread extends Thread implements LineListener
{
	private Clip clip;

	public AudioPlaybackThread(Clip clip)
	{
		this.clip = clip;
		this.clip.addLineListener(this);
		this.setDaemon(false);
	}

	@Override
	public void run()
	{
		clip.start();
		try {
			synchronized (clip) {
				clip.wait(5000);
			}
		}
		catch (InterruptedException err) {
			clip.stop();
		}
		clip.close();
	}

	@Override
	public void update(LineEvent event)
	{
		if (event.getType().equals(LineEvent.Type.STOP) || event.getType().equals(LineEvent.Type.CLOSE)) {
			this.interrupt();
		}
	}

}

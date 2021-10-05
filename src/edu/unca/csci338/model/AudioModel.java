package edu.unca.csci338.model;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioModel
{
	private URL soundUrl;
	private byte[] audioData;
	
	public AudioModel(String soundUrl) throws IOException
	{
		this.soundUrl = new URL(soundUrl);
		this.audioData = this.downloadAudioData(this.soundUrl);
	}
	
	private byte[] downloadAudioData(URL soundUrl) throws IOException
	{
		return new BufferedInputStream(soundUrl.openStream()).readAllBytes();
	}
	
	public AudioInputStream getAudio() throws IOException, UnsupportedAudioFileException
	{
		return AudioSystem.getAudioInputStream(new ByteArrayInputStream(this.audioData));
	}
	
}

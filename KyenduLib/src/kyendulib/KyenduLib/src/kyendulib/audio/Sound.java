package kyendulib.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import kyendulib.error.KyenduError;

public class Sound {

	public String path = "";
	private File soundFile;
	private AudioInputStream audioIn;
	private Clip clip;
	
	public Sound() {
		create(path);
	}
	
	public Sound(String path) {
		this.path = path;
		create(path);
	}
	
	public Sound(boolean playAfterLoad) {
		create(path);
		if(playAfterLoad) {
			play();
		}
	}
	
	public Sound(String path, boolean playAfterLoad) {
		this.path = path;
		create(path);
		if(playAfterLoad) {
			play();
		}
	}
	
	private void create(String path) {
		try {
			soundFile = new File(path);
			audioIn = AudioSystem.getAudioInputStream(soundFile);
			clip = AudioSystem.getClip();
			clip.open(audioIn);
		} catch (UnsupportedAudioFileException e) {
			new KyenduError("An UnsupportedAudioFileException has occured", this).show();;
		} catch (IOException e) {
			new KyenduError("An IOException has occured", this).show();;
		} catch (LineUnavailableException e) {
			new KyenduError("A LineUnavailableException has occured", this).show();;
		}
	}
	
	public void play() {
		clip.start();
	}
	
	public void stop() {
		clip.start();
	}
	
	public void loop(int numLoops) {
		clip.loop(numLoops);
	}
	
}
package window;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Win_music {
	public static void main(String[] args)
	{
		File Clap = new File("C:\\Users\\Dehnam\\Desktop\\applause.wav");
		PlaySound(Clap);
	}
	static void PlaySound(File Sound){
		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength()/1000);
		}catch(Exception e)
		{
			
		}
	}
}

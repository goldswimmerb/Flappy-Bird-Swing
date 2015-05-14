import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.*;
public class Music {
	  
	      public static void run() {
	        try {

	          Clip clip = AudioSystem.getClip();
	          AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("res/01 - Sandstorm (radio edit).wav"));       
	          clip.open(inputStream);
	          clip.loop(Clip.LOOP_CONTINUOUSLY);
	          //clip.start(); 
	          //Thread.sleep(10000);
	          
	        } catch (Exception e) {
	          System.err.println(e.getMessage());
	        }
	      }
	    
	  }


	/*{       
	        AudioPlayer Audio = AudioPlayer.player;
	        AudioStream Stream;
	        AudioData MD;

	        ContinuousAudioDataStream loop = null;

	        try
	        {
	            InputStream audiofile = new FileInputStream("res/01 - Sandstorm (radio edit).wav");
	            Stream = new AudioStream(audiofile);
	            AudioPlayer.player.start(Stream);
	            //MD = BGM.getData();
	            //loop = new ContinuousAudioDataStream(MD);

	        }
	        catch(FileNotFoundException e){
	            System.out.print("file could not be found" + e.toString());
	        }
	        catch(IOException error)
	        {
	            System.out.print(error.toString());
	        }
	        
	        Audio.start(loop);
	        
	    }


	}*/


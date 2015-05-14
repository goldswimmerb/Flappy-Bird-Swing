import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.*;
public class Music {
	  
	public static void music() 
	    {       
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


	}


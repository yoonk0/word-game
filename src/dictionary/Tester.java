package dictionary;


import java.io.IOException;


import javax.media.CannotRealizeException;
import javax.media.NoPlayerException;

//This code will be embedded into the GUI (play button "on click")
//Should it be stopped manually? 
public class Tester{
	public static void main(String[] args){
		try {
			XMLRequest x = new XMLRequest("monkey");
			AudioPlayer.play(x.getAudioUrl());
			System.out.println(x.getDefinition());
			if(x.getSentence() != null)	System.out.println(x.getSentence());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotRealizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

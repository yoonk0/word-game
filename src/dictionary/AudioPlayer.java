package dictionary;

import java.io.IOException;
import java.net.URL;

import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
/**
 * This class uses the JMF to create a player for the given url and play the audio
 * @author YoonKim
 *
 */
public class AudioPlayer {

		public static void play (URL audio) throws NoPlayerException, CannotRealizeException, IOException {
	         Player player = Manager.createRealizedPlayer(audio);
	         player.start();
	    }
}

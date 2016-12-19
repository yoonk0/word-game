package game;

import java.io.IOException;

/**
* Test class for car game
* @author Wen Zhong
*/

public class Lauch {
	public static Game game;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new Game();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

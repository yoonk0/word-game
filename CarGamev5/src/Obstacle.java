
/**
*
* @author Wen Zhong
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Obstacle extends Element implements Runnable{
	Question question;
	
	public Obstacle(int x){
		super(x);
	}

	public void showQuestion(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawString("Hello, there should be a question", 5, height - 100);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(x + sizeWidth < 0){
				x = width;
				y = (int)(height * 0.65 - 25 + 105 * Math.random());
				int r = rand.nextInt(11);
				image = new ImageIcon("images/obstacles/" + r + ".png");
				sizeWidth = (int)(this.image.getIconWidth() * 0.2);
				sizeHeight = (int)(this.image.getIconHeight() * 0.2);
			}else
				move();
		}
	}
}

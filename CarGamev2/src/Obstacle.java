
/**
*
* @author Wen Zhong
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Obstacle implements Runnable{
	int x;
	int y;
	ImageIcon image;
	int speed;
	Question question;
	int width;
	int height;
	int sizeWidth;
	int sizeHeight;
	Random rand = null;
	
	public Obstacle(int x){
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		rand = new Random();
		int r = rand.nextInt(11);
		image = new ImageIcon("images/obstacles/" + r + ".png");
		speed = 10;
		this.x = x;
		this.y = (int)(height * 0.65 - 25 + 105 * Math.random());
		
		sizeWidth = (int)(this.image.getIconWidth() * 0.2);
		sizeHeight = (int)(this.image.getIconHeight() * 0.2);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}
	
	

	public int getSizeWidth() {
		return sizeWidth;
	}

	public void setSizeWidth(int sizeWidth) {
		this.sizeWidth = sizeWidth;
	}

	public int getSizeHeight() {
		return sizeHeight;
	}

	public void setSizeHeight(int sizeHeight) {
		this.sizeHeight = sizeHeight;
	}

	public void move() {
		// TODO Auto-generated method stub
		x -= speed;
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
			}else
				move();
		}
	}
}

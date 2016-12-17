
/**
*
* @author Wen Zhong
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Plant implements Runnable{
	int x;
	int y;
	ImageIcon image;
	int speed;
	int sizeWidth;
	int sizeHeight;
	Random rand = null;
	
	public Plant(int x, int y){
		this.x = x;
		this.y = y;
		this.speed = 10;
		rand = new Random();
		int r = rand.nextInt(8);
		image = new ImageIcon("images/plants/" + r + ".png");
		
		sizeWidth = (int)(image.getIconWidth() * 0.2);
		sizeHeight = (int)(image.getIconHeight() * 0.2);
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
//			if(x + sizeWidth < 0){
//				int r = rand.nextInt(8);
//				image = new ImageIcon("images/plants/" + r + ".png");
//				x = sizeWidth;
//			}
			move();
		}
	}
}

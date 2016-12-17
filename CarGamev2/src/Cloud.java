
/**
*
* @author Wen Zhong
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Cloud implements Runnable{
	int x;
	int y;
	int speed;
	ImageIcon image;
	int width;
	int height;
	int sizeWidth;
	int sizeHeight;
	
	public Cloud(){
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		Random rand = new Random();
		x = (int)(width * rand.nextDouble());
		y = (int)(rand.nextDouble() * height * 0.4);
		speed = 5;
		int r = rand.nextInt(2);
		image = new ImageIcon("images/sky/" + r + ".png");
		
		sizeWidth = (int)(image.getIconWidth() * 0.15);
		sizeHeight = (int)(image.getIconHeight() * 0.15);
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
			x -= speed;
			if(x + image.getIconWidth() * 0.15 < 0) 
				x = width;
		}
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
	
	
}

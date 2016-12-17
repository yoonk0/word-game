
/**
*
* @author Wen Zhong
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class House implements Runnable{
	int x;
	int y;
	ImageIcon image;
	int speed;
	int width;
	int height;
	int sizeHeight;
	int sizeWidth;
	
	public House(){
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		Random rand = new Random();
		int r = rand.nextInt(6);
		image = new ImageIcon("images/houses/" + r +".png");
		
		
		x = (int)(width * rand.nextDouble());
		y = (int)(height * 0.6 - image.getIconHeight() * 0.4) - 10;
		speed = 10;
		
		sizeHeight = (int)(image.getIconHeight() * 0.4);
		sizeWidth = (int)(image.getIconWidth() * 0.4);
	}
	
	public void move(){
		x -= speed;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSizeHeight() {
		return sizeHeight;
	}

	public void setSizeHeight(int sizeHeight) {
		this.sizeHeight = sizeHeight;
	}

	public int getSizeWidth() {
		return sizeWidth;
	}

	public void setSizeWidth(int sizeWidth) {
		this.sizeWidth = sizeWidth;
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
//				x = width;
//			}else
				move();
		}
	}
	
	
}

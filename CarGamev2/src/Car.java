
/**
*
* @author Wen Zhong
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class Car implements Runnable{
	int x;
	int y;
	int speed;
	int sizeWidth;
	int sizeHeight;
	int width;
	int height;
	ImageIcon image = null;
	
	public Car(int x, int y, ImageIcon image){
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.image = image;
		sizeHeight = (int)(this.image.getIconHeight() * 0.4);
		sizeWidth = (int)(this.image.getIconWidth()*0.4);
		
		this.x = x;
		this.y = y;
		this.speed = 10;
		
		
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public void moveUp(int limit) {
		// TODO Auto-generated method stub
		if(y > limit)
			y -= speed;
	}
	
	public void moveDown(int limit){
		if(y < limit)
			y += speed;
	}
	
	public void moveRight(){
		x += speed;
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
			if(x <= width / 3)
				moveRight();
		}
	}
}

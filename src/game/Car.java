package game;

/**
* Car class which describes the location, size of a car
* @author Wen Zhong
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class Car extends Element implements Runnable{
	
	/**
	 * constructor
	 * @param x
	 * @param y
	 * @param image
	 */
	public Car(int x, int y, ImageIcon image){
		super(x, y, image);
	}

	/**
	 * when the car move up, this method will be called
	 * @param limit
	 */
	public void moveUp(int limit) {
		// TODO Auto-generated method stub
		if(y > limit)
			y -= speed;
	}
	
	/**
	 * when the car move down, this method will be called
	 * @param limit
	 */
	public void moveDown(int limit){
		if(y < limit)
			y += speed;
	}
	
	/**
	 * when the car move right, this method will be called
	 */
	public void moveRight(){
		x += speed;
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


/**
*
* @author Wen Zhong
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class Car extends Element implements Runnable{
	public Car(int x, int y, ImageIcon image){
		super(x, y, image);
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

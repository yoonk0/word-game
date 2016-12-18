package game;

/**
*
* @author Wen Zhong
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class House extends Element implements Runnable{
	boolean isLive;
	
	public House(){
		super();
		
		Random rand = new Random();
		int r = rand.nextInt(6);
		image = new ImageIcon("images/houses/" + r +".png");
		
		isLive = true;
		x = (int)(width * rand.nextDouble());
		y = (int)(height * 0.6 - image.getIconHeight() * 0.4) - 10;
		speed = 2;
		
		sizeHeight = (int)(image.getIconHeight() * 0.4);
		sizeWidth = (int)(image.getIconWidth() * 0.4);
	}
	
	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
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
			if(x + sizeWidth < 0)
				isLive = false;
//			}else
			move();
		}
	}
	
	
}

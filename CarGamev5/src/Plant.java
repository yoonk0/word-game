
/**
*
* @author Wen Zhong
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Plant extends Element implements Runnable{
	boolean isLive;
	
	public Plant(int x, int y){
		super(x, y);
		rand = new Random();
		int r = rand.nextInt(8);
		image = new ImageIcon("images/plants/" + r + ".png");
		isLive = true;
		sizeWidth = (int)(image.getIconWidth() * 0.2);
		sizeHeight = (int)(image.getIconHeight() * 0.2);
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
//			if(x + sizeWidth < 0){
//				int r = rand.nextInt(8);
//				image = new ImageIcon("images/plants/" + r + ".png");
//				x = sizeWidth;
//			}
			if(x + sizeWidth < 0)
				isLive = false;
			move();
		}
	}
}

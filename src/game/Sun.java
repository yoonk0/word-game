package game;

/**
* This class describes the location and size of sun
* @author Wen Zhong
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class Sun implements Runnable{
	int x;
	int y;
	int width;
	int height;
	float opacity;
	ImageIcon image;
	float speed;
	boolean flag;
	int sizeWidth;
	int sizeHeight;
	
	/**
	 * constructor
	 */
	public Sun(){
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		x = width / 2 + 10;
		y = 50;
		opacity = 1.0f;
		speed = 0.05f;
		flag = false;
		
		image = new ImageIcon("images/sky/sun.png");
		
		sizeWidth = (int)(image.getIconWidth());
		sizeHeight = (int)(image.getIconHeight());
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				Thread.sleep(100);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			if(flag){
				opacity += speed;
				if(opacity - 1 < 1e-6){
					flag = false;
					opacity = 1.0f;
				}
			}else{
				opacity -= speed;
				if(opacity - 0 < 1e-6){
					flag = true;
					opacity = 0.0f;
				}
			}
		}
	}

	/**
	 * getters and setters
	 * @return
	 */
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


	public float getOpacity() {
		return opacity;
	}


	public void setOpacity(float opacity) {
		this.opacity = opacity;
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

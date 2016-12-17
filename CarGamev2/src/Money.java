
/**
*
* @author Wen Zhong
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class Money implements Runnable{
	int x;
	int y;
	int height;
	int width;
	int sizeWidth;
	int sizeHeight;
	float opacity;
	float speed;
	int moveSpeed;
	Random rand = null;
	ImageIcon image = null;
	boolean flag;
	
	public Money(int x, int y){
//		(int)(height * 0.65)
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		flag = false;
		speed = 0.1f;
		moveSpeed = 10;
		this.x = x;
		this.y = y;
		this.image = new ImageIcon("images/money.png");
		sizeWidth = image.getIconWidth() / 15;
		sizeHeight = image.getIconHeight() / 15;
		opacity = 1.0f;
	}
	
	@Override
	public void run() {
		while(true){
			try{
				Thread.sleep(50);
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
			move();
		}
	}
	
	public void move(){
		x -= moveSpeed;
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
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

	public float getOpacity() {
		return opacity;
	}

	public void setOpacity(float opacity) {
		this.opacity = opacity;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	
}

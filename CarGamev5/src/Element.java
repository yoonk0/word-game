import java.awt.Toolkit;
import java.util.Random;

import javax.swing.ImageIcon;

/**
*
* @author Wen Zhong
*/

public class Element {
	int x;
	int y;
	int speed;
	int sizeWidth;
	int sizeHeight;
	int width;
	int height;
	ImageIcon image = null;
	Random rand = null;
	
	public void init(){
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
	}
	
	// Car
	public Element(int x, int y, ImageIcon image){
		init();
		this.image = image;
		sizeHeight = (int)(this.image.getIconHeight() * 0.4);
		sizeWidth = (int)(this.image.getIconWidth()*0.4);
		
		this.x = x;
		this.y = y;
		this.speed = 3;
	}
	
	
	// Cloud, House
	public Element(){
		init();
		
		Random rand = new Random();
		x = (int)(width * rand.nextDouble());
		y = (int)(rand.nextDouble() * height * 0.4);
		speed = 5;
		int r = rand.nextInt(2);
		image = new ImageIcon("images/sky/" + r + ".png");
		
		sizeWidth = (int)(image.getIconWidth() * 0.15);
		sizeHeight = (int)(image.getIconHeight() * 0.15);
	}
	
	// Money
	public Element(int x, int y){
		init();
		
		speed = 2;
		this.x = x;
		this.y = y;
		this.image = new ImageIcon("images/money.png");
		sizeWidth = image.getIconWidth() / 15;
		sizeHeight = image.getIconHeight() / 15;
	}
	
	// Obstacle
	public Element(int x){
		init();
		
		rand = new Random();
		int r = rand.nextInt(11);
		image = new ImageIcon("images/obstacles/" + r + ".png");
		speed = 2;
		this.x = x;
		this.y = (int)(height * 0.65 - 25 + 105 * Math.random());
		
		sizeWidth = (int)(this.image.getIconWidth() * 0.2);
		sizeHeight = (int)(this.image.getIconHeight() * 0.2);
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


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
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


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public ImageIcon getImage() {
		return image;
	}


	public void setImage(ImageIcon image) {
		this.image = image;
	}


	public Random getRand() {
		return rand;
	}


	public void setRand(Random rand) {
		this.rand = rand;
	}
}

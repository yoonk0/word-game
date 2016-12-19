package game;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.ImageIcon;

/**
* this class is the superclass for Car, Cloud, House, Money, Obstacle
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
	
	/**
	 * set up the value of height and width
	 */
	public void init(){
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
	}
	
	/**
	 * constructor one which is mainly for Car
	 * @param x
	 * @param y
	 * @param image
	 */
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
	
	/**
	 * constructor two which is mainly for Cloud, House
	 */
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
	
	/**
	 * constructor three which is mainly for Money
	 * @param x
	 * @param y
	 */
	// Money
	public Element(int x, int y){
		init();
		
		speed = 2;
		this.x = x;
		this.y = y;
		this.image = new ImageIcon("images/game/money.png");
		sizeWidth = image.getIconWidth() / 15;
		sizeHeight = image.getIconHeight() / 15;
	}
	
	/**
	 * constructor four which is mainly for Obstacle
	 * @param x
	 */
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
	
	/**
	 * move right
	 */
	public void move(){
		x -= speed;
	}

	/**
	 * get x
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * set x
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * get y
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * set y
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * get speed
	 * @return speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * set speed
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * get sizeWidth
	 * @return sizeWidth
	 */
	public int getSizeWidth() {
		return sizeWidth;
	}

	/**
	 * set sizeWidth
	 * @param sizeWidth
	 */
	public void setSizeWidth(int sizeWidth) {
		this.sizeWidth = sizeWidth;
	}

	/**
	 * get sizeHeight
	 * @return sizeHeight
	 */
	public int getSizeHeight() {
		return sizeHeight;
	}

	/**
	 * set sizeHeight
	 * @param sizeHeight
	 */
	public void setSizeHeight(int sizeHeight) {
		this.sizeHeight = sizeHeight;
	}

	/**
	 * get width
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * set width
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * get height
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * set height
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * get image
	 * @return image
	 */
	public ImageIcon getImage() {
		return image;
	}

	/**
	 * set image
	 * @param image
	 */
	public void setImage(ImageIcon image) {
		this.image = image;
	}

	/**
	 * get rand
	 * @return rand
	 */
	public Random getRand() {
		return rand;
	}

	/**
	 * set rand
	 * @param rand
	 */
	public void setRand(Random rand) {
		this.rand = rand;
	}
}


/**
*
* @author Wen Zhong
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Option{
	int x;
	int y;
	ImageIcon image;
	int widthOfImage;
	int heightOfImage;
//	Cursor hand;
	
	public Option(int x, int y, ImageIcon image, int widthOfImage, int heightOfHeight){
		this.x = x;
		this.y = y;
		this.image = image;
		this.widthOfImage = widthOfImage;
		this.heightOfImage = heightOfHeight;
//		hand = new Cursor(Cursor.HAND_CURSOR);
//		this.setCursor(hand);
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

	public int getWidthOfImage() {
		return widthOfImage;
	}

	public void setWidthOfImage(int widthOfImage) {
		this.widthOfImage = widthOfImage;
	}

	public int getHeightOfImage() {
		return heightOfImage;
	}

	public void setHeightOfImage(int heightOfImage) {
		this.heightOfImage = heightOfImage;
	}
}

package tools;

import java.awt.Cursor;

import javax.swing.*;

/**
*
* @author Wen Zhong
*/

public class ButtonWithHandCursor extends JLabel{
	int num;
	String prevButton;
	
	public ButtonWithHandCursor(String text){
		this.setText(text);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setHorizontalAlignment(JLabel.CENTER);
	}
	
	public ButtonWithHandCursor(String text, int num){
		this(text);
		this.num = num;
	}
	
	public ButtonWithHandCursor(String text, double rand){
		super(text);
	}
	
	public int getNum(){
		return num;
	}
	
	public void setPrevButton(String prevButton){
		this.prevButton = prevButton;
	}
	
	public String getPrevButton(){
		return prevButton;
	}
}

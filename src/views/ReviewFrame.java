package views;

/**
*
* @author Wen Zhong
*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.*;
import javax.swing.*;
import tools.*;

public class ReviewFrame extends WordFrame{
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//	}
	ImagePanel oops;
	ButtonWithHandCursor watchLesson, playGame;
	
	public ReviewFrame(int lessonNum, Rectangle size, String wordsPath) throws Exception{
		super(lessonNum, size, wordsPath);
		if(words.size() == 0){
			dealWithOops();
			System.out.println("Oops, there's no word in the review list. Watch the lesson? Play the game?");
		}
	}
	
	private void dealWithOops() throws Exception{
		oops = new ImagePanel(ImageIO.read(new File("images/lessonsboard.jpg")));
		watchLesson = new ButtonWithHandCursor("Watch the lesson");
		playGame = new ButtonWithHandCursor("Play the game");
		oops.add(watchLesson);
		oops.add(playGame);
	}
}

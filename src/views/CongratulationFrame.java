package views;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import tools.*;

/**
*
* @author Wen Zhong
*/

public class CongratulationFrame extends JFrame implements MouseListener{
	ImagePanel bgPanel;
	ButtonWithHandCursor playAGame, gotoReviewList, homePage, nextLesson;
	int lessonNum;
	
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		new CongratulationFrame(4, (new InitFrame()).getBounds());
//	}
	
	public CongratulationFrame(int srcLessonNum, Rectangle size) throws Exception{
		lessonNum = srcLessonNum;
		initLabels();
		initPanels();
		initFrame(size);
	}
	
	private void initLabels(){
		playAGame = new ButtonWithHandCursor("Play a game");
		playAGame.addMouseListener(this);
		
		gotoReviewList = new ButtonWithHandCursor("Go to review list");
		gotoReviewList.addMouseListener(this);
		
		homePage = new ButtonWithHandCursor("Home page");
		homePage.addMouseListener(this);
		
		nextLesson = new ButtonWithHandCursor("Next lesson");
		nextLesson.addMouseListener(this);
		if(lessonNum == 5) nextLesson.setEnabled(false);
	}
	
	private void initPanels() throws Exception{
		bgPanel = new ImagePanel(ImageIO.read(new File("images/lessonfinished.jpg")));
	    GridLayout bgPanelLayout = new GridLayout(4, 1);
	    bgPanel.setLayout(bgPanelLayout);
	    bgPanel.add(playAGame);
	    bgPanel.add(gotoReviewList);
	    bgPanel.add(homePage);
	    bgPanel.add(nextLesson);
	}
	
	private void initFrame(Rectangle size){
		this.add(bgPanel);
		this.setBounds(size);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == playAGame){
			
		}else if(e.getSource() == gotoReviewList){
			try {
				WordFrame rFrame = new WordFrame(lessonNum, this.getBounds(), "words/reviewlist" + lessonNum + ".txt");
				rFrame.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.setVisible(false);
		}else if(e.getSource() == homePage){
//			if(LauchBoard.initFrame != null){
//				LauchBoard.initFrame.showLauchBoard();
//				LauchBoard.initFrame.setVisible(true);
//			}
			try {
				InitFrame initFrame = new InitFrame();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.setVisible(false);
		}else if(e.getSource() == nextLesson){
			if(lessonNum < 4){
			this.setVisible(false);
				try {
					WordFrame wFrame = new WordFrame(lessonNum + 1, this.getBounds(), "words/lesson" + (lessonNum + 1)+".txt");
					wFrame.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else{
				// TODO 需要做一个finish all the course的页面
				System.out.println("congratulations! you have finished all the courses!");
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

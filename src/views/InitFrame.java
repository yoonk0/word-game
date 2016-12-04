package views;

/**
*
* @author Wen Zhong
*/

import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class InitFrame extends JFrame {
	public static CardLayout mainLayout;
	public static MainMenu main; 
	public static LessonMenu lessonMenu;
	public static Lesson lesson;
	public static int lessonNum; 
	public static CongratulationsPanel congrats;
//	public static ReviewPanel review; 
//	public static gamePanel game; 


	public InitFrame() throws Exception{
		initFrame();
		addPanels();
	}
	
	private void initFrame() {
		lessonNum = 1;
		mainLayout = new CardLayout();
		this.setLayout(mainLayout);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setVisible(true);
		this.setSize(width / 3 * 2, height - 100);
		this.setLocation(200, 0);
		this.setResizable(false);		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void addPanels() throws Exception {
		Image image = ImageIO.read(new File("images/dash/dashwith.jpg"));
		main= new MainMenu(image);
		image = ImageIO.read(new File("images/dash/dashwith.jpg"));
		lessonMenu = new LessonMenu(image);
		image = ImageIO.read(new File("images/card/lesson/cardwith.jpg"));
		lesson = new Lesson(image);
		image = ImageIO.read(new File("images/end/finishLesson/lessonfinished.jpg"));
		congrats = new CongratulationsPanel(image);	
		this.add(main, "main");
		this.add(lessonMenu, "lessonMenu");
		this.add(lesson, "lesson");
		this.add(congrats, "congrats");
	}

//	
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//
//	    if(e.getSource() == main.watchLessonsButton){
//	    	main.setVisible(false);
//			mainLayout.show(this.getContentPane(), "lesson");
//			validate();
//			repaint();
////			lesson.lesson1Label.setPrevButton("watchLessonsButton");
////			lesson.lesson2Label.setPrevButton("watchLessonsButton");
////			lesson.lesson3Label.setPrevButton("watchLessonsButton");
////			lesson4Label.setPrevButton("watchLessonsButton");
////			lesson5Label.setPrevButton("watchLessonsButton");
//		}else if(e.getSource() == main.playGamesButton){
//			mainLayout.show(this.getContentPane(), "lesson");
////			lesson1Label.setPrevButton("playGamesButton");
////			lesson2Label.setPrevButton("playGamesButton");
////			lesson3Label.setPrevButton("playGamesButton");
////			lesson4Label.setPrevButton("playGamesButton");
////			lesson5Label.setPrevButton("playGamesButton");
//		}else if(e.getSource() == main.reviewButton){
//			mainLayout.show(this.getContentPane(), "lesson");
////			lesson1Label.setPrevButton("reviewButton");
////			lesson2Label.setPrevButton("reviewButton");
////			lesson3Label.setPrevButton("reviewButton");
////			lesson4Label.setPrevButton("reviewButton");
////		    lesson5Label.setPrevButton("reviewButton");
//		}else if(e.getSource() == main.exitButton){
//			System.exit(0);
//		}else if(e.getSource() == lesson1Label){
//			if(lesson1Label.getPrevButton() == "watchLessonsButton"){
//				this.setVisible(false);
//				try {
//					WordFrame wFrame = new WordFrame(((ButtonWithHandCursor)e.getSource()).getNum(), this.getBounds(), "words/lesson" + ((ButtonWithHandCursor)e.getSource()).getNum() +".txt");
//					wFrame.setVisible(true);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				try {
//					wFrame = new WordFrame(((ButtonWithHandCursor)e.getSource()).getNum(), this.getBounds());
//					if(LauchBoard.wordFrameNum.contains(wFrame.getLessonNum()))
//							LauchBoard.wordFrame.get(wFrame.getLessonNum()).setVisible(true);
//					else{
//						LauchBoard.wordFrame.add(wFrame);
//						wFrame.setVisible(true);
//					}
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}else if(lesson1Label.getPrevButton() == "playGamesButton"){
//				
//			}else if(lesson1Label.getPrevButton() == "reviewButton"){
//				try {
//					WordFrame rFrame = new WordFrame(((ButtonWithHandCursor)e.getSource()).getNum(), this.getBounds(), "words/reviewlist" + ((ButtonWithHandCursor)e.getSource()).getNum() +".txt");
//					rFrame.setVisible(true);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				this.setVisible(false);
//			}
//		}else if(e.getSource() == lesson2Label){
//			if(lesson2Label.getPrevButton() == "watchLessonsButton"){
//				this.setVisible(false);
//				try {
//					WordFrame wFrame = new WordFrame(((ButtonWithHandCursor)e.getSource()).getNum(), this.getBounds(), "words/lesson" + ((ButtonWithHandCursor)e.getSource()).getNum() +".txt");
//					wFrame.setVisible(true);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
////				try {
////					wFrame = new WordFrame(((ButtonWithHandCursor)e.getSource()).getNum(), this.getBounds());
////					if(LauchBoard.wordFrameNum.contains(wFrame.getLessonNum()))
////							LauchBoard.wordFrame.get(wFrame.getLessonNum()).setVisible(true);
////					else{
////						LauchBoard.wordFrame.add(wFrame);
////						wFrame.setVisible(true);
////					}
////				} catch (Exception e1) {
////					// TODO Auto-generated catch block
////					e1.printStackTrace();
////				}
//			}else if(lesson2Label.getPrevButton() == "playGamesButton"){
//				
//			}else if(lesson2Label.getPrevButton() == "reviewButton"){
//				try {
//					WordFrame rFrame = new WordFrame(((ButtonWithHandCursor)e.getSource()).getNum(), this.getBounds(), "words/reviewlist" + ((ButtonWithHandCursor)e.getSource()).getNum() +".txt");
//					rFrame.setVisible(true);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				this.setVisible(false);
//			}
//		}else if(e.getSource() == lesson3Label){
//			if(lesson3Label.getPrevButton() == "watchLessonsButton"){
//				this.setVisible(false);
//				try {
//					WordFrame wFrame = new WordFrame(((ButtonWithHandCursor)e.getSource()).getNum(), this.getBounds(), "words/lesson" + ((ButtonWithHandCursor)e.getSource()).getNum() +".txt");
//					wFrame.setVisible(true);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
////				try {
////					wFrame = new WordFrame(((ButtonWithHandCursor)e.getSource()).getNum(), this.getBounds());
////					if(LauchBoard.wordFrameNum.contains(wFrame.getLessonNum()))
////							LauchBoard.wordFrame.get(wFrame.getLessonNum()).setVisible(true);
////					else{
////						LauchBoard.wordFrame.add(wFrame);
////						wFrame.setVisible(true);
////					}
////				} catch (Exception e1) {
////					// TODO Auto-generated catch block
////					e1.printStackTrace();
////				}
//			}else if(lesson3Label.getPrevButton() == "playGamesButton"){
//				
//			}else if(lesson3Label.getPrevButton() == "reviewButton"){
//				try {
//					WordFrame rFrame = new WordFrame(((ButtonWithHandCursor)e.getSource()).getNum(), this.getBounds(), "words/reviewlist" + ((ButtonWithHandCursor)e.getSource()).getNum() +".txt");
//					rFrame.setVisible(true);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				this.setVisible(false);
//			}
//		}else if(e.getSource() == lesson4Label){
//			if(lesson4Label.getPrevButton() == "watchLessonsButton"){
//				this.setVisible(false);
//				try {
//					WordFrame wFrame = new WordFrame(((ButtonWithHandCursor)e.getSource()).getNum(), this.getBounds(), "words/lesson" + ((ButtonWithHandCursor)e.getSource()).getNum() +".txt");
//					wFrame.setVisible(true);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
////				try {
////					wFrame = new WordFrame(((ButtonWithHandCursor)e.getSource()).getNum(), this.getBounds());
////					if(LauchBoard.wordFrameNum.contains(wFrame.getLessonNum()))
////							LauchBoard.wordFrame.get(wFrame.getLessonNum()).setVisible(true);
////					else{
////						LauchBoard.wordFrame.add(wFrame);
////						wFrame.setVisible(true);
////					}
////				} catch (Exception e1) {
////					// TODO Auto-generated catch block
////					e1.printStackTrace();
////				}
//			}else if(lesson4Label.getPrevButton() == "playGamesButton"){
//				
//			}else if(lesson4Label.getPrevButton() == "reviewButton"){
//				try {
//					WordFrame rFrame = new WordFrame(((ButtonWithHandCursor)e.getSource()).getNum(), this.getBounds(), "words/reviewlist" + ((ButtonWithHandCursor)e.getSource()).getNum() +".txt");
//					rFrame.setVisible(true);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				this.setVisible(false);
//			}
//		}else if(e.getSource() == lesson5Label){
//			if(lesson5Label.getPrevButton() == "watchLessonsButton"){
//				this.setVisible(false);
//				try {
//					WordFrame wFrame = new WordFrame(((ButtonWithHandCursor)e.getSource()).getNum(), this.getBounds(), "words/lesson" + ((ButtonWithHandCursor)e.getSource()).getNum() +".txt");
//					wFrame.setVisible(true);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
////				try {
////					wFrame = new WordFrame(((ButtonWithHandCursor)e.getSource()).getNum(), this.getBounds());
////					if(LauchBoard.wordFrameNum.contains(wFrame.getLessonNum()))
////							LauchBoard.wordFrame.get(wFrame.getLessonNum()).setVisible(true);
////					else{
////						LauchBoard.wordFrame.add(wFrame);
////						wFrame.setVisible(true);
////					}
////				} catch (Exception e1) {
////					// TODO Auto-generated catch block
////					e1.printStackTrace();
////				}
//			}else if(lesson5Label.getPrevButton() == "playGamesButton"){
//				
//			}else if(lesson5Label.getPrevButton() == "reviewButton"){
//				try {
//					WordFrame rFrame = new WordFrame(((ButtonWithHandCursor)e.getSource()).getNum(), this.getBounds(), "words/reviewlist" + ((ButtonWithHandCursor)e.getSource()).getNum() +".txt");
//					rFrame.setVisible(true);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				this.setVisible(false);
//			}
//		}else if(e.getSource() == home){
//			mainLayout.show(this.getContentPane(), "launch board");
//		}
//	}

	
	

}

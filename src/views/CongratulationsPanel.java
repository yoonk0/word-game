package views;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

import tools.ReviewList;

/**
 * This class represents the congratulations page at the end of each lesson
 * @author YoonKim
 *
 */
public class CongratulationsPanel extends JPanel{
	Image backgroundImage;
	JButton playGame, gotoReviewList, homePage, nextLesson;
	ReviewList reviewList; 
	
	/**
	 * This is the constructor for the class 
	 * @param image
	 * @throws Exception
	 */
	public CongratulationsPanel(Image image) throws Exception{
		backgroundImage = image;
		initButtons();
		mouseControl();
		setLayout(null);
		
	}

	/**
	 * This class initializes all the buttons in the menu
	 * @throws IOException
	 */
	private void initButtons() throws IOException {
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;

		Image image;
		image = getImage("playgame");
		playGame = new JButton(new ImageIcon(image));
		setButton(playGame);
		playGame.setBounds((int) (w*0.21), (int)(h*0.22), (int) (w*0.3), (int) (h*0.08));
		
		image = getImage("gotoreviewlist");
		gotoReviewList = new JButton(new ImageIcon(image));
		setButton(gotoReviewList);
		gotoReviewList.setBounds((int) (w*0.21), (int)(h*0.32), (int) (w*0.3), (int) (h*0.08));
		
		image = getImage("homepage");
		homePage = new JButton(new ImageIcon(image));
		setButton(homePage);
		homePage.setBounds((int) (w*0.21), (int)(h*0.42), (int) (w*0.3), (int) (h*0.08));
		
		image = getImage("nextlesson");
		nextLesson = new JButton(new ImageIcon(image));
		setButton(nextLesson);
		nextLesson.setBounds((int) (w*0.21), (int)(h*0.52), (int) (w*0.3), (int) (h*0.08));
	
	}
	
	
	/**
	 * helper method for retrieving and setting images
	 * @param name of image
	 * @return formatted image
	 * @throws IOException
	 */
	private Image getImage (String imageName) throws IOException {
		Image image = ImageIO.read(new File("images/end/finishLesson/"+imageName+".jpg"));
		Image scaledImage= image.getScaledInstance( 250, 80,  java.awt.Image.SCALE_SMOOTH ) ;
		return scaledImage;
	}
	
	
	/**
	 * helper method to set all the buttons
	 * @param button
	 * @throws IOException
	 */
	private void setButton(JButton button) throws IOException {
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		add(button);
	}

	
	/**
	 * method to set background image
	 */
	public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
     }

	
	/**
	 * This method deals with all the mouse control in the panel
	 */
	private void mouseControl() {

		playGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
				//InitFrame.game.setVisible(true);
				InitFrame.mainLayout.show(getParent(), "game");
			}
		});	
		
		gotoReviewList.addActionListener(new ActionListener() { //checks if reviewlist is empty and if not, 
																//calls lesson page after setting lessonNum to 0

			@Override
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
				try {
					reviewList = new ReviewList("wordLists/reviewlist.txt");
				} catch (Exception e2) {
					e2.printStackTrace();
				} 
				if (reviewList.getList().isEmpty()) {
//					InitFrame.oops.setVisible(true);
					InitFrame.mainLayout.show(getParent(), "oops");
				}else {
					Lesson.lessonNum = 0;				//set lesson number
					try {
						Lesson.initLabels();			//initialize labels again
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
//					InitFrame.lesson.setVisible(true);
					InitFrame.mainLayout.show(getParent(), "lesson");
				}
			}
		});	
		
		homePage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				InitFrame.main.setVisible(true);
				InitFrame.mainLayout.show(getParent(), "main");
			}
		});	
		
		nextLesson.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
				Lesson.lessonNum += 1;					//set lesson number
				try {
					Lesson.initLabels();				//initialize labels again 
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//				InitFrame.lesson.setVisible(true);
				InitFrame.mainLayout.show(getParent(), "lesson");
			}
		});	
		
	}

}

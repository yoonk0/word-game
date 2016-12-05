package views;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

import tools.ReviewList;

public class CongratulationsPanel extends JPanel{
	Image backgroundImage;
	JButton playGame, gotoReviewList, homePage, nextLesson;
	ReviewList reviewList; 
	
	public CongratulationsPanel(Image image) throws Exception{
		backgroundImage = image;
		initButtons();
		mouseControl();
		setLayout(null);
		
	}

	private void initButtons() throws IOException {

		Image image;
		image = getImage("playgame");
		playGame = new JButton(new ImageIcon(image));
		setButton(playGame);
		playGame.setBounds(530, 270, 250, 80);
		
		image = getImage("gotoreviewlist");
		gotoReviewList = new JButton(new ImageIcon(image));
		setButton(gotoReviewList);
		gotoReviewList.setBounds(530, 370, 250, 80);
		
		image = getImage("homepage");
		homePage = new JButton(new ImageIcon(image));
		setButton(homePage);
		homePage.setBounds(530, 470, 250, 80);
		
		image = getImage("nextlesson");
		nextLesson = new JButton(new ImageIcon(image));
		setButton(nextLesson);
		nextLesson.setBounds(530, 570, 250, 80);
	}
	
	private Image getImage (String imageName) throws IOException {
		Image image = ImageIO.read(new File("images/end/finishLesson/"+imageName+".jpg"));
		Image scaledImage= image.getScaledInstance( 250, 80,  java.awt.Image.SCALE_SMOOTH ) ;
		return scaledImage;
	}
	
	
	private void setButton(JButton button) throws IOException {
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		add(button);
	}

	public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
     }

	private void mouseControl() {

		playGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//InitFrame.game.setVisible(true);
			}
		});	
		
		gotoReviewList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					reviewList = new ReviewList("wordLists/reviewlist.txt");
				} catch (Exception e2) {
					e2.printStackTrace();
				} 
				if (reviewList.getList().isEmpty()) {
					InitFrame.oops.setVisible(true);
				}else {
					Lesson.lessonNum = 0;
					try {
						Lesson.initLabels();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					InitFrame.lesson.setVisible(true);
				}
			}
		});	
		
		homePage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				InitFrame.main.setVisible(true);
			}
		});	
		
		nextLesson.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Lesson.lessonNum += 1;
				try {
					Lesson.initLabels();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				InitFrame.lesson.setVisible(true);
			}
		});	
		
	}

}

package views;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import tools.ReviewList;

/**
 * This class represents the main menu page for the program
 * @author YoonKim
 *
 */
public class MainMenu extends JPanel{
	JButton watchLessonsButton, playGamesButton, reviewButton, exitButton;
	Image backgroundImage;
	ReviewList reviewList; 

	/**
	 * This is the constructor for the class 
	 * calls all the helper methods to initialize elements in the panel
	 * @param image
	 * @throws Exception
	 */
	public MainMenu(Image image) throws Exception {
		backgroundImage = image;
		initButtons();
		mouseControl();
		setLayout(null);
	}
	

	/**
	 * Helper method to set the buttons
	 * @throws IOException
	 */
	private void initButtons() throws IOException {
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;

		Image image;
		image = getImage("watchLessons");
		watchLessonsButton = new JButton(new ImageIcon(image));
		setButton(watchLessonsButton);
		watchLessonsButton.setBounds((int) (w*0.21), (int)(h*0.22), (int) (w*0.3), (int) (h*0.08));
		
		image = getImage("playGames");
		playGamesButton = new JButton(new ImageIcon(image));
		setButton(playGamesButton);
		playGamesButton.setBounds((int) (w*0.21), (int)(h*0.32), (int) (w*0.3), (int) (h*0.08));
		
		
		image = getImage("review");
		reviewButton = new JButton(new ImageIcon(image));
		setButton(reviewButton);
		reviewButton.setBounds((int) (w*0.21), (int)(h*0.42), (int) (w*0.3), (int) (h*0.08));
		
		
		image = getImage("exit");
		exitButton = new JButton(new ImageIcon(image));
		setButton(exitButton);
		exitButton.setBounds((int) (w*0.21), (int)(h*0.52), (int) (w*0.3), (int) (h*0.08));
	}
	
	/**
	 * helper method for initButtons to get&set images for the buttons
	 * @param name of the image
	 * @return formatted image
	 * @throws IOException
	 */
	private Image getImage (String imageName) throws IOException {
		Image image = ImageIO.read(new File("images/dash/"+imageName+".jpg"));
		Image scaledImage= image.getScaledInstance( 250, 80,  java.awt.Image.SCALE_SMOOTH ) ;
		return scaledImage;
	}
	
	/**
	 * helper method to set button settings
	 * @param button
	 * @throws IOException
	 */
	private void setButton(JButton button) throws IOException {
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		add(button);
	}

	
	/**
	 * graphics method to set background image 
	 */
	public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
     }

	
	/**
	 * This method deals with all the mouse control in the panel
	 */
	private void mouseControl() {

		watchLessonsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				InitFrame.lessonMenu.setVisible(true);
				InitFrame.mainLayout.show(getParent(), "lessonMenu");
			}
		});	
		
		playGamesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
				InitFrame.mainLayout.show(getParent(), "game");
			}
		});	
		
		
		reviewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
				try {
					reviewList = new ReviewList("wordLists/reviewlist.txt");
				} catch (Exception e2) {
					e2.printStackTrace();
				} 
				if (reviewList.getList().isEmpty()) {
//					InitFrame.oops.setVisible(true);			//if reviewList is empty show oops page
					InitFrame.mainLayout.show(getParent(), "oops");
				}else {
					Lesson.lessonNum = 0;			//set lesson number to 0 
					try {
						Lesson.initLabels();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
//					InitFrame.lesson.setVisible(true);
					InitFrame.mainLayout.show(getParent(), "lesson");
				}
			}
		});	
		
		
		
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});	
		
	}
}

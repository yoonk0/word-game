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


public class MainMenu extends JPanel {
	JButton watchLessonsButton, playGamesButton, reviewButton, exitButton;
	Image backgroundImage;
	ReviewList reviewList; 

	public MainMenu(Image image) throws Exception {
		backgroundImage = image;
		initButtons();
		mouseControl();
		setLayout(null);
	}
	


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
	
	private Image getImage (String imageName) throws IOException {
		Image image = ImageIO.read(new File("images/dash/"+imageName+".jpg"));
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

		watchLessonsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				InitFrame.lessonMenu.setVisible(true);
			}
		});	
		
		reviewButton.addActionListener(new ActionListener() {
			
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
						e1.printStackTrace();
					}
					InitFrame.lesson.setVisible(true);
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

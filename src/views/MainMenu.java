package views;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class MainMenu extends JPanel {
	JButton watchLessonsButton, playGamesButton, reviewButton, exitButton;
	Image backgroundImage;

	public MainMenu(Image image) throws Exception {
		backgroundImage = image;
		initButtons();
		mouseControl();
		setLayout(null);
	}
	


	private void initButtons() throws IOException {

		Image image;
		image = getImage("watchLessons");
		watchLessonsButton = new JButton(new ImageIcon(image));
		setButton(watchLessonsButton);
		watchLessonsButton.setBounds(530, 270, 250, 80);
		
		image = getImage("playGames");
		playGamesButton = new JButton(new ImageIcon(image));
		setButton(playGamesButton);
		playGamesButton.setBounds(530, 370, 250, 80);
		
		image = getImage("review");
		reviewButton = new JButton(new ImageIcon(image));
		setButton(reviewButton);
		reviewButton.setBounds(530, 470, 250, 80);
		
		image = getImage("exit");
		exitButton = new JButton(new ImageIcon(image));
		setButton(exitButton);
		exitButton.setBounds(530, 570, 250, 80);
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
				Lesson.lessonNum = 0;
				try {
					Lesson.initLabels();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				InitFrame.lesson.setVisible(true);
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

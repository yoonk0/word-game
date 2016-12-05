package views;

import java.awt.Font;
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
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OopsPanel extends JPanel{
	Image backgroundImage;
	JButton playGame, homePage, lessonMenu;
	JLabel text; 

	public OopsPanel(Image image) throws IOException {
		backgroundImage = image;
		initLabelsAndButtons();
		mouseControl();
		setLayout(null);
	}
	
	private void initLabelsAndButtons() throws IOException {
		Image image;

		text = new JLabel("Oops, there are no words in the review list yet!");
		add(text);
		text.setBounds(450, 250, 800, 100);
		text.setFont(new Font("calibri", Font.PLAIN, 24));
		
		image = getImage("homepage");
		homePage = new JButton(new ImageIcon(image));
		setButton(homePage);
		homePage.setBounds(530, 370, 250, 80);
		
		
		image = getImage("playGames");
		playGame = new JButton(new ImageIcon(image));
		setButton(playGame);
		playGame.setBounds(530, 470, 250, 80);
		
		image = getImage("watchLessons");
		lessonMenu = new JButton(new ImageIcon(image));
		setButton(lessonMenu);
		lessonMenu.setBounds(530, 570, 250, 80);
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

		playGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//InitFrame.game.setVisible(true);
			}
		});	
		
		homePage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				InitFrame.main.setVisible(true);
			}
		});	
		
		lessonMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				InitFrame.lessonMenu.setVisible(true);
			}
		});	
		
	}

}

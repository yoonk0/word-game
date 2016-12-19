package views;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;
import game.GamePanel;

public class GameMenuPanel extends JPanel{
	JButton lesson1Label, lesson2Label, lesson3Label, lesson4Label, lesson5Label, home;
	JLabel text;
	int width, height;
	Image backgroundImage;
	
	/**
	 * This is the constructor for the class
	 * @param background image for the panel
	 * @throws Exception
	 */
	public GameMenuPanel(Image image) throws Exception {
		backgroundImage = image;
		initButtons();
		mouseControl();
		setLayout(null);
	}
	/**
	 * helper method to initialize buttons
	 * @throws Exception
	 */
	private void initButtons() throws Exception{
		Image image; 
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		text = new JLabel("<html>Choose a lesson to play the Game. Answer a question for 200 points when you meet an animal friend"
				+ " and get 10 points for every coin. Aim for 1500 points! Good Luck!</html>");
		add(text);
		text.setBounds((int) (width*0.22), (int)(height*0.17), (int) (width*0.3), (int) (height*0.2));
		text.setFont(new Font("chalkboard", Font.PLAIN, 20));
		text.setForeground(new Color(0x744D0C));
		
		image = getImage("lesson1");
		lesson1Label = new JButton(new ImageIcon(image));
		setButton(lesson1Label);
		lesson1Label.setBounds((int) (width*0.2), (int)(height*0.25), (int) (width*0.55), (int) (height*0.2));
		
		image = getImage("lesson2");
		lesson2Label = new JButton(new ImageIcon(image));
		setButton(lesson2Label);
		lesson2Label.setBounds((int) (width*0.2), (int)(height*0.32), (int) (width*0.55), (int) (height*0.2));
		
		image = getImage("lesson3");
		lesson3Label = new JButton(new ImageIcon(image));
		setButton(lesson3Label);
		lesson3Label.setBounds((int) (width*0.2), (int)(height*0.39), (int) (width*0.55), (int) (height*0.2));
		
		image = getImage("lesson4");
		lesson4Label = new JButton(new ImageIcon(image));
		setButton(lesson4Label);
		lesson4Label.setBounds((int) (width*0.2), (int)(height*0.46), (int) (width*0.55), (int) (height*0.2));
		
		image = getImage("lesson5");
		lesson5Label = new JButton(new ImageIcon(image));
		setButton(lesson5Label);
		lesson5Label.setBounds((int) (width*0.2), (int)(height*0.53), (int) (width*0.55), (int) (height*0.2));
		
		image = getImage("homePage");
		home = new JButton(new ImageIcon(image));
		setButton(home);
		home.setBounds((int) (width*0.4), (int)(height*0.68), (int) (width*0.55), (int) (height*0.2));
		
	}
	
	/**
	 * Helper method to get&set image
	 * @param imageName
	 * @return
	 * @throws IOException
	 */
	private Image getImage (String imageName) throws IOException {
		Image image = ImageIO.read(new File("images/lessonlist/"+imageName+".png"));
		Image scaledImage= image.getScaledInstance( (int)(width*0.3), (int)(height*0.06),  java.awt.Image.SCALE_SMOOTH ) ;
		return scaledImage;
	}
	
	/**
	 * helper function to set buttons
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
        g.setFont(new Font("calibri", Font.BOLD, 40)); 
 
    }

	
	/**
	 * This method deals with all the mouse control in the panel
	 */
	private void mouseControl() {

		lesson1Label.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game game = null;
				try {
					game = new Game();						//create a new game jFrame
					GamePanel.setLessonNum(1);
					GamePanel.setWordList();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				game.setVisible(true);
				LaunchBoard.initFrame.setVisible(false);
			}
		});	
		
		lesson2Label.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Game game = null;
				try {
					game = new Game();
					GamePanel.setLessonNum(2);
					GamePanel.setWordList();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				game.setVisible(true);
				LaunchBoard.initFrame.setVisible(false);
			}
		});	
		
		lesson3Label.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Game game = null;
				try {
					game = new Game();
					GamePanel.setLessonNum(3);
					GamePanel.setWordList();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				game.setVisible(true);
				LaunchBoard.initFrame.setVisible(false);
			}
		});	
		
		lesson4Label.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Game game = null;
				try {
					game = new Game();
					GamePanel.setLessonNum(4);
					GamePanel.setWordList();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				game.setVisible(true);
				LaunchBoard.initFrame.setVisible(false);
			}
		});	
		
		lesson5Label.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Game game = null;
				try {
					game = new Game();
					GamePanel.setLessonNum(5);
					GamePanel.setWordList();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				game.setVisible(true);
				LaunchBoard.initFrame.setVisible(false);
			}
		});	
		
		home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InitFrame.mainLayout.show(getParent(), "main");
			}
		});	
		
	}
}

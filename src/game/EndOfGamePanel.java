package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import views.InitFrame;

/**
 * This class represents the end of game page that displays final score 
 * @author YoonKim
 *
 */
public class EndOfGamePanel extends JPanel{
	static JButton homePage; 
	static JLabel text; 
	int width; 
	int height; 
	
	/**
	 * Constructor for the class that calls the methods for initializing the page 
	 * @throws IOException
	 */
	public EndOfGamePanel() throws IOException {
		this.setLayout(null);
		this.setBackground(new Color(0xF9DEB1));
		this.setVisible(true);
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		initButtons();
		mouseControl();
	}
	
	/**
	 * initializes button for homepage
	 * @throws IOException
	 */
	private void initButtons() throws IOException {
		Image image = getImage("homepage");
		homePage = new JButton(new ImageIcon(image));	
		//homePage.setBounds(530, 370, 250, 80);
		homePage.setBounds((int) (width*0.21), (int)(height*0.70), (int) (width*0.3), (int) (height*0.08));
		setButton(homePage);
		
	}
	
	/**
	 * helper class for initializing buttons
	 * @param imageName
	 * @return Image that has been set 
	 * @throws IOException
	 */
	private Image getImage (String imageName) throws IOException {
		Image image = ImageIO.read(new File("images/dash/"+imageName+".jpg"));
		Image scaledImage= image.getScaledInstance( 250, 80,  java.awt.Image.SCALE_SMOOTH ) ;
		return scaledImage;
	}
	
	/**
	 * helper class for button setting
	 * @param button
	 * @throws IOException
	 */
	private void setButton(JButton button) throws IOException {
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		add(button);
	}

	
	/**
	 * This method deals with all the mouse control in the panel
	 */
	private void mouseControl() {
		
		homePage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
//				InitFrame.main.setVisible(true);
				InitFrame.mainLayout.show(getParent(), "main");
			}
		});	
		
	}
	
	/**
	 * This method draws the image and text to show the result of the game
	 * If the score is over 1500 (roughly 6-7 correct answers) it displays happy sloth and it will display a sad sloth otherwise
	 */
	 protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.setFont(new Font("calibri", Font.BOLD, 40)); 
	        g.drawString("Final Score: "+GamePanel.scores, (int)(width*0.27), (int)(height*0.1));
	        
	        Image image = null;
	    	try {
	        if (GamePanel.scores < 1500) {
				image = ImageIO.read(new File("images/game/sad.png"));
				g.drawString("Better Luck Next Time!", (int)(width*0.25), (int)(height*0.15));
				
	        } else {
	        	image = ImageIO.read(new File("images/game/happy.png"));
	        	g.drawString("Great Job!", (int)(width*0.28), (int)(height*0.2));
	        }
	    	} catch (IOException e) {
				e.printStackTrace();
			}
	        g.drawImage(image, (int)(width*0.25), (int)(height*0.2), (int)(width*0.2), (int)(height*0.5), this); 
	        
	        

	    }
	
}

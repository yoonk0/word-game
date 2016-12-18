package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import dictionary.XMLRequest;
import views.InitFrame;

/**
 * This class implements the page where a question pop up and prompts the user to answer
 * @author YoonKim
 *
 */
public class QuestionPanel extends JPanel{
	static JLabel definition; 
	JTextArea userInput; 
	JButton submit; 
	static String answer; 
	static ArrayList<String> words; 
	static int count;
	int width;
	int height;

	/**
	 * This is the constructor for the class, calling helper methods for setting the page
	 * @throws IOException
	 */
	public QuestionPanel() throws IOException {
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLayout(null);
		this.setBackground(new Color(0xF9DEB1));
		this.setVisible(true);
		setLabelsAndButtons();
		mouseControl();
	}
	
	/**
	 * This method initializes all labels and buttons
	 * This panel includes a text area for user input 
	 * @throws IOException
	 */
	private void setLabelsAndButtons() throws IOException {
		definition = new JLabel(); 
	    userInput = new JTextArea();
	   
	    add(definition); 
	    definition.setFont(new Font("calibri", Font.PLAIN, 32));
		definition.setBounds((int) (width*0.15), (int)(height*0.1), (int) (width*0.4), (int) (height*0.3));
		definition.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    add(userInput);
	    userInput.setEditable(true);
	    userInput.setPreferredSize(new Dimension((int) (width*0.15), (int) (height*0.06)));
	    userInput.setBounds((int) (width*0.25), (int)(height*0.6), (int) (width*0.15), (int) (height*0.06));
	    userInput.setBackground(Color.WHITE);
	    userInput.setVisible(true);
	    userInput.setFont(new Font("calibri", Font.PLAIN, 42));
	    
	   
	    Image image = ImageIO.read(new File("images/game/check.png"));
		Image scaledImage= image.getScaledInstance( 60, 60,  java.awt.Image.SCALE_SMOOTH ) ;
		submit = new JButton(new ImageIcon(scaledImage));
		add(submit); 
		submit.setBorder(BorderFactory.createEmptyBorder());
		submit.setContentAreaFilled(false);
		submit.setBounds((int) (width*0.40), (int)(height*0.6), (int) (width*0.06), (int) (height*0.06));
	

	}
	
	/**
	 * This method sends a request to pull definition & example sentence(if it exists) from the dictionary API
	 * and sets definition label and the answer to compare the userInput with
	 * It is set to public so that GamePanel class can access it and set the word every time it changes panels
	 * @param current word passed from the gamePanel
	 * @throws IOException
	 */
	public static void getXmlRequest(String word) throws IOException {
		XMLRequest xml = new XMLRequest(word);
		definition.setText("<html>"+xml.getDefinition()+"</html>");
		answer = word; 
	}
	

	/**
	 * Graphics
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.WHITE);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
		g2.fill3DRect(0, height, width, 200, true);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
	}
	
	/**
	 * This method deals with all the mouse control in the panel
	 * After 10th word in the lesson, the game ends and end of game page is shown 
	 * before then, user is taken back to game page upon answering th question 
	 */
	private void mouseControl() {

		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (userInput.getText().trim().toLowerCase().equals(answer)) {
					JOptionPane.showMessageDialog(getParent(), "Correct! +200 points", "A plain message", JOptionPane.PLAIN_MESSAGE);	
					GamePanel.scores += 200; 
					GamePanel.correctCount++;
					if (GamePanel.wordCount == 10) {				//after 10 words game ends
//						Game.layout.show(getParent(), "end");
						InitFrame.mainLayout.show(getParent(), "end");
					} else {
//					Game.layout.show(getParent(), "game");
						GamePanel.carT.resume();
						
						for(int i = 0; i < GamePanel.money1T.size(); i++)
							GamePanel.money1T.get(i).resume();
						
						for(int i = 0; i < GamePanel.money2T.size(); i++)
							GamePanel.money2T.get(i).resume();
						
						InitFrame.mainLayout.show(getParent(), "game");
					}
				} else {
					JOptionPane.showMessageDialog(getParent(), "Wrong Answer :( ", "A plain message", JOptionPane.PLAIN_MESSAGE);
					if (GamePanel.wordCount == 10) {
//						Game.layout.show(getParent(), "end");
						InitFrame.mainLayout.show(getParent(), "end");
					} else {
//					Game.layout.show(getParent(), "game");
						GamePanel.carT.resume();
						
						for(int i = 0; i < GamePanel.money1T.size(); i++)
							GamePanel.money1T.get(i).resume();
						
						for(int i = 0; i < GamePanel.money2T.size(); i++)
							GamePanel.money2T.get(i).resume();
						
						InitFrame.mainLayout.show(getParent(), "game");
					}
				}
				userInput.setText("");
				
			}
		});	
	}
}
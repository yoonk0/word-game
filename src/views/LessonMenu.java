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

/**
 * This class represents the lesson menu
 * @author YoonKim, Wen Zhong
 *
 */
public class LessonMenu  extends JPanel{
	JButton lesson1Label, lesson2Label, lesson3Label, lesson4Label, lesson5Label, home;
	Image backgroundImage;
	
	/**
	 * This is the constructor for the class
	 * @param background image for the panel
	 * @throws Exception
	 */
	public LessonMenu(Image image) throws Exception {
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
		setLayout(null);
		Image image; 
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		image = getImage("lesson1");
		lesson1Label = new JButton(new ImageIcon(image));
		setButton(lesson1Label);
		lesson1Label.setBounds((int) (w*0.25), (int)(h*0.14), (int) (w*0.55), (int) (h*0.2));
		
		image = getImage("lesson2");
		lesson2Label = new JButton(new ImageIcon(image));
		setButton(lesson2Label);
		lesson2Label.setBounds((int) (w*0.25), (int)(h*0.24), (int) (w*0.55), (int) (h*0.2));
		
		image = getImage("lesson3");
		lesson3Label = new JButton(new ImageIcon(image));
		setButton(lesson3Label);
		lesson3Label.setBounds((int) (w*0.25), (int)(h*0.34), (int) (w*0.55), (int) (h*0.2));
		
		image = getImage("lesson4");
		lesson4Label = new JButton(new ImageIcon(image));
		setButton(lesson4Label);
		lesson4Label.setBounds((int) (w*0.25), (int)(h*0.44), (int) (w*0.55), (int) (h*0.2));
		
		image = getImage("lesson5");
		lesson5Label = new JButton(new ImageIcon(image));
		setButton(lesson5Label);
		lesson5Label.setBounds((int) (w*0.25), (int)(h*0.54), (int) (w*0.55), (int) (h*0.2));
		
		image = getImage("homePage");
		home = new JButton(new ImageIcon(image));
		setButton(home);
		home.setBounds(980, 800, 720, 80);
		
	}
	
	/**
	 * Helper method to get&set image
	 * @param imageName
	 * @return
	 * @throws IOException
	 */
	private Image getImage (String imageName) throws IOException {
		Image image = ImageIO.read(new File("images/lessonlist/"+imageName+".png"));
		Image scaledImage= image.getScaledInstance( 650, 80,  java.awt.Image.SCALE_SMOOTH ) ;
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
    }

	
	/**
	 * This method deals with all the mouse control in the panel
	 */
	private void mouseControl() {

		lesson1Label.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Lesson.lessonNum = 1;
				try {
					Lesson.initLabels();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				InitFrame.mainLayout.show(getParent(), "lesson");
			}
		});	
		
		lesson2Label.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Lesson.lessonNum = 2;
				try {
					Lesson.initLabels();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				InitFrame.mainLayout.show(getParent(), "lesson");
			}
		});	
		
		lesson3Label.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Lesson.lessonNum = 3;
				try {
					Lesson.initLabels();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				InitFrame.mainLayout.show(getParent(), "lesson");
			}
		});	
		
		lesson4Label.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Lesson.lessonNum = 4;
				try {
					Lesson.initLabels();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				InitFrame.mainLayout.show(getParent(), "lesson");
			}
		});	
		
		lesson5Label.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Lesson.lessonNum = 5;
				try {
					Lesson.initLabels();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				InitFrame.mainLayout.show(getParent(), "lesson");
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

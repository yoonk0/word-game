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


public class LessonMenu  extends JPanel{
	JButton lesson1Label, lesson2Label, lesson3Label, lesson4Label, lesson5Label, home;
	Image backgroundImage;
	
	public LessonMenu(Image image) throws Exception {
		backgroundImage = image;
		initButtons();
		mouseControl();
		setLayout(null);
	}
	
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
	
	private Image getImage (String imageName) throws IOException {
		Image image = ImageIO.read(new File("images/lessonlist/"+imageName+".png"));
		Image scaledImage= image.getScaledInstance( 650, 80,  java.awt.Image.SCALE_SMOOTH ) ;
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

		lesson1Label.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Lesson.lessonNum = 1;
				try {
					Lesson.initLabels();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				InitFrame.lesson.setVisible(true);
			}
		});	
		
		lesson2Label.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Lesson.lessonNum = 2;
				try {
					Lesson.initLabels();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				InitFrame.lesson.setVisible(true);
			}
		});	
		
		lesson3Label.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Lesson.lessonNum = 3;
				try {
					Lesson.initLabels();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				InitFrame.lesson.setVisible(true);
			}
		});	
		
		lesson4Label.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Lesson.lessonNum = 4;
				try {
					Lesson.initLabels();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				InitFrame.lesson.setVisible(true);
			}
		});	
		
		lesson5Label.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Lesson.lessonNum = 5;
				try {
					Lesson.initLabels();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				InitFrame.lesson.setVisible(true);
			}
		});	
		
		home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				InitFrame.main.setVisible(true);
			}
		});	
		
		
		
		
	}

}

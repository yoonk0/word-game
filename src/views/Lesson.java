package views;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.media.CannotRealizeException;
import javax.media.NoPlayerException;
import javax.swing.*;

import dictionary.AudioPlayer;
import dictionary.Pronunciation;
import tools.*;


public class Lesson extends JPanel {
	static JButton prev, reviewList, next, delete, play;
	JPanel top, bottom, center;
	Image backgroundImage;
	static JLabel word;
	static JLabel image;
	static ArrayList<String> words; 
	static ReviewList review; 
	static int count;
	BorderLayout layout;
	public static int lessonNum = 1;
	
	public Lesson(Image image) throws Exception {
		backgroundImage = image;
		initButtons();
		initLabels();
		addLabelsAndButtons();
		mouseControl();
		setLayout(null);
		review = new ReviewList("wordLists/reviewlist.txt");
	}
	
	
	public static void initButtons() throws IOException {
		Image image;
		image = getImage("previous");
		prev = new JButton(new ImageIcon(image));
		image = getImage("next");
		next = new JButton(new ImageIcon(image));	
		image = getImage("add");
		reviewList = new JButton(new ImageIcon(image));	
		image = getImage("deletefromlist");
		delete = new JButton(new ImageIcon(image));	
		image = ImageIO.read(new File("images/card/lesson/play.png"));
		Image scaledImage= image.getScaledInstance( 280, 120,  java.awt.Image.SCALE_SMOOTH ) ;
		play = new JButton(new ImageIcon(scaledImage));	
	}
	
	public static void initLabels() throws Exception{
		System.out.println(lessonNum);
		String wordSrc;
		if(lessonNum == 0) {
			wordSrc = "wordLists/reviewlist.txt";
		}else {
			wordSrc = "wordLists/lesson"+lessonNum+".txt";
		}
		words = new ArrayList<>();
		count = 0;
		
		FileReader f = new FileReader(wordSrc);
		BufferedReader b = new BufferedReader(f);
		String word2;
		while((word2 = b.readLine()) != null){
			words.add(word2.toLowerCase());		//lowercase
		}
		b.close();
		
		if(words.size() > 0){
			Collections.shuffle(words);
			setWordAndImage(words.get(count));
		}
		if (lessonNum != 0) {
			reviewList.setVisible(true);
			delete.setVisible(false);
		} else {
			reviewList.setVisible(false);
			delete.setVisible(true);
		}
		
		if(count == 0) prev.setVisible(false);
		
	}
	
	private void addLabelsAndButtons() throws IOException {
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		add(word);
		word.setFont(new Font("calibri", Font.PLAIN, 32));
		word.setBounds((int) (w*0.18), (int)(h*0.03), (int) (w*0.3), (int) (h*0.08));
		word.setHorizontalAlignment(SwingConstants.CENTER);
		
		add(image);
		image.setBounds((int) (w*0.22), (int)(h*0.21), (int) (w*0.24), (int) (h*0.44));
		
		add(prev);
		setButton(prev);
		prev.setBounds((int) (w*0.12), (int)(h*0.78), (int) (w*0.1), (int) (h*0.08));

		add(next);
		setButton(next);
		next.setBounds((int) (w*0.50), (int)(h*0.79), (int) (w*0.1), (int) (h*0.08));
		
		add(reviewList); 
		setButton(reviewList);
		reviewList.setBounds((int) (w*0.30), (int)(h*0.78), (int) (w*0.25), (int) (h*0.08));
		
		add(delete); 
		setButton(delete);
		delete.setBounds((int) (w*0.25), (int)(h*0.78), (int) (w*0.20), (int) (h*0.06));
		
		add(play); 
		setButton(play);
		play.setBounds((int) (w*0.30), (int)(h*0.14), (int) (w*0.07), (int) (h*0.07));
		
	}

	private static void setWordAndImage(String currentWord) {
		if (word == null) {
			word = new JLabel(currentWord);
		} else {
			word.setText(words.get(count));
		}
		try {
			Image i = ImageIO.read(new File("images/words/"+currentWord+".jpg"));
			i= i.getScaledInstance( 400, 400,  java.awt.Image.SCALE_SMOOTH ) ;
			ImageIcon imc = new ImageIcon(i);
			if (image == null) {
				image = new JLabel(imc);
			} else {
				image.setIcon(imc);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private static Image getImage (String imageName) throws IOException {
		Image image = ImageIO.read(new File("images/card/lesson/"+imageName+".png"));
		Image scaledImage= image.getScaledInstance( 300, 80,  java.awt.Image.SCALE_SMOOTH ) ;
		return scaledImage;
	}
	
	
	private void setButton(JButton button) throws IOException {
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

	private void mouseControl() {

		prev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				count--;
				if(count >= 0){
					setWordAndImage(words.get(count));
					if(count == 0) prev.setVisible(false);
				}
			}
		});	
		
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
				if(count < words.size()){
					prev.setVisible(true);
					setWordAndImage(words.get(count));
				}else if(count == words.size()){
					setVisible(false);
					InitFrame.congrats.setVisible(true);					
				}
			}
		});	
		
		reviewList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						review.addElement(word.getText());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});	
		
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						review.deleteElement(word.getText());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});	
		
		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Pronunciation p;
				try {
					p = new Pronunciation(word.getText());
					AudioPlayer.play(p.getUrl());
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (NoPlayerException e1) {
					e1.printStackTrace();
				} catch (CannotRealizeException e1) {
					e1.printStackTrace();
				}
				
			}
		});	

	}
	
}

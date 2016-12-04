package views;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import tools.*;


public class Lesson extends JPanel {
	JButton prev, reviewList, next;
	JPanel top, bottom, center;
	Image backgroundImage;
	JLabel word, image;
	ArrayList<String> words; 
	int count;
	BorderLayout layout;
	public static int lessonNum =1;
	
	public Lesson(Image image) throws Exception {
		backgroundImage = image;
		initButtons();
		initLabels();
		addLabels();
		mouseControl();
		setLayout(null);
	}
	
	
	private void initButtons() throws IOException {
		Image image;
		image = getImage("previous");
		prev = new JButton(new ImageIcon(image));
		setButton(prev);
		prev.setBounds(150, 860, 250, 80);
		
		image = getImage("add");
		reviewList = new JButton(new ImageIcon(image));
		setButton(reviewList);
		reviewList.setBounds(610, 860, 250, 80);
		
		image = getImage("next");
		next = new JButton(new ImageIcon(image));
		setButton(next);
		next.setBounds(920, 860, 250, 80);
		
	}
	
	private void initLabels() throws Exception{
		
		
		String wordSrc = "wordLists/lesson"+lessonNum+".txt";
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
			//rl = new ReviewList("words/reviewlist" + lessonNum + ".txt");	
		}
		
	}
	
	private void addLabels() {
		add(word);
		word.setFont(new Font("calibri", Font.PLAIN, 32));
		word.setBounds(350, 30, 600, 80);
		word.setHorizontalAlignment(SwingConstants.CENTER);
		add(image);
		image.setBounds(450, 280, 400, 400);
	}

	private void setWordAndImage(String currentWord) {
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

	
	private Image getImage (String imageName) throws IOException {
		Image image = ImageIO.read(new File("images/card/lesson/"+imageName+".png"));
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
		//reviewList, next;
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
		
		
		
	}
	
}

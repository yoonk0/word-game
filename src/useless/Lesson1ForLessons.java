package useless;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Lesson1ForLessons extends JPanel implements MouseListener{
	JPanel top, center, bottom;
	JLabel word, lastWord, imageOrVideo, nextWord, reviewadder;
	
	public Lesson1ForLessons(){
		top = new JPanel();
		center = new JPanel();
		bottom = new JPanel();
		
		// need to provide setter for word
		word = new JLabel("hometown");
		imageOrVideo = new JLabel(new ImageIcon("images/wordcard1.jpg"));
		lastWord = new JLabel("<¡ª");
		lastWord.addMouseListener(this);
		nextWord = new JLabel("¡ª>");
		nextWord.addMouseListener(this);
		reviewadder = new JLabel("put it to the review list");
		reviewadder.addMouseListener(this);
		
		BorderLayout mainLayout = new BorderLayout();
		this.setLayout(mainLayout);
		
		center.add(imageOrVideo);
		top.add(word);
		word.setHorizontalAlignment(JLabel.CENTER);
		bottom.add(lastWord);
		bottom.add(reviewadder);
		bottom.add(nextWord);
		
		this.add(top, mainLayout.NORTH);
		this.add(center, mainLayout.CENTER);
		this.add(bottom, mainLayout.SOUTH);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.lastWord){
//			centerLayout.show(center, "word 1");
//			topLayout.show(top, "word 1");
//			setWord(word);
			word.setText("friend");
			imageOrVideo.setIcon(new ImageIcon("images/wordcard2.jpg"));
//			System.out.println("enter1");
		}else if(e.getSource() == this.nextWord){
//			centerLayout.show(center, "word 2");
			// TODO related to the reload of the page
//			setWord("friend");
//			topLayout.show(top, "word 2");
			word.setText("hometown");
			imageOrVideo.setIcon(new ImageIcon("images/wordcard1.jpg"));
//			System.out.println("enter2");
		}else if(e.getSource() == this.reviewadder){
			// TODO put the word to review list
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

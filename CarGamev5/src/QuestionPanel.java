
/**
*
* @author Wen Zhong
*/
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class QuestionPanel extends JPanel implements MouseListener{
	JButton A, B, C, D;
	int width;
	int height;
	
	public QuestionPanel(){
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLayout(null);
		
		ImageIcon image = new ImageIcon("images/A.png");
		A = new JButton(image);
		A.setBorder(BorderFactory.createEmptyBorder());
		A.setContentAreaFilled(false);
		A.setBounds(100, (int)(height * 0.75), 50, 50);
		A.addMouseListener(this);
		this.add(A);
		
		image = new ImageIcon("images/B.png");
		B = new JButton(image);
		B.setBorder(BorderFactory.createEmptyBorder());
		B.setContentAreaFilled(false);
		B.setBounds(300, (int)(height * 0.75), 50, 50);
		this.add(B);
		B.addMouseListener(this);
		
		image = new ImageIcon("images/C.png");
		C = new JButton(image);
		C.setBorder(BorderFactory.createEmptyBorder());
		C.setContentAreaFilled(false);
		C.setBounds(500, (int)(height * 0.75), 50, 50);
		this.add(C);
		C.addMouseListener(this);
		
		image = new ImageIcon("images/D.png");
		D = new JButton(image);
		D.setBorder(BorderFactory.createEmptyBorder());
		D.setContentAreaFilled(false);
		D.setBounds(700, (int)(height * 0.75), 50, 50);
		this.add(D);
		D.addMouseListener(this);
		
		this.setBackground(new Color(0x334454));
		this.setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.WHITE);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
		g2.fill3DRect(0, height - 250, width, 200, true);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == A){
			System.out.println("Correct");
			Game.layout.show(getParent(), "game panel");
		}else{
			System.out.println("Wrong");
		}
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
	
//	public void paint(Graphics g){
//		super.paint(g);
//		super.paintComponent(g);
//		g.setColor(new Color(0x334454));
//		g.fillRect(0, 0, width, height);
//	}
}

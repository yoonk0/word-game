
/**
*
* @author Wen Zhong
*/
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class Game extends JFrame{
	public static GamePanel panel = null;
	public static QuestionPanel qPanel = null;
	public static CongratulationsPanel cPanel = null;
	public static CardLayout layout = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game();
	}
	
	public Game(){
		layout = new CardLayout();
		this.setLayout(layout);
		panel = new GamePanel();
		Thread t = new Thread(panel);
		t.start();
		qPanel = new QuestionPanel();
		try {
//			Image im = (new ImageIcon("images/lessonfinished.jpg")).getImage();
//			Image im = ImageIO.read(new File("./images/lessonfinished.jpg"));
			cPanel = new CongratulationsPanel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(panel, "game panel");
		this.add(qPanel, "question panel");
		this.add(cPanel, "congratulation page");
		this.addKeyListener(panel);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setVisible(true);
		this.setSize(width / 3 * 2, height - 100);
		this.setLocation(200, 0);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

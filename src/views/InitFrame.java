package views;
/**
 * Main frame that contains panels, mainMenu, lessonMenu, lesson and congrats
 */

import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class InitFrame extends JFrame {
	public static CardLayout mainLayout;
	public static MainMenu main; 
	public static LessonMenu lessonMenu;
	public static Lesson lesson;
	public static int lessonNum; 
	public static CongratulationsPanel congrats;
	public static OopsPanel oops; 
//	public static ReviewPanel review; 
//	public static gamePanel game; 


	public InitFrame() throws Exception{
		initFrame();
		addPanels();
	}
	
	private void initFrame() {
		lessonNum = 1;
		mainLayout = new CardLayout();
		this.setLayout(mainLayout);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setVisible(true);
		this.setSize(width / 3 * 2, height - 100);
		this.setLocation(200, 0);
		this.setResizable(false);		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void addPanels() throws Exception {
		Image image = ImageIO.read(new File("images/dash/dashwith.jpg"));
		main= new MainMenu(image);
		oops = new OopsPanel(image);
		image = ImageIO.read(new File("images/dash/dashwith.jpg"));
		lessonMenu = new LessonMenu(image);
		image = ImageIO.read(new File("images/card/lesson/cardwith.jpg"));
		lesson = new Lesson(image);
		image = ImageIO.read(new File("images/end/finishLesson/lessonfinished.jpg"));
		congrats = new CongratulationsPanel(image);	
		this.add(main, "main");
		this.add(lessonMenu, "lessonMenu");
		this.add(lesson, "lesson");
		this.add(congrats, "congrats");
		this.add(oops, "oops");
	}

}

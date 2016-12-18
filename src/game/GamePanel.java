package game;

/**
*
* @author Wen Zhong
*/
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import views.InitFrame;


public class GamePanel extends JPanel implements KeyListener, Runnable, MouseListener{
	Car car = null;
	public static Thread carT = null;
	
	ArrayList<Plant> plants = null;
	int numOfPlants;
	
	Obstacle obstacle = null;
	
	ArrayList<Cloud> clouds = null;
	int numOfClouds;
	
	Sun sun = null;
	Thread sunT = null;
	
	ArrayList<House> houses = null;
	int numOfHouses;
	
	
	
	ArrayList<Money> money1 = null;
	public static ArrayList<Thread> money1T = null;
	ArrayList<Money> money2 = null;
	public static ArrayList<Thread> money2T = null;
	int numOfMoney1;
	int numOfMoney2;
	
	// get a coin will get 100 scores, answer a question correctly will get 500 scores. user should get at least ? scores to pass
	static int scores;
	
	int width;
	int height;
	
	//for questions panel; 
	public static int lessonNum = 4;				//can be set from other classes 
	static int wordCount = 0;   //current word count
	static ArrayList<String> words; 
	// count the number that questions answered correctly (game ends when the user answers 10 correctly)
	static int correctCount;
	
	public GamePanel() throws IOException {
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLayout(null);
		
		scores = 0;
		Image image = ImageIO.read(new File("images/game/car.png"));
		image= image.getScaledInstance( (int)(width*0.2), (int)(height*0.2),  java.awt.Image.SCALE_SMOOTH ) ;
		car = new Car(0, (int)(height * 0.65), new ImageIcon(image));
		carT = new Thread(car);
		carT.start();
		plants = new ArrayList<>();
		clouds = new ArrayList<>();
		houses = new ArrayList<>();
		money1 = new ArrayList<>();
		money1T = new ArrayList<>();
		money2 = new ArrayList<>();
		money2T = new ArrayList<>();
		sun = new Sun();
		sunT = new Thread(sun);
		sunT.start();
		
		numOfPlants = 8;
		numOfClouds = 8;
		numOfHouses = 8;
		numOfMoney1 = 4;
		numOfMoney2 = 6;
		
		setWordList(); //set lesson 
		
		// plants
		for(int i = 0; i < numOfPlants; i++){
			Plant tmp = new Plant(i * 166 + 4, (int)(height * 0.6));
			plants.add(tmp);
			Thread plantT = new Thread(tmp);
			plantT.start();
		}
		
		// obstacles
		obstacle = new Obstacle((int)(width * 0.5));
		Thread obsT = new Thread(obstacle);
		obsT.start();
		
		// clouds
		for(int i = 0; i < numOfClouds; i++){
			Cloud tmp = new Cloud();
			clouds.add(tmp);
			Thread t = new Thread(tmp);
			t.start();
		}
		
		// houses
		for(int i = 0; i < numOfHouses; i++){
			House tmp = new House();
			houses.add(tmp);
			Thread houseT = new Thread(tmp);
			houseT.start();
		}
		
		// money
		for(int i  = 0; i < numOfMoney1; i++){
			int tempx = (int)(car.getX() + car.getSizeWidth() + (obstacle.getX() - car.sizeWidth - car.getX()) * Math.random());
			int tempy = (int)(height * (0.65 + Math.random() * 0.18));
			Money tmp = new Money(tempx, tempy);
			money1.add(tmp);
			Thread t = new Thread(tmp);
			money1T.add(t);
			t.start();
		}
				
		for(int i = 0; i < numOfMoney2; i++){
			int tempx = (int)(obstacle.getX() + obstacle.getSizeWidth() + (width - obstacle.getX() + obstacle.getSizeWidth()) * Math.random());
			int tempy = (int)(height * (0.65 + Math.random() * 0.18));
			Money tmp = new Money(tempx, tempy);
			money2.add(tmp);
			Thread t = new Thread(tmp);
			money2T.add(t);
			t.start();
		}
		
	
	}
	
	private void setWordList() throws IOException {
		String wordSrc = "wordLists/lesson"+lessonNum+".txt";
		words = new ArrayList<>();
		FileReader f = new FileReader(wordSrc);
		BufferedReader b = new BufferedReader(f);
		String word2;
		while((word2 = b.readLine()) != null){
			words.add(word2.toLowerCase());		//lowercase
		}
		b.close();
		if(words.size() > 0){
			Collections.shuffle(words);
		}
	}
	
	public void paint(Graphics g){
		try {
			Image image = ImageIO.read(new File("images/game/gameBackground.jpeg"));
			g.drawImage(image, 0, 0, null); 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(isHit()){
				try {
					QuestionPanel.getXmlRequest(words.get(wordCount));
				} catch (IOException e) {
					e.printStackTrace();
				}
//				Game.layout.show(getParent(), "question");
				sunT.suspend();
				carT.suspend();
				
				for(int i = 0; i < money1T.size(); i++)
					money1T.get(i).suspend();
				
				for(int i = 0; i < money2T.size(); i++)
					money2T.get(i).suspend();
				
				InitFrame.mainLayout.show(getParent(), "question");
				wordCount++; 
				obstacle = new Obstacle(width);
				Thread obsT = new Thread(obstacle);
				obsT.start();
		}
		
		for(int i = 0; i < money1.size(); i++){
			Money tmp = money1.get(i);
			hitMoney(tmp);
		}
		
		for(int i = 0; i < money2.size(); i++){
			Money tmp = money2.get(i);
			hitMoney(tmp);
		}
		
//		System.out.println("scores : " + scores);
		
//		super.paint(g);
//		g.setColor(new Color(0xc2d0e3));
//		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("calibri",Font.BOLD, 24)); 
		g.drawString("Scores : " + scores, (int)(width * 0.55), 50);
		
		// draw sun
		Graphics2D g2 = (Graphics2D)g;
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, sun.getOpacity()));
		g2.drawImage(sun.getImage().getImage(), sun.getX(), sun.getY(), sun.getSizeWidth(), sun.getSizeHeight(), this);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		
		// draw house
		for(int i = 0; i < houses.size(); i++){
			House tmp = houses.get(i);
			g.drawImage(tmp.getImage().getImage(), tmp.getX(), tmp.getY(), tmp.getSizeWidth(), tmp.getSizeHeight(), this);
		}
		
		for(int i = 0; i < houses.size(); i++){
			House tmp = houses.get(i);
			
			if(!tmp.isLive()){
				houses.remove(i);
				House newh = new House();
				newh.setX(width + 166);
				Thread newhT = new Thread(newh);
				newhT.start();
				houses.add(newh);
			}
		}
		
		// draw clouds
		for(int i = 0; i < clouds.size(); i++){
			Cloud tmp = clouds.get(i);
			g.drawImage(tmp.getImage().getImage(), tmp.getX(), tmp.getY(), tmp.getSizeWidth(), tmp.getSizeHeight(), this);
		}
		
		
		// draw plants
		for(int i = 0; i < plants.size(); i++){
			Plant tmp = plants.get(i);
			g.drawImage(tmp.getImage().getImage(), tmp.getX(), (int)(height * 0.6 - tmp.getImage().getIconHeight() * 0.2) + 20, tmp.getSizeWidth(), tmp.getSizeHeight(), this);
		}
		
		// need to sepearte, otherwise there will be a flash
		for(int i = 0; i < plants.size(); i++){
			Plant tmp = plants.get(i);
		
			if(!tmp.isLive()){
				plants.remove(i);
				Plant newp = new Plant(plants.get(plants.size() - 1).getX() + 166, (int)(height * 0.6));
				Thread newpT = new Thread(newp);
				newpT.start();
				plants.add(newp);
			}
		}
		
		// draw obstacles
		g.drawImage(obstacle.getImage().getImage(), obstacle.getX(), obstacle.getY(), obstacle.getSizeWidth(), obstacle.getSizeHeight(), this);
		
		// draw car
		g.drawImage(car.getImage().getImage(), car.getX(), car.getY() - 20, car.getSizeWidth(), car.getSizeHeight(), this);
	
		// draw money
		for(int i = 0; i < money1.size(); i++){
			Money tmp = money1.get(i);
			if(tmp.isLive()){
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, tmp.getOpacity()));
				g2.drawImage(tmp.getImage().getImage(), tmp.getX(), tmp.getY(), tmp.getSizeWidth(), tmp.getSizeHeight(), this);
			}
		}
		
		for(int i = 0; i < money2.size(); i++){
			Money tmp = money2.get(i);
			if(tmp.isLive()){
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, tmp.getOpacity()));
				g2.drawImage(tmp.getImage().getImage(), tmp.getX(), tmp.getY(), tmp.getSizeWidth(), tmp.getSizeHeight(), this);
		
			}
		}
		
		for(int i = 0; i < money1.size(); i++){
			Money tmp = money1.get(i);
			if(!tmp.isLive()){
				money1.remove(i);
				money1T.remove(i);
				int tempx = (int)(car.getX() + car.getSizeWidth() + (obstacle.getX() - car.sizeWidth - car.getX()) * Math.random());
				int tempy = (int)(height * (0.65 + Math.random() * 0.18));
				Money newm = new Money(tempx, tempy);
				newm.setX(width + 166);
				money1.add(newm);
				Thread t = new Thread(newm);
				money1T.add(t);
				t.start();
			}
		}
		
		for(int i = 0; i < money2.size(); i++){
			Money tmp = money2.get(i);
			if(!tmp.isLive()){
				money2.remove(i);
				money2.remove(i);
				int tempx = (int)(obstacle.getX() + obstacle.getSizeWidth() + (width - obstacle.getX() + obstacle.getSizeWidth()) * Math.random());
				int tempy = (int)(height * (0.65 + Math.random() * 0.18));
				Money newm = new Money(tempx, tempy);
				newm.setX(width + 166);
				money2.add(newm);
				Thread t = new Thread(newm);
				money2T.add(t);
				t.start();
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			car.setSpeed(10);
			car.moveUp((int)(height * 0.6 - plants.get(0).getImage().getIconHeight() * 0.2) + 20 +  (int)(plants.get(0).getImage().getIconHeight() * 0.2));
			break;
		case KeyEvent.VK_DOWN:
			car.setSpeed(10);
			car.moveDown((int)(height*0.78));
			break;
		case KeyEvent.VK_RIGHT:
			car.setSpeed(10);	
			obstacle.setSpeed(10);
			
			// change the speed of plants
			for(int i = 0; i < plants.size(); i++){
				Plant tmp = plants.get(i);
				tmp.setSpeed(10);
			}
			
			// change the speed of houses
			for(int i = 0; i < houses.size(); i++){
				House tmp = houses.get(i);
				tmp.setSpeed(10);
			}
			
//			 change the speed of money
			for(int i = 0; i < money1.size(); i++){
				Money tmp = money1.get(i);
				tmp.setSpeed(10);
			}
			
			for(int i = 0; i < money2.size(); i++){
				Money tmp = money2.get(i);
				tmp.setSpeed(10);
			}
				
			break;
		}
		
		this.repaint();
	}
	
	public boolean isHit(){
		if(car.getX() + car.getSizeWidth() >= obstacle.getX()
				&& car.getX() <= obstacle.getX() + obstacle.getSizeWidth()
				&& car.getY() <= obstacle.getY() + obstacle.getSizeHeight()
				&& car.getY() + car.getSizeHeight() - 13 > obstacle.getY())
			return true;
		return false;
	}

	public boolean hitMoney(Money m){
		if(car.getX() + car.getSizeWidth() >= m.getX() && m.isLive()
				&& ((car.getY() <= m.getY() && car.getY() + car.getSizeHeight() >= m.getY()) 
						|| (car.getY() <= m.getY() + m.getSizeHeight() && car.getY() + car.getSizeHeight() >= m.getY() + m.getSizeHeight()))){
			scores += 10; 
			m.setLive(false);
		}
		
		return m.isLive();
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			car.setSpeed(2);
			break;
		case KeyEvent.VK_DOWN:
			car.setSpeed(2);
			break;
		case KeyEvent.VK_RIGHT:
			car.setSpeed(2);
			
			// change the speed of obstacle
			obstacle.setSpeed(2);
			
			// change the speed of plants
			for(int i = 0; i < plants.size(); i++){
				Plant tmp = plants.get(i);
				tmp.setSpeed(2);
			}
						
			// change the speed of houses
			for(int i = 0; i < houses.size(); i++){
				House tmp = houses.get(i);
				tmp.setSpeed(2);
			}
						
			// change the speed of money
			for(int i = 0; i < money1.size(); i++){
				Money tmp = money1.get(i);
				tmp.setSpeed(2);
			}
			
			for(int i = 0; i < money2.size(); i++){
				Money tmp = money2.get(i);
				tmp.setSpeed(2);
			}
			break;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				Thread.sleep(100);
			}catch(Exception e){
				e.printStackTrace();
			}
			this.repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

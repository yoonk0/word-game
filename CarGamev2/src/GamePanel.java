
/**
*
* @author Wen Zhong
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class GamePanel extends JPanel implements KeyListener, Runnable, MouseListener{
	Car car = null;
	ArrayList<Plant> plants = null;
	int numOfPlants;
	Obstacle obstacle = null;
	ArrayList<Cloud> clouds = null;
	int numOfClouds;
	Sun sun = null;
	ArrayList<House> houses = null;
	int numOfHouses;
	int count;
	ArrayList<Money> money1 = null;
	ArrayList<Money> money2 = null;
	int numOfMoney1;
	int numOfMoney2;
	
	int width;
	int height;
	
	public GamePanel() {
		width = Toolkit.getDefaultToolkit().getScreenSize().width;
		height = Toolkit.getDefaultToolkit().getScreenSize().height;
		count = 15;
		this.setLayout(null);
		
		car = new Car(0, (int)(height * 0.65), new ImageIcon("images/1.png"));
		Thread carT = new Thread(car);
		carT.start();
		plants = new ArrayList<>();
		clouds = new ArrayList<>();
		houses = new ArrayList<>();
		money1 = new ArrayList<>();
		money2 = new ArrayList<>();
		sun = new Sun();
		Thread sunT = new Thread(sun);
		sunT.start();
		
		numOfPlants = 8;
		numOfClouds = 8;
		numOfHouses = 8;
		numOfMoney1 = 4;
		numOfMoney2 = 6;
		
		// plants
		for(int i = 0; i < numOfPlants; i++){
			Plant tmp = new Plant(i * 166 + 4, (int)(height * 0.6));
			plants.add(tmp);
			Thread plantT = new Thread(tmp);
			plantT.start();
		}
		
		// obstacles
//		obstacle = new Obstacle((int)(width * 0.5), (int)(height * 0.65) - 25);
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
			t.start();
		}
				
		for(int i = 0; i < numOfMoney2; i++){
			int tempx = (int)(obstacle.getX() + obstacle.getSizeWidth() + (width - obstacle.getX() + obstacle.getSizeWidth()) * Math.random());
			int tempy = (int)(height * (0.65 + Math.random() * 0.18));
			Money tmp = new Money(tempx, tempy);
			money2.add(tmp);
			Thread t = new Thread(tmp);
			t.start();
		}
	}
	
	public void paint(Graphics g){
		if(isHit()){
			if(count >= 0){
				Game.layout.show(getParent(), "question panel");
				obstacle = new Obstacle(width);
				Thread obsT = new Thread(obstacle);
				obsT.start();
				count--;
			}else{
				Game.layout.show(getParent(), "congratulation page");
			}
		}
		
		
		super.paint(g);
		g.setColor(new Color(0x334454));
		g.fillRect(0, 0, width, height);
		
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
		
		// draw obstacles
		g.drawImage(obstacle.getImage().getImage(), obstacle.getX(), obstacle.getY(), obstacle.getSizeWidth(), obstacle.getSizeHeight(), this);
		
		// draw car
		g.drawImage(car.getImage().getImage(), car.getX(), car.getY() - 20, car.getSizeWidth(), car.getSizeHeight(), this);
	
		// draw money
//		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, sun.getOpacity()));
//		g2.drawImage(sun.getImage().getImage(), sun.getX(), sun.getY(), sun.getSizeWidth(), sun.getSizeHeight(), this);
//		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		for(int i = 0; i < money1.size(); i++){
			Money tmp = money1.get(i);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, tmp.getOpacity()));
			g2.drawImage(tmp.getImage().getImage(), tmp.getX(), tmp.getY(), tmp.getSizeWidth(), tmp.getSizeHeight(), this);
		}
		
		for(int i = 0; i < money2.size(); i++){
			Money tmp = money2.get(i);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, tmp.getOpacity()));
			g2.drawImage(tmp.getImage().getImage(), tmp.getX(), tmp.getY(), tmp.getSizeWidth(), tmp.getSizeHeight(), this);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			car.moveUp((int)(height * 0.6 - plants.get(0).getImage().getIconHeight() * 0.2) + 20 +  (int)(plants.get(0).getImage().getIconHeight() * 0.2));
			break;
		case KeyEvent.VK_DOWN:
			car.moveDown((int)(height*0.78));
			break;
		case KeyEvent.VK_RIGHT:
			if(!isHit()){
				if(car.getX() <= this.getWidth() / 3)
					car.moveRight();
				
				for(int i = 0; i < plants.size(); i++){
					Plant tmp = plants.get(i);
					tmp.move();
					if(tmp.getX() + tmp.getSizeWidth() < 0){
						plants.remove(i);
						Plant newp = new Plant(plants.get(plants.size() - 1).getX() + 166, (int)(height * 0.6));
						plants.add(newp);
					}
				}
				
				for(int i = 0; i < houses.size(); i++){
					House tmp = houses.get(i);
					tmp.move();
					if(tmp.getX() + tmp.getSizeWidth() < 0){
						houses.remove(i);
						House newh = new House();
						newh.setX(width + 166);
						houses.add(newh);
					}
				}
				
				
				for(int i = 0; i < money1.size(); i++){
					Money tmp = money1.get(i);
					tmp.move();
					if(tmp.getX() + tmp.getSizeWidth() < 0){
						money1.remove(i);
						int tempx = (int)(car.getX() + car.getSizeWidth() + (obstacle.getX() - car.sizeWidth - car.getX()) * Math.random());
						int tempy = (int)(height * (0.65 + Math.random() * 0.18));
						Money newm = new Money(tempx, tempy);
						newm.setX(width + 166);
						money1.add(newm);
						Thread t = new Thread(newm);
						t.start();
					}
				}
				
				for(int i = 0; i < money2.size(); i++){
					Money tmp = money2.get(i);
					tmp.move();
					if(tmp.getX() + tmp.getSizeWidth() < 0){
						money2.remove(i);
						int tempx = (int)(obstacle.getX() + obstacle.getSizeWidth() + (width - obstacle.getX() + obstacle.getSizeWidth()) * Math.random());
						int tempy = (int)(height * (0.65 + Math.random() * 0.18));
						Money newm = new Money(tempx, tempy);
						newm.setX(width + 166);
						money2.add(newm);
						Thread t = new Thread(newm);
						t.start();
					}
				}
				
				obstacle.move();
			}
			break;
		}
		
		this.repaint();
		
		if(obstacle.getX() + obstacle.getSizeWidth() < 0) 
			obstacle = new Obstacle(width);
	}
	
	public boolean isHit(){
		if(car.getX() + car.getSizeWidth() >= obstacle.getX()
				&& car.getY() <= obstacle.getY() + obstacle.getSizeHeight()
				&& car.getY() + car.getSizeHeight() - 13 > obstacle.getY())
			return true;
		return false;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
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

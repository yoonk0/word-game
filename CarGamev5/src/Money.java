
/**
*
* @author Wen Zhong
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class Money extends Element implements Runnable{
	float opacity;
	float opSpeed;
	boolean flag;
	boolean isLive;
	
	public Money(int x, int y){
		super(x, y);
		
		flag = false;
		isLive = true;
		opSpeed = 0.1f;
		opacity = 1.0f;
	}
	
	@Override
	public void run() {
		while(true){
			try{
				Thread.sleep(50);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			if(flag){
				opacity += opSpeed;
				if(opacity - 1 < 1e-6){
					flag = false;
					opacity = 1.0f;
				}
			}else{
				opacity -= opSpeed;
				if(opacity - 0 < 1e-6){
					flag = true;
					opacity = 0.0f;
				}
			}
			if(x + sizeWidth < 0) isLive = false;
			move();
		}
	}

	public float getOpacity() {
		return opacity;
	}

	public void setOpacity(float opacity) {
		this.opacity = opacity;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	public float getOpSpeed() {
		return opSpeed;
	}

	public void setOpSpeed(float opSpeed) {
		this.opSpeed = opSpeed;
	}
}

package Entity;

import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
	private double x,dx=0,dy=0;
	private double y;
	private final double FRICTION = 2 ,FRICTIONUP = 1, SPEED = 6 , SPEEDUP = 12;
	private boolean left;
	private boolean right;
	private boolean up;

	private ScoreBoard sb;
	private int score,num;

	private BufferedImage p ;

	public Player(int num) {		

		score = 0;
		sb = new ScoreBoard();
		this.num = num;
		try {
			if(num%2==0){
				p = ImageIO.read(
						getClass().getResourceAsStream(
								"/Player/pikaP2.png"
								)
						);		
			}else {
				p = ImageIO.read(
						getClass().getResourceAsStream(
								"/Player/pikaP1.png"
								)
						);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	//	public void setJumping(boolean b) {
	//		jumping = b;
	//	}
	//	public void setSmashing(boolean b) {
	//		smashing = b;
	//	}
	public void setUp(boolean b) {
		up = b;
	}
	//	public void setDown(boolean b) {
	//		down = b;
	//	}
	public void setLeft(boolean b) {
		left = b;
	}
	public void setRight(boolean b) {
		right = b;
	}

	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}

	private void getNextPosition(Bound b) {
		//		 movement
		//		willOutOfBound(dx,b);
		if(num == 1){
			if(left && x + dx > 0 ) {
				dx = SPEED*(-1);
			}
			else if(right && x + dx < b.getWx() - 50 ) {
				dx = SPEED;
			}
			if(up && dy ==0) {
			   dy = SPEEDUP*(-1);
			}
			
		}else {
			if(left && x - dx > b.getWx() + 30 ) {
				dx = SPEED*(-1);
			}
			else if(right && x + dx < b.getWIDTH() - 50) {
				dx = SPEED;
			}
			if(up && dy ==0) {
				dy = SPEEDUP*(-1);
			}
		}

		if( dx > 0 ) dx -= FRICTION;
		if( dx < 0 ) dx += FRICTION;
		if( dy < 0 ) dy += FRICTIONUP;
		if( dy > 0 ) dy -= FRICTIONUP;
		
		if(dy == 0 && y < 190 ) {
			dy = SPEEDUP;
		}
		
		x = (int)x + dx;
		y = (int)y + dy;
		
		if(y > 190){
			y=190;
		}



	}

	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void update(Bound b) {
		getNextPosition(b);
		setPosition(x, y);		
	}


	public void draw(Graphics2D g) {
		g.drawImage(p,(int)x,(int)y,null);
		sb.writeScore(g);
	}


	public void setPosScore(int xPos,int yPos) {
		sb.setScoreBoard(xPos, yPos);
	}
	public void scoreUpdate() {
		score++;
		sb.setScore(score);
	}


}

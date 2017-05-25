package Entity;

import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
	private double x;
	private double y;
	
	private int width;
	private int height;
	
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	private boolean idle;
	private boolean hitting;
	private boolean smashing;
	private boolean jumping;
	
	private double moveSpeed;
	private double maxSpeed;
	private double stopSpeed;
	private double fallSpeed;
	private double maxFallSpeed;
	private double jumpStart;
	private double stopJumpSpeed;

	private static final int IDLE = 0;
	private static final int WALKING = 1;
	private static final int JUMPING = 2;
	private static final int HITTING = 3;
	private static final int SMASHING = 4;
	
	private ArrayList<BufferedImage[]> sprites;
	private final int[]numFrames = {
			
	};
	
	
	ScoreBoard sb;
	int score;
	
	BufferedImage p ;

	public Player() {		
		moveSpeed = 1.3;
		maxSpeed = 1.6;
		stopSpeed = 0.4;
		fallSpeed = 0.15;
		maxFallSpeed = 4.0;
		jumpStart = -4.8;
		stopJumpSpeed = 0.3;
		
		score = 0;
		sb = new ScoreBoard();
		
		try {
			p = ImageIO.read(
				getClass().getResourceAsStream(
					"/Player/pika.png"
				)
			);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void setJumping(boolean b) {
		jumping = b;
	}
	public void setSmashing(boolean b) {
		smashing = b;
	}
	public void setUp(boolean b) {
		up = b;
	}
	public void setDown(boolean b) {
		down = b;
	}
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
		if(left) {
			if(willOutOfBound(b)){
				x -= moveSpeed;
			}
		}
		else if(right) {
			if(willOutOfBound(b)){
				x += moveSpeed;
			}
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
	
	public boolean willOutOfBound(Bound b){
		if (0<x && x< b.getWx()-10){
			if (left){
				if(x-moveSpeed < 0){
					return false;
				}
			}
			else if (right){
				if(x+moveSpeed+40 > b.getWx()-10){
					return false;
				}
			}
		}
		if (x > b.getWx()+10 && x < b.getWIDTH()){
			if (left){
				if(x-moveSpeed-10 < b.getWx()+10){
					return false;
				}
			}
			else if (right){
				if(x+moveSpeed+50 > b.getWIDTH()){
					return false;
				}
			}
		}
		
		return true;
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
//	public int getScore() {
//		return score;
//	}
	

	
//	public void setLeft(boolean b) { left = b; }
//	public void setRight(boolean b) { right = b; }
//	public void setUp(boolean b) { up = b; }
//	public void setDown(boolean b) { down = b; }
//	public void setJumping(boolean b) { jumping = b; }
	
	
}

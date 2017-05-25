package Entity;

import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
	private double x,dx=0,dy=0;
	private double y;
	private final double FRICTION = 0.1 , SPEED = 2;
	private boolean left;
	private boolean right;

	ScoreBoard sb;
	int score;

	BufferedImage p ;

	public Player(int num) {		

		score = 0;
		sb = new ScoreBoard();

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
	//	public void setUp(boolean b) {
	//		up = b;
	//	}
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
		if(left) {
			if(willOutOfBound(b)){
				dx = SPEED*(-1);
			}
		}
		else if(right) {
			if(willOutOfBound(b)){
				dx = SPEED;
			}
		}

		if( dx > 0 ) dx -= FRICTION;
	    if( dx < 0 ) dx += FRICTION;

		x = x + dx;




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
		if (x > 0 && x< b.getWx()-10){
			if (left){
				if(x < 2){
					return false;
				}
			}
			else if (right){
				if(x > b.getWx()-10){
					return false;
				}
			}
		}
		if (x > b.getWx()+10 && x < b.getWIDTH()){
			if (left){
				if(x < b.getWx()+10){
					return false;
				}
			}
			else if (right){
				if(x > b.getWIDTH()){
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


}

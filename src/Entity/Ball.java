package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import GameState.GameState;
import Main.GamePanel;

public class Ball  {

	private BufferedImage b ;
	private static final double SPEED_BALL = 1.5;
	private double x,y,dx,dy;


	//	private int width,height;
	//	private boolean left,right,up,down;
	//	
	//	private double moveSpeed,maxSpeed;
	//	protected double stopSpeed;
	//	protected double fallSpeed;
	//
	//
	//	private static final int IDLE = 0;
	//	private static final int WALKING = 1;
	//	private static final int JUMPING = 2;
	//


	public Ball() {

		try {

			b = ImageIO.read(
					getClass().getResourceAsStream(
							"/Ball/ball.png"
							)
					);

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		dx = SPEED_BALL;
		dy = SPEED_BALL;

	}

	private void getNextPosition(Bound b) {
		
		if (x < 0 || x > b.getWIDTH() - 30) {
			dx = dx * (-1);
		}
		
		if (y < 0 || y > b.getHEIGHT() - 30) {
			dy = dy * (-1);
		}
		
//		if (y + 80 > b.getP1y() && 
//				(x > b.getP1x() - 80 && x < b
//						.getP1x() + 80)) {
//			y = dy * (-1);
//		}
//		
//		else if ((x == b.getP1x()+100 || x +80 == b.getP1x()) && 
//				(y + 80 > b.getP1y())) {
//			dx = dx * (-1);
//		}
//		
//		if (y + 80 > b.getP2y() && 
//				(x > b.getP2x() - 80 && x < b.getP2x() + 80)) {
//			y = dy * (-1);
//		}
//		
//		else if ((x == b.getP2x()+100 || x +80 == b.getP2x()) && 
//				(y + 80 > b.getP2y())) {
//			dx = dx * (-1);
//		}
//		
//		if (y + 100 == b.getWy()+ 6 &&
//		   (x + 80 > b.getWy() && x < b.getWx() + 20)) {
//			dy = dy * (-1);
//			
//		} else if ((x + 80 > b.getWx() && x < b.getWx() + 20)
//				&& (y + 80 > b.getWy() && y + 80 < b.getWy() + 230)) {
//			dx = dx * (-1);
//		}

		
		
//		System.out.println(dy);
		x += dx;
		y += dy;
		

	}

	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void update(Bound b) {


		getNextPosition(b) ;

		setPosition(x,y);


	}

	public void draw(Graphics2D g) {

		g.drawImage(b,(int)x,(int)y,null);

	}

}


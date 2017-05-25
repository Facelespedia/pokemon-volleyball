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
	private double x,y;

	private static final double SPEED_BALL = 1.2;

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

	}

	private void getNextPosition() {
		
		x += SPEED_BALL;
		y += SPEED_BALL;
		
//		x += SPEED_BALL;
//		y -= SPEED_BALL;
//		
//		x -= SPEED_BALL;
//		y += SPEED_BALL;
//		
//		x -= SPEED_BALL;
//		y -= SPEED_BALL;

	}

	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void update() {


		getNextPosition() ;

		setPosition(x,y);


	}

	public void draw(Graphics2D g) {

		g.drawImage(b,(int)x,(int)y,null);

	}

}


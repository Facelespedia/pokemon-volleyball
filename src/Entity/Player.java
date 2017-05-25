package Entity;



import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
	
	
	protected double x;
	protected double y;
	
	protected int width;
	protected int height;
	

	
	
	protected boolean left;
	protected boolean right;
	protected boolean up;
	protected boolean down;
	protected boolean jumping;
	
	protected double moveSpeed;
	protected double maxSpeed;
	protected double stopSpeed;
	protected double fallSpeed;
	
	protected double jumpStart;
	protected double stopJumpSpeed;

	private static final int IDLE = 0;
	private static final int WALKING = 1;
	private static final int JUMPING = 2;
	
	BufferedImage p ;

	public Player() {

		double moveSpeed = 0.3;
		double maxSpeed = 1.6;
		double stopSpeed = 0.4;
		
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
	
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}

	

	private void getNextPosition() {

		// movement
//		if(left) {
//			x -= moveSpeed;
//			if(x < -maxSpeed) {
//				x = -maxSpeed;
//			}
//		}
//		else if(right) {
//			x += moveSpeed;
//			if(x > maxSpeed) {
//				x = maxSpeed;
//			}
//		}
//		else {
//			if(x > 0) {
//				x -= stopSpeed;
//				if(x < 0) {
//					x = 0;
//				}
//			}
//			else if(x < 0) {
//				x += stopSpeed;
//				if(x > 0) {
//					x = 0;
//				}
//			}
//		}

		
		

	
		
		

	}
	
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void update() {

		
//		getNextPosition() ;
		
		setPosition(x,y);

		
	}

	public void draw(Graphics2D g) {

		

		
		g.drawImage(p,(int)x,(int)y,null);
		
		

}
	

	
//	public void setLeft(boolean b) { left = b; }
//	public void setRight(boolean b) { right = b; }
//	public void setUp(boolean b) { up = b; }
//	public void setDown(boolean b) { down = b; }
//	public void setJumping(boolean b) { jumping = b; }
	
	
}

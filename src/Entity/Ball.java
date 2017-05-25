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

	
	protected double x;
	protected double y;
	
	protected int width;
	protected int height;
	protected boolean left;
	protected boolean right;
	protected boolean up;
	protected boolean down;
	
	protected double moveSpeed;
	protected double maxSpeed;
	protected double stopSpeed;
	protected double fallSpeed;
	
	
	private static final int IDLE = 0;
	private static final int WALKING = 1;
	private static final int JUMPING = 2;
	
	BufferedImage b ;
	
	public Ball() {

		

	

		double moveSpeed = 0.3;
		double maxSpeed = 1.6;
		double stopSpeed = 0.4;
		
		
		

		
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

		// movement
		if(left) {
			x -= moveSpeed;
			if(x < -maxSpeed) {
				x = -maxSpeed;
			}
		}
		else if(right) {
			x += moveSpeed;
			if(x > maxSpeed) {
				x = maxSpeed;
			}
		}
		else {
			if(x > 0) {
				x -= stopSpeed;
				if(x < 0) {
					x = 0;
				}
			}
			else if(x < 0) {
				x += stopSpeed;
				if(x > 0) {
					x = 0;
				}
			}
		}

		
		

	
		
		

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





	//	private int bx = 50, by = 0;
	//	private double dx = 1, dy = 1;
	//
	//	Ball() {
	//		//Ball settings
	//	JLabel ballpic = new JLabel(new ImageIcon("楓葉.gif"));
	//		// ballpic.setOpaque(true);
	//		// setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	//		setBounds(bx, by, 100, 100);
	//		add(ballpic);
	//	}
	//
	//	//run for thread
	//	public void run() {
	//		Timer timer = new Timer(1, new TimerListener());// new a timer to
	//														// control the moving
	//														// button
	//		timer.start();// start
	//	}
	//
	//	//time listener for ball
	//	private class TimerListener implements ActionListener {
	//		@Override
	//		public void actionPerformed(ActionEvent e) {
	//			// if touch the left or right then bounce
	//			if (bx < 0 || bx > 880) {
	//				dx = dx * (-1);
	//			}
	//			
	//			// if touch the top or bottom then bounce
	//			if (by < 0 || by > 440) {
	//				dy = dy * (-1);
	//			}
	//			
	//			// Touch player1 top
	//			if (by + 80 > PlayingPanel.player1.getY() && 
	//					(bx > PlayingPanel.player1.getX() - 80 && bx < PlayingPanel.player1
	//							.getX() + 80)) {
	//				dy = dy * (-1);
	//			}
	//			
	//			// Touch player1 right or left
	//			else if ((bx == PlayingPanel.player1.getX()+100 || bx +80 == PlayingPanel.player1.getX()) && 
	//					(by + 80 > PlayingPanel.player1.getY())) {
	//				dx = dx * (-1);
	//			}
	//			
	//			// Touch player2 top
	//			if (by + 80 > PlayingPanel.player2.getY() && 
	//					(bx > PlayingPanel.player2.getX() - 80 && bx < PlayingPanel.player2.getX() + 80)) {
	//				dy = dy * (-1);
	//			}
	//			
	//			// Touch player2 right or left
	//			else if ((bx == PlayingPanel.player2.getX()+100 || bx +80 == PlayingPanel.player2.getX()) && 
	//					(by + 80 > PlayingPanel.player2.getY())) {
	//				dx = dx * (-1);
	//			}
	//			
	//			//Touch the poll top
	//			if (by + 100 == PlayingPanel.poll.getY() + 6 &&
	//			   (bx + 80 > PlayingPanel.poll.getX() && bx < PlayingPanel.poll.getX() + 20)) {
	//				dy = dy * (-1);
	//				
	//			//Touch the poll left and right
	//			} else if ((bx + 80 > PlayingPanel.poll.getX() && bx < PlayingPanel.poll.getX() + 20)
	//					&& (by + 80 > PlayingPanel.poll.getY() && by + 80 < PlayingPanel.poll
	//							.getY() + 230)) {
	//				dx = dx * (-1);
	//			}
	//			
	//			//new it location
	//			bx = (int) (bx + dx);
	//			by = (int) (by + dy);
	//			//change it location
	//			setLocation(bx, by);
	//		}
	//	}


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
	private boolean restate = false;

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

		if ((y >= b.getWy() - 30 && y <= b.getWy()-28) && (x > b.getWx() - 30 && x < b.getWx() +30) ) {
					dy = dy * (-1);
		}else if ((x > b.getWx() - 30 && x < b.getWx() + 30) && (y > b.getWy())) {
					dx = dx * (-1);
		}

		if (y > b.getP1y() - 10 && (x > b.getP1x() - 20 && x < b.getP1x() + 20)) {
			dy = dy * (-1);
		}else if ((x > b.getP1x() - 10 && x < b.getP1x() + 10) && (y > b.getP1y()-10)) {
			dx = dx * (-1);
		}
		
		if (y > b.getP2y() - 10 && (x > b.getP2x() - 20 && x < b.getP2x() + 20)) {
			dy = dy * (-1);
		}else if ((x > b.getP2x() - 10 && x < b.getP2x() + 10) && (y > b.getP2y()-10)) {
			dx = dx * (-1);
		}

		x += dx;
		y += dy;		

	}

	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void update(Bound b ,Player p1,Player p2 , Ball ball) {

		if(y < b.getHEIGHT() - 30){
			getNextPosition(b) ;
			setPosition(x,y);
			restate = false;
		}else {
			if(x < b.getWIDTH()/2) {
				p1.scoreUpdate();
			}
			else {
				p2.scoreUpdate();
			}
			restate = true;
		}

	}
	
	public double randomXPos() {
		return 5 + (Math.random() * (280 - 5));
	}
	
	public boolean resetState() {
		return restate;
	}

	public void draw(Graphics2D g) {

		g.drawImage(b,(int)x,(int)y,null);

	}

}


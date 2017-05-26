package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Command.CommandBall;
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
  
		if(x+30>=b.getWx()&&x+30<=b.getWx()+10&&y+32>=b.getWy()){
			dx = dx * (-1); 
			if(dx<=0){
				dx=dx-0.5;
			}else{
				dx=dx+0.5;
			}
		}else if(x+30>=b.getWx()&&x+30<=b.getWx()+10&&y+30>=b.getWy()){
			dy = dy * (-1);
			if(dy<=0){
				dy=dy-0.5;
			}else{
				dy=dy+0.5;
			}
		}

		if(dx>=0&&dy>=0&&(x+30>=b.getP1x()&&y+30>=b.getP1y()&&x+30<=b.getP1x()+25)){
			dx = dx * (-1);
			dy = dy * (-1);
			if(dy<=0){
				dy=dy-0.5;
			}else{
				dy=dy+0.5;
			}
			if(dx<=0){
				dx=dx-0.5;
			}else{
				dx=dx+0.5;
			}
		}
		else if(dx<0&&dy>=0&&(x+30>=b.getP1x()&&y+30>=b.getP1y()&&x+30<=b.getP1x()+25)){
			dy = dy * (-1);
			if(dy<=0){
				dy=dy-0.5;
			}else{
				dy=dy+0.5;
			}
		}else if(dx>=0&&dy>=0&&((x+30>=b.getP1x()+25)&&(y+30>=b.getP1y())&&(x+30<=b.getP1x()+50))){
			dy = dy * (-1);
			if(dy<=0){
				dy=dy-0.5;
			}else{
				dy=dy+0.5;
			}
		}else if(dx<0&&dy>=0&&((x+30>=b.getP1x()+25)&&(y+30>=b.getP1y())&&(x+30<=b.getP1x()+50))){
			dx = dx * (-1);
			dy = dy * (-1);
			if(dy<=0){
				dy=dy-0.5;
			}else{
				dy=dy+0.5;
			}

			if(dx<=0){
				dx=dx-0.5;
			}else{
				dx=dx+0.5;
			}
		}


		if(dx>=0&&dy>=0&&(x+30>=b.getP2x()&&y+30>=b.getP2y()&&x+30<=b.getP2x()+25)){
			dx = dx * (-1);
			dy = dy * (-1);
			if(dy<=0){
				dy=dy-0.5;
			}else{
				dy=dy+0.5;
			}
			if(dx<=0){
				dx=dx-0.5;
			}else{
				dx=dx+0.5;
			}
		}
		else if(dx<0&&dy>=0&&(x+30>=b.getP2x()&&y+30>=b.getP2y()&&x+30<=b.getP2x()+25)){
			dy = dy * (-1);
			if(dy<=0){
				dy=dy-0.5;
			}else{
				dy=dy+0.5;
			}
		}else if(dx>=0&&dy>=0&&((x+30>=b.getP2x()+25)&&(y+30>=b.getP2y())&&(x+30<=b.getP2x()+50))){
			dy = dy * (-1);
			if(dy<=0){
				dy=dy-0.5;
			}else{
				dy=dy+0.5;
			}
		}else if(dx<0&&dy>=0&&((x+30>=b.getP2x()+25)&&(y+30>=b.getP2y())&&(x+30<=b.getP2x()+50))){
			dx = dx * (-1);
			dy = dy * (-1);
			if(dy<=0){
				dy=dy-0.5;
			}else{
				dy=dy+0.5;
			}

			if(dx<=0){
				dx=dx-0.5;
			}else{
				dx=dx+0.5;
			}
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
		}else {
			if(x < b.getWIDTH()/2) {
				p1.scoreUpdate();
				p1.setPosition(20, 190);
				p2.setPosition(260, 190);
				ball.setPosition(0, 50);
			}
			else {
				p2.scoreUpdate();
				p1.setPosition(20, 190);
				p2.setPosition(260, 190);
				ball.setPosition(270, 50);
			}
			restate = true;
		}

	}

	public double randomXPos() {
		return 5 + (Math.random() * (280 - 5));
	}

	public void setState(boolean r) {
		this.restate = r;
		dx = SPEED_BALL;
		dy = SPEED_BALL;
	}

	public boolean resetState() {
		return restate;
	}

	public void draw(Graphics2D g) {
		g.drawImage(b,(int)x,(int)y,null);
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}


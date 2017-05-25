package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import com.sun.glass.events.KeyEvent;

import Entity.Ball;
import Entity.Bound;
import Entity.Player;
import Entity.ScoreBoard;
import Entity.Wall;
import Main.GamePanel;
import Map.Background;

public class PlayState extends GameState{
	
	GamePanel gp;
	Background bg;
	Player p1;
	Player p2;
	Ball b;
	Wall w;
	Bound bound;

	public PlayState (GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}

	@Override
	public void init() {
		bg = new Background("/Backgrounds/grassbg1.gif", 0.1);
		p1 = new Player();
		p1.setPosition(260, 190);
		p1.setPosScore(20, 20);
		p2 = new Player();
		p2.setPosition(20, 190);
		p2.setPosScore(280, 20);
		b = new Ball();
		b.setPosition(0, 50);
		w = new Wall();
		w.setPosition(150, 160);
		bound = new Bound(gp.WIDTH,gp.HEIGHT,p1.getX(),p1.getY(),p2.getX(),p2.getY(),w.getX(),w.getY());
	}

	@Override
	public void update() {
		p1.update();
		p2.update();
		bound.update(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		b.update(bound,p1,p2);
		
	}

	@Override
	public void draw(Graphics2D g) {
		bg.draw(g);
		p1.draw(g);
		p2.draw(g);
		b.draw(g);
		w.draw(g);
		
	}

	@Override
	public void keyPressed(int k) {
//		if(k == KeyEvent.VK_LEFT){
//			System.out.println(WIDTH);
//		}
//		if(k == KeyEvent.VK_RIGHT) p1.setRight(true);
//		if(k == KeyEvent.VK_UP) p1.setUp(true);
//		if(k == KeyEvent.VK_DOWN) p1.setDown(true);
//		
//
//		if(k == KeyEvent.VK_W) p2.setLeft(true);
//		if(k == KeyEvent.VK_D) p2.setRight(true);
//		if(k == KeyEvent.VK_A) p2.setUp(true);
//		if(k == KeyEvent.VK_S) p2.setDown(true);
		
	}

	@Override
	public void keyReleased(int k) {
//		if(k == KeyEvent.VK_LEFT){
//			System.out.println(bound.getHEIGHT() + " " + bound.getWIDTH() + " " + bound.getP1x());
//		}
//		if(k == KeyEvent.VK_RIGHT) p1.setRight(false);
//		if(k == KeyEvent.VK_UP) p1.setUp(false);
//		if(k == KeyEvent.VK_DOWN) p1.setDown(false);
//		
//
//		if(k == KeyEvent.VK_W) p2.setLeft(false);
//		if(k == KeyEvent.VK_D) p2.setRight(false);
//		if(k == KeyEvent.VK_A) p2.setUp(false);
//		if(k == KeyEvent.VK_S) p2.setDown(false);

	}

	
	
	
	
	
	
	

	

}

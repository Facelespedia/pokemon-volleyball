package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Entity.Ball;
import Map.Background;

public class PlayState extends GameState{
	
	Background bg;
	Ball ball;

	public PlayState (GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		bg = new Background("/Backgrounds/playbg.gif", 1);
		ball = new Ball();


	}

	@Override
	public void draw(Graphics2D g) {
		bg.draw(g);
		ball.draw(g);
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub

	}

}

package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Map.Background;

public class PlayState extends GameState{
	
	Background bg;

	public PlayState (GameStateManager gsm) {
		this.gsm = gsm;

		try {

			bg = new Background("/Backgrounds/playbg.gif", 1);


		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics2D g) {
		bg.draw(g);

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

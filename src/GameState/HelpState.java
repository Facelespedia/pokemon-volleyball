package GameState;
import Map.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HelpState  extends GameState{
	
	Background bg;
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	public HelpState(GameStateManager gsm){
		this.gsm = gsm;
		init();
	}
	
	public void init() {
		bg = new Background("/Backgrounds/board.jpg", 0.1);
		
		titleColor = new Color(128, 0, 0);
		titleFont = new Font(
				"Century Gothic",
				Font.PLAIN,
				18);
		
		
		
	}
	

	
	public void draw(Graphics2D g) {
		bg.draw(g);
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("BACK", 140, 200);
		
		// draw menu options
		
		
	}
	
	
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			gsm.setState(GameStateManager.MENUSTATE);
			
			
		}
		
	}
	public void keyReleased(int k) {}

	@Override
	public void update() {
				
	}
	
}











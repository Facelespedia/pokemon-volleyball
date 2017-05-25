package Entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class ScoreBoard {
	
	int scoreP1,scoreP2;
	private Color color;
	private Font font;
	
	public ScoreBoard() {
		scoreP1 = 0;
		scoreP2 = 0;
		color = new Color(128, 0, 0);
		font = new Font(
				"Century Gothic",
				Font.PLAIN,
				28);
	}
	
	public void writeScore(Graphics2D g) {
		g.drawString(""+scoreP1, 20, 20);
		g.drawString(""+scoreP2, 280, 20);
	}
	
	public void updateScore() {
	}
	
}

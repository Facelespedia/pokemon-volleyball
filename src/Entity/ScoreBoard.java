package Entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class ScoreBoard {
	
	int score,xPos,yPos;
	private Color color;
	private Font font;
	
	public ScoreBoard() {
		color = new Color(128, 0, 0);
		font = new Font(
				"Century Gothic",
				Font.PLAIN,
				28);
	}
	public void setScoreBoard(int xPos,int yPos) {
		score = 0;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void writeScore(Graphics2D g) {
		g.drawString(""+score, xPos, yPos);
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
}

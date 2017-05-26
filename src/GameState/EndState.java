package GameState;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics2D;

import java.awt.event.KeyEvent;

import javax.imageio.ImageIO;

import Command.CommandLeft;

import java.awt.*;
import java.awt.image.BufferedImage;

import Entity.Ball;
import Entity.Bound;
import Entity.Player;
import Entity.ScoreBoard;
import Entity.Wall;
import Main.GamePanel;
import Map.Background;

public class EndState extends GameState{
	
	Background bg;
	private BufferedImage result ,playerwin , playerlose ,winner,loser;
	protected GameStateManager gsm;
	boolean p1win=false , p2win=false;
	private Color titleColor;
	private Font titleFont;
	
	public EndState(GameStateManager gsm){
		this.gsm = gsm;
		init();
	}
	
	public void init(){
		bg = new Background("/Backgrounds/EndStage.png", 0.1);
		try{
			result = ImageIO.read(getClass().getResourceAsStream("/Text/result1.png"));
			if(p1win){
				playerwin = ImageIO.read(getClass().getResourceAsStream("/EndState/pikachu02.png"));
				playerlose = ImageIO.read(getClass().getResourceAsStream("/EndState/cry_l.png"));
				winner = ImageIO.read(getClass().getResourceAsStream("/EndState/Winner_R.png"));
				loser = ImageIO.read(getClass().getResourceAsStream("/EndState/Loser_L.png"));
			}else if(p2win){
				playerwin = ImageIO.read(getClass().getResourceAsStream("/EndState/pikachu01.png"));
				playerlose = ImageIO.read(getClass().getResourceAsStream("/EndState/cry_r.png"));
				winner = ImageIO.read(getClass().getResourceAsStream("/EndState/Winner_L.png"));
				loser = ImageIO.read(getClass().getResourceAsStream("/EndState/Loser_R.png"));
			}
			titleColor = new Color(0, 0, 0);
			titleFont = new Font(
					"Century Gothic",
					Font.PLAIN,
					10);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(){
		
	}
	public void draw(Graphics2D g){
		bg.draw(g);
		g.drawImage(result, null, 70, 0);
		if(p1win){
			g.drawImage(playerlose, null, 0, 50);			
			g.drawImage(playerwin, null, 160, 50);
			g.drawImage(loser, null, 0, 180);
			g.drawImage(winner, null, 160, 180);
		}else if(p2win){
			g.drawImage(playerwin, null, 0, 50);			
			g.drawImage(playerlose, null, 160, 50);
			g.drawImage(winner, null, 0, 180);
			g.drawImage(loser, null, 160, 180);
		}
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Press backspace go to main menu", 5, 230);
	}
	public void keyPressed(int k){
		
	}
	public void keyReleased(int k){
		if(k == KeyEvent.VK_BACK_SPACE) {
			gsm.setState(GameStateManager.MENUSTATE);
		}
	}
	public void setP1Win (boolean b){
		p1win = b;
	}
	public void setP2Win (boolean b){
		p2win = b;
	}

}

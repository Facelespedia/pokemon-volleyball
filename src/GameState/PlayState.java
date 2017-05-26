package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import Command.Command;
import Command.CommandJump;
import Command.CommandLeft;
import Command.CommandRight;
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
	int scoreP1,scoreP2;
	Command cm;
	private long startTime;
	private long timeInGame;
	private List<Command> commands = new ArrayList<Command>();
	public static final long DELAY = 10;
	public static final int sPosX1 = 20,sPosY1 = 190,sPosX2 = 260,sPosY2 = 190,sPosXb = 0,sPosYb=20,sPosXw=150,sPosYw=160;

	public PlayState (GameStateManager gsm) {
		this.gsm = gsm;
		startTime = System.currentTimeMillis();
		init();
	}

	@Override
	public void init() {
		bg = new Background("/Backgrounds/grassbg1.gif", 0.1);
		p1 = new Player(1);
		p1.setPosition(sPosX1, sPosY1);
		p1.setPosScore(280, 20);
		p2 = new Player(2);
		p2.setPosition(sPosX2, sPosY2);
		p2.setPosScore(20, 20);
		b = new Ball();
		b.setPosition(sPosXb, sPosYb);
		w = new Wall();
		w.setPosition(sPosXw, sPosYw);
		bound = new Bound(gp.WIDTH,gp.HEIGHT,p1.getX(),p1.getY(),p2.getX(),p2.getY(),w.getX(),w.getY());
	}
	
	boolean end =true;
	boolean replay = true;
	@Override
	public void update() {
		
		
		if(p1.getScore() < 5 && p2.getScore() < 5 && end) {
			timeInGame = System.currentTimeMillis() - startTime;
			if(b.resetState()) {
				resetState();
				b.setState(false);
			}else {
				startPlay();
			}
		}else {
			if(replay) {
				init();
				end = false;
				replay = false;
				startTime = System.currentTimeMillis();
			}else {
				//startReplay();
			}
			
		}
	}

	public void resetState() {
		b.setPosition(b.randomXPos(), sPosYb);
		p1.setPosition(sPosX1, sPosY1);
		p2.setPosition(sPosX2, sPosY2);
	}

	public void startPlay() {
		p1.update(bound);
		p2.update(bound);
		bound.update(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		b.update(bound,p1,p2,b);
		scoreP1 = p1.getScore();
		scoreP2 = p2.getScore();
		
		if(scoreP1==5){
			EndState es = (EndState) gsm.getState(GameStateManager.ENDSTATE);
			es.setP1Win(true);
			gsm.setState(GameStateManager.ENDSTATE);
		}else if (scoreP2==5){
			EndState es = (EndState) gsm.getState(GameStateManager.ENDSTATE);
			es.setP2Win(true);
			gsm.setState(GameStateManager.ENDSTATE);
		}
	}

	public void startReplay() {
		timeInGame = System.currentTimeMillis() - startTime;
		if(!commands.isEmpty()) {
			Command c = commands.get(0);
			if( timeInGame >= c.getTimeInGame()) {
				commands.remove(c);
				c.execute(p1);
				c.Noexecute(p1);
				System.out.println(c);
				//					c.execute(p2);
			}
		}
		p1.update(bound);
		p2.update(bound);
		bound.update(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		b.update(bound,p1,p2,b);
		delay();
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
		if(k == KeyEvent.VK_A) {
			cm = new CommandLeft(timeInGame);
			cm.execute(p1);
			commands.add(cm);
		}
		if(k == KeyEvent.VK_D) {
			cm = new CommandRight(timeInGame);
			cm.execute(p1);
			commands.add(cm);
		}
		if(k == KeyEvent.VK_W) {
			cm = new CommandJump(timeInGame);
			cm.execute(p1);
			commands.add(cm);
		}
		if(k == KeyEvent.VK_LEFT) {
			cm = new CommandLeft(timeInGame);
			cm.execute(p2);
			//commands.add(cm);
		}
		if(k == KeyEvent.VK_RIGHT) {
			cm = new CommandRight(timeInGame);
			cm.execute(p2);
			//commands.add(cm);
		}
		if(k == KeyEvent.VK_UP) {
			cm = new CommandJump(timeInGame);
			cm.execute(p2);
			//commands.add(cm);
		}
	}

	@Override
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_A) {
			cm = new CommandLeft(timeInGame);
			cm.Noexecute(p1);
			commands.add(cm);
		}
		if(k == KeyEvent.VK_D) {
			cm = new CommandRight(timeInGame);
			cm.Noexecute(p1);
			commands.add(cm);
		}
		if(k == KeyEvent.VK_W) {
			cm = new CommandJump(timeInGame);
			cm.Noexecute(p1);
			commands.add(cm);
		}
		if(k == KeyEvent.VK_LEFT) p2.setLeft(false);
		if(k == KeyEvent.VK_RIGHT) p2.setRight(false);
		if(k == KeyEvent.VK_UP) p2.setUp(false);
	}

	private void delay() {
		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import Command.Command;
import Command.CommandBall;
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
	Command cm;
	CommandBall cb;
	int scoreP1,scoreP2;
	boolean end;
	boolean replay;
	private long startTime;
	private long timeInGame;
	private List<Command> commandsP1 = new ArrayList<Command>();
	private List<Command> commandsP2 = new ArrayList<Command>();
	private List<CommandBall> commandsBall = new ArrayList<CommandBall>();

	public static final long DELAY = 10;
	public static final int sPosX1 = 20,sPosY1 = 210,sPosX2 = 260,sPosY2 = 210,sPosYb=20,sPosXw=150,sPosYw=160;
	int sPosXb=0;
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
		end = true;
		replay = true;
	}


	@Override
	public void update() {

		if(p1.getScore() < 5 && p2.getScore() < 5 && end) {
			timeInGame = System.currentTimeMillis() - startTime;
			if(b.resetState()) {
				sPosXb = (int)b.randomXPos();
				cb = new CommandBall(timeInGame);
				cb.set(sPosXb, sPosYb);
				commandsBall.add(cb);
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
				startReplay();
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

		}
	}

	public void resetState() {
		b.setPosition(sPosXb, sPosYb);
		p1.setPosition(sPosX1, sPosY1);
		p2.setPosition(sPosX2, sPosY2);
	}

	public void startPlay() {
		p1.update(bound);
		p2.update(bound);
		bound.update(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		b.update(bound,p1,p2,b);
	}
	int count =0;
	public void startReplay() {
		timeInGame = System.currentTimeMillis() - startTime;
		if(!commandsP1.isEmpty()) {
			Command c = commandsP1.get(0);
			if( timeInGame >= c.getTimeInGame()) {
				commandsP1.remove(c);
				if(count%2==0){
					c.execute(p1,true);
				}else{
					c.execute(p1,false);
				}

			}
			p1.update(bound);
		}
		if(!commandsP2.isEmpty()) {
			Command c = commandsP2.get(0);
			if( timeInGame >= c.getTimeInGame()) {
				commandsP2.remove(c);
				if(count%2==0){
					c.execute(p2,true);
				}else{
					c.execute(p2,false);
				}
			}
			p2.update(bound);
		}
		if(!commandsBall.isEmpty()) {
			CommandBall c = commandsBall.get(0);
			if( timeInGame >= c.getTimeInGame()) {
				commandsBall.remove(c);
				c.execute(b);
			}
		}
		count++;

		bound.update(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		b.update(bound,p1,p2,b);
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
		if(replay){
			if(k == KeyEvent.VK_A) {
				cm = new CommandLeft(timeInGame);
				cm.execute(p1,true);
				commandsP1.add(cm);
			}
			if(k == KeyEvent.VK_D) {
				cm = new CommandRight(timeInGame);
				cm.execute(p1,true);
				commandsP1.add(cm);
			}
			if(k == KeyEvent.VK_W) {
				cm = new CommandJump(timeInGame);
				cm.execute(p1,true);
				commandsP1.add(cm);
			}
			if(k == KeyEvent.VK_LEFT) {
				cm = new CommandLeft(timeInGame);
				cm.execute(p2,true);
				commandsP2.add(cm);
			}
			if(k == KeyEvent.VK_RIGHT) {
				cm = new CommandRight(timeInGame);
				cm.execute(p2,true);
				commandsP2.add(cm);
			}
			if(k == KeyEvent.VK_UP) {
				cm = new CommandJump(timeInGame);
				cm.execute(p2,true);
				commandsP2.add(cm);
			}
		}
	}

	@Override
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_A) {
			cm = new CommandLeft(timeInGame);
			cm.execute(p1,false);
			commandsP1.add(cm);
		}
		if(k == KeyEvent.VK_D) {
			cm = new CommandRight(timeInGame);
			cm.execute(p1,false);
			commandsP1.add(cm);
		}
		if(k == KeyEvent.VK_W) {
			cm = new CommandJump(timeInGame);
			cm.execute(p1,false);
			commandsP1.add(cm);
		}
		if(k == KeyEvent.VK_LEFT) {
			cm = new CommandLeft(timeInGame);
			cm.execute(p2,false);
			commandsP2.add(cm);
		}
		if(k == KeyEvent.VK_RIGHT) {
			cm = new CommandRight(timeInGame);
			cm.execute(p2,false);
			commandsP2.add(cm);
		}
		if(k == KeyEvent.VK_UP) {
			cm = new CommandJump(timeInGame);
			cm.execute(p2,false);
			commandsP2.add(cm);
		}
	}

	private void delay() {
		try {
			Thread.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

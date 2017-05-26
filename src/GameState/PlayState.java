package GameState;


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
	private int scoreP1,scoreP2, count = 0 ;
	boolean end;
	boolean replay;
	private long timeInGame;
	private List<Command> commandsP1 = new ArrayList<Command>();
	private List<Command> commandsP2 = new ArrayList<Command>();
	private List<CommandBall> commandsBall = new ArrayList<CommandBall>();

	public static final long DELAY = 10;
	public static final int sPosX1 = 20,sPosY1 = 210,sPosX2 = 260,sPosY2 = 210,sPosXb=0,sPosX2b=280,sPosYb=20,sPosXw=150
			,sPosYw=160,sPosSX1=280,sPosSY1=20,sPosSX2=20,sPosSY2=20;

	public PlayState (GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}

	@Override
	public void init() {
		bg = new Background("/Backgrounds/grassbg1.gif", 0.1);
		p1 = new Player(1);
		p1.setPosition(sPosX1, sPosY1);
		p1.setPosScore(sPosSX1, sPosSY1);
		p2 = new Player(2);
		p2.setPosition(sPosX2, sPosY2);
		p2.setPosScore(sPosSX2, sPosSY2);
		b = new Ball();
		b.setPosition(sPosXb, sPosYb);
		w = new Wall();
		w.setPosition(sPosXw, sPosYw);
		bound = new Bound(gp.WIDTH,gp.HEIGHT,p1.getX(),p1.getY(),p2.getX(),p2.getY(),w.getX(),w.getY());
		end = true;
		replay = true;
		timeInGame = 0;
	}


	@Override
	public void update() {

		if(p1.getScore() < 2 && p2.getScore() < 2 && end) {	
			if(b.resetState()) {
				if(count%2 == 0){
					cb = new CommandBall(timeInGame,sPosXb,sPosYb);
					commandsBall.add(cb);
					b.setPosition(sPosXb, sPosYb);
				}else{
					cb = new CommandBall(timeInGame,sPosX2b,sPosYb);
					commandsBall.add(cb);
					b.setPosition(sPosX2b, sPosYb);
				}
				count++;
				resetState();
				b.setState(false);
			}else {
				startPlay();
			}
			timeInGame++;
		}else {
			if(replay) {
				init();
				timeInGame = 0;
				end = false;
				replay = false;
			}else {
				startReplay();
				scoreP1 = p1.getScore();
				scoreP2 = p2.getScore();
				if(scoreP1==3){
					EndState es = (EndState) gsm.getState(GameStateManager.ENDSTATE);
					es.setP1Win(true);
					gsm.setState(GameStateManager.ENDSTATE);
				}else if (scoreP2==3){
					EndState es = (EndState) gsm.getState(GameStateManager.ENDSTATE);
					es.setP2Win(true);
					gsm.setState(GameStateManager.ENDSTATE);
				}
			}

		}
	}

	public void resetState() {
		p1.setPosition(sPosX1, sPosY1);
		p2.setPosition(sPosX2, sPosY2);
	}

	public void startPlay() {
		p1.update(bound);
		p2.update(bound);
		bound.update(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		b.update(bound,p1,p2,b);
	}

	public void startReplay() {


		if(!commandsP1.isEmpty()) {
			Command c = commandsP1.get(0);
			if( timeInGame == c.getTimeInGame()) {
				commandsP1.remove(0);
				c.execute(p1);
			}
		}
		if(!commandsP2.isEmpty()) {
			Command c = commandsP2.get(0);
			if( timeInGame == c.getTimeInGame()) {
				commandsP2.remove(0);
				c.execute(p2);
			}

		}
		if(!commandsBall.isEmpty()) {
			CommandBall c = commandsBall.get(0);
			if( timeInGame == c.getTimeInGame()) {
				commandsBall.remove(0);
				c.execute(b);
			}
		}

		if(b.resetState()) {
			resetState();
			b.setState(false);
		}else {
			startPlay();
		}
		timeInGame++;

	}

	@Override
	public void draw(Graphics2D g) {
		bg.draw(g);
		p1.draw(g);
		p2.draw(g);
		b.draw(g);
		w.draw(g);
		if(!replay){
			g.drawString("Replay", 140, 110);
		}
	}

	@Override
	public void keyPressed(int k) {
		if(replay){
			if(k == KeyEvent.VK_A) {
				cm = new CommandLeft(timeInGame,true);
				cm.execute(p1);
				commandsP1.add(cm);
			}
			if(k == KeyEvent.VK_D) {
				cm = new CommandRight(timeInGame,true);
				cm.execute(p1);
				commandsP1.add(cm);
			}
			if(k == KeyEvent.VK_W) {
				cm = new CommandJump(timeInGame,true);
				cm.execute(p1);
				commandsP1.add(cm);
			}
			if(k == KeyEvent.VK_LEFT) {
				cm = new CommandLeft(timeInGame,true);
				cm.execute(p2);
				commandsP2.add(cm);
			}
			if(k == KeyEvent.VK_RIGHT) {
				cm = new CommandRight(timeInGame,true);
				cm.execute(p2);
				commandsP2.add(cm);
			}
			if(k == KeyEvent.VK_UP) {
				cm = new CommandJump(timeInGame,true);
				cm.execute(p2);
				commandsP2.add(cm);
			}
		}
	}

	@Override
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_A) {
			cm = new CommandLeft(timeInGame,false);
			cm.execute(p1);
			commandsP1.add(cm);
		}
		if(k == KeyEvent.VK_D) {
			cm = new CommandRight(timeInGame,false);
			cm.execute(p1);
			commandsP1.add(cm);
		}
		if(k == KeyEvent.VK_W) {
			cm = new CommandJump(timeInGame,false);
			cm.execute(p1);
			commandsP1.add(cm);
		}
		if(k == KeyEvent.VK_LEFT) {
			cm = new CommandLeft(timeInGame,false);
			cm.execute(p2);
			commandsP2.add(cm);
		}
		if(k == KeyEvent.VK_RIGHT) {
			cm = new CommandRight(timeInGame,false);
			cm.execute(p2);
			commandsP2.add(cm);
		}
		if(k == KeyEvent.VK_UP) {
			cm = new CommandJump(timeInGame,false);
			cm.execute(p2);
			commandsP2.add(cm);
		}
	}


}

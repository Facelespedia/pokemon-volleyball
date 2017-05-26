package Command;

import Entity.Ball;

public class CommandBall {

	private long timeInGame;
	private int x,y;

	public CommandBall(long timeInGame) {
		this.timeInGame = timeInGame;
	}

	public long getTimeInGame() {
		return timeInGame;
	}
	public void execute(Ball b) {
		b.setPosition(x, y);
	}
	
	public void set(int x ,int y) {
		this.x = x;
		this.y = y;
	}
	


}

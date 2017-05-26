package Command;

import Entity.Ball;

public class CommandBall {

	private long timeInGame;
	private int x,y;

	public CommandBall(long timeInGame,int x,int y) {
		this.timeInGame = timeInGame;
		this.x = x;
		this.y = y;
	}

	public long getTimeInGame() {
		return timeInGame;
	}
	public void execute(Ball b) {
		b.setPosition(this.x, this.y);
	}
	public int getX() {
		return x;
	}


}

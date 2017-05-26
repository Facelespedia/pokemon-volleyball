package Command;

import Entity.Player;

public abstract class CommandBall {

	private long timeInGame;

	public CommandBall(long timeInGame) {
		this.timeInGame = timeInGame;
	}

	public long getTimeInGame() {
		return timeInGame;
	}
	public abstract void execute(Player p,boolean status);
//	public abstract void Noexecute(Player p);

}

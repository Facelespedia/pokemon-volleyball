package Command;

import Entity.Player;

public abstract class Command {

	private long timeInGame;
	private boolean status;

	public Command(long timeInGame,boolean status) {
		this.timeInGame = timeInGame;
		this.status = status;
	}

	public long getTimeInGame() {
		return timeInGame;
	}
	public abstract void execute(Player p);
	public boolean getStatus() {
		return status;
	}


}

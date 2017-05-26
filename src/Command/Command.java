package Command;

import Entity.Player;

public abstract class Command {

	private long timeInGame;

	public Command(long timeInGame) {
		this.timeInGame = timeInGame;
	}

	public long getTimeInGame() {
		return timeInGame;
	}
	public abstract void execute(Player p,boolean status);
//	public abstract void Noexecute(Player p);

}

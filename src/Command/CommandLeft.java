package Command;

import Entity.Player;

public class CommandLeft extends Command{
	
	private boolean status;
	public CommandLeft(long timeInGame,boolean status) {
		super(timeInGame,status);
	}

	@Override
	public void execute(Player p) {
		p.setLeft(super.getStatus());
	}

}

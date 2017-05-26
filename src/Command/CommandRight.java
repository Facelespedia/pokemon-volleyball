package Command;

import Entity.Player;

public class CommandRight extends Command{

	public CommandRight(long timeInGame,boolean status) {
		super(timeInGame,status);
	}

	@Override
	public void execute(Player p) {
		p.setRight(super.getStatus());
	}

}

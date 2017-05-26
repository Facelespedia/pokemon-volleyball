package Command;

import Entity.Player;

public class CommandJump extends Command{
	
	public CommandJump(long timeInGame,boolean status) {
		super(timeInGame,status);
	}

	@Override
	public void execute(Player p) {
		p.setUp(super.getStatus());
	}
	
}

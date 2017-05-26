package Command;

import Entity.Player;

public class CommandJump extends Command{

	public CommandJump(long timeInGame) {
		super(timeInGame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Player p) {
		// TODO Auto-generated method stub
		p.setUp(true);
	}

}

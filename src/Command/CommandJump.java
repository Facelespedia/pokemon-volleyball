package Command;

import Entity.Player;

public class CommandJump extends Command{
	

	public CommandJump(long timeInGame,boolean status) {
		super(timeInGame,status);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Player p) {
		// TODO Auto-generated method stub
		p.setUp(super.getStatus());
	}



}

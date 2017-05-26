package Command;

import Entity.Player;

public class CommandRight extends Command{

	public CommandRight(long timeInGame,boolean status) {
		super(timeInGame,status);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Player p) {
		// TODO Auto-generated method stub
		p.setRight(super.getStatus());
	}

}

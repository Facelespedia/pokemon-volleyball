package Command;

import Entity.Player;

public class CommandRight extends Command{

	public CommandRight(long timeInGame) {
		super(timeInGame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Player p,boolean status) {
		// TODO Auto-generated method stub
		p.setRight(status);
	}

//	@Override
//	public void Noexecute(Player p) {
//		// TODO Auto-generated method stub
//		p.setRight(false);
//	}

}

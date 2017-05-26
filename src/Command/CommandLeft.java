package Command;

import Entity.Player;

public class CommandLeft extends Command{

	public CommandLeft(long timeInGame) {
		super(timeInGame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Player p,boolean status) {
		// TODO Auto-generated method stub
		p.setLeft(status);
		
	}

//	@Override
//	public void Noexecute(Player p) {
//		// TODO Auto-generated method stub
//		p.setLeft(false);
//	}

}

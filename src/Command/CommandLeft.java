package Command;

import Entity.Player;

public class CommandLeft extends Command{
	
	private boolean status;
	public CommandLeft(long timeInGame,boolean status) {
		super(timeInGame,status);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Player p) {
		// TODO Auto-generated method stub
		p.setLeft(super.getStatus());
		
	}

}

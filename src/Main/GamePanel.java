package Main;

import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	public static final int WIDTH = 320 ;
	public static final int HEIGHT = 240;
	public static final int SCALE = 2;
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		setFocusable(true);
		requestFocus();
	}
}

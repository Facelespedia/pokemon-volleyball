package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.CharBuffer;

import javax.swing.JPanel;

import GameState.GameStateManager;

public class GamePanel extends JPanel implements Runnable , KeyListener{
	public static final int WIDTH = 320;
	public static final int HEIGHT = 240;
	public static final int SCALE = 2;

	private Thread thread;
	private boolean running;
	private int FPS  = 60 ;
	private long targetTime = 1000 / FPS ;

	private BufferedImage image;
	private Graphics2D g;
	
	private GameStateManager gsm;


	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		setFocusable(true);
		requestFocus();
	}

	private void init() {

		image = new BufferedImage(
				WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB
				);
		g = (Graphics2D) image.getGraphics();

		running = true;

		gsm = new GameStateManager();

	}

	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread =new Thread(this);
			addKeyListener(this);
			thread.start();
		}

	}


	@Override
	public void run() {
		init();

		long start;
		long elapsed;
		long wait;

		// game loop
		while(running) {

			start = System.nanoTime();

			update();
			draw();
			drawToScreen();

			elapsed = System.nanoTime() - start;

			wait = targetTime - elapsed / 1000000;
			if(wait < 0) wait = 5;

			try {
				Thread.sleep(wait);
			}
			catch(Exception e) {
				e.printStackTrace();
			}

		}

	}

	private void update() {
		gsm.update();
	}
	private void draw() {
		gsm.draw(g);
	}
	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0,
				WIDTH * SCALE, HEIGHT * SCALE,
				null);
		g2.dispose();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		gsm.keyPressed(e.getKeyCode());	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		gsm.keyReleased(e.getKeyCode());
	}
}

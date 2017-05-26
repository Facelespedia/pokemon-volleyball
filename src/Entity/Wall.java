package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Wall {

	private double x,y;
	BufferedImage w ;
	
	public Wall() {
		try {

			w = ImageIO.read(
					getClass().getResourceAsStream(
							"/Wall/wall.png"
							)
					);

		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void update() {
		setPosition(x,y);
	}


	public void draw(Graphics2D g) {
		g.drawImage(w,(int)x,(int)y,null);
	}

}

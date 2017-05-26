package Entity;

public class Bound {
	
	private int WIDTH,HEIGHT;
	private double p1x,p1y,p2x,p2y;
	private double wX,wY;
	
	public Bound(int w , int h , double p1x , double p1y , double p2x , double p2y , double wX , double wY) {
		this.WIDTH = w ;
		this.HEIGHT = h;
		this.p1x = p1x;
		this.p1y = p1y;
		this.p2x = p2x;
		this.p2y = p2y;
		this.wX = wX;
		this.wY = wY;
	}
	
	public void update(double p1x,double p1y , double p2x,double p2y) {
		this.p1x = p1x;
		this.p1y = p1y;
		this.p2x = p2x;
		this.p2y = p2y;
	}
	
	public int getWIDTH() {
		return WIDTH;
	}
	
	public int getHEIGHT() {
		return HEIGHT;
	}
	public double getP1x() {
		return p1x;
	}
	public double getP1y() {
		return p1y;
	}
	public double getP2x() {
		return p2x;
	}
	public double getP2y() {
		return p2y;
	}
	public double getWx() {
		return wX;
	}
	public double getWy() {
		return wY;		
	}
}

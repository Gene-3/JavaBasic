package programing03;

public class MovablePoint extends Point {
	private int xSpeed, ySpeed;
	
	public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
		super(x, y);
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	
	public int getxSpeed () {
		return xSpeed;
	}
	
	public int getySpeed () {
		return ySpeed;
	}
	
	public String toString() {
		return "MovablePoint[" + "x=" + getx() + ", y" + gety() + ",xSpeed=" + getxSpeed() + ", ySpeed=" + getySpeed() + "]";
		
	}
}
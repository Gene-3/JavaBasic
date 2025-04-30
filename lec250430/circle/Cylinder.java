package lec250430.circle;

public class Cylinder extends CircleType {

	private double height;
	
	public Cylinder(double radius, double height) {
		this.height = height;
		this.radius = radius;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public double getArea() {
		return 2 * PI * radius * (radius + height);
	}
}

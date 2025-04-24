package programing01;

public class Circle {
	int radius;
	
	public Circle(int radius) {
		this.radius = radius;
	}

	void show() {
		System.out.println("반지름이 " + radius + "인 원이이다.");
	}
}
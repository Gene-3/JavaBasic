package programing01;

public class TestCircle {
	public static void main(String[] args) {
		Circle c1 = new Circle(5);
		ColoredCircle c2 = new ColoredCircle(10, "빨간");
		
		c1.show();
		c2.show();
	}
}
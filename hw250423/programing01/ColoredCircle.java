package programing01;

public class ColoredCircle extends Circle{
	String color;
	
	public ColoredCircle(int radius, String color) {
		super(radius);
		this.color  = color;
	}
	
	@Override
	void show() {
		System.out.println("반지름이 " + radius + "인" +  color + "색 원이다.");
	}

}
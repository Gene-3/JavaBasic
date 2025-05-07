package hw250507.Programing02;

class Shape {}


class Rectangle extends Shape{}


class Circle extends Shape {}


public class CastExceptionTest {
	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		try {
		casting(r);
		} catch (ClassCastException e){
			
		}
	}
	
	
	static void casting(Shape s) {
		Circle c = (Circle) s;
	}
}

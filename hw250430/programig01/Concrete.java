package programig01;

public class Concrete extends Adstract {
	int j;
	
	public Concrete(int i, int j) {
		super(i);
		this.j = j;
	}
	
	@Override
		void show() {
			System.out.println("i: " + i + ", j: " + j);
		}

}
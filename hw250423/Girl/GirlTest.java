package Girl;

public class GirlTest {
	public static void main(String[] args) {

		Girl g1 = new Girl("갑순이");
		Girl g2 = new GoodGirl("콩쥐"); //자식을 부모 객체에 대입
		GoodGirl gg = new BestGirl("황진이"); //자식을 부모 객체에 대압

		g1.show();
		
		g2.show();

		gg.show(); //동적바인딩으로 무지하게 잘 안다 출력

		Girl[] girls = {new Girl("갑순이"), new GoodGirl("콩쥐"), new BestGirl("황진이")};
		
	}

}
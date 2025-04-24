package programing05;

public class PhoneTest {
	public static void main(String[] args) {
        Phone[] phones = {
            new Phone("황진이"),
            new Telephone("길동이", "메일"),
            new SmartPhone("민국이", "갤럭그")
        };

        for (Phone p : phones) {
            if (p instanceof SmartPhone)
                ((SmartPhone) p).playGame();
            else if (p instanceof Telephone)
                ((Telephone) p).autoAnswering();
            else if (p instanceof Phone)
                p.talk();
        }
    }

}
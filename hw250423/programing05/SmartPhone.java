package programing05;

public class SmartPhone extends Telephone {
	private String game;

    public SmartPhone(String owner, String game) {
        super(owner, game);
        this.game = game;
    }

    void playGame() {
        System.out.println(owner + "가 " + game + " 게임을 하는 중이다.");
    }
}
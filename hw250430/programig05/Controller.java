package programig05;

public abstract class Controller {
	boolean power;

    public Controller(boolean power) {
        this.power = power;
    }

    // 추상 메서드: 하위 클래스에서 반드시 구현해야 함
    abstract void show();
}
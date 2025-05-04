package programig05;

public class Radio extends Controller {
    public Radio(boolean power) {
        super(power);
    }

    @Override
    void show() {
        if (power) {
            System.out.println("라디오가 켜졌습니다.");
        } else {
            System.out.println("라디오가 꺼졌습니다.");
        }
    }
}
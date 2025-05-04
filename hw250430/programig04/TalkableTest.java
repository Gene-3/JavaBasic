package programig04;

public class TalkableTest {
	static void speak(Talkable t) {
		t.talka();
	}

	public static void main(String[] args) {
		speak(new Korean());
		speak(new American());
	}
}
package programing06;

public class Vehicle {
	static String color;
    static int speed;

    public Vehicle(String color, int speed) {
        this.color = color;
        this.speed = speed;
    }

    static void show() {
        System.out.println("Vehicle{" + "color='" + color + '\'' + ", speed=" + speed + '}');
    }

}
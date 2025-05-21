package ehwjsrhkwp;

import java.util.ArrayList;
import java.util.List;

public class Challenge01 {
    public static void main(String[] args) {

        List<String> capitals = new ArrayList<String>();
        capitals.add("서울");
        capitals.add("워싱턴");
        capitals.add("베이징");
        capitals.add("파리");
        capitals.add("마드리드");

        for (String capital : capitals) {
            System.out.print(capital + " ");
        }
        System.out.println();

        capitals.add("런던");

        for (String capital : capitals) {
            System.out.print(capital + " ");
        }

        System.out.println();

        capitals.removeIf(city -> city.codePointCount(0, city.length()) > 2);

        for (String capital : capitals) {
            System.out.print(capital + " ");
        }
        System.out.println();
    }
}

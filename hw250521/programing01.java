package vmfhrmfoaldanswp;

import java.util.ArrayList;
import java.util.List;

public class programing01 {
	public static void main(String[] args) {
		
		List<String> capitals = new ArrayList<String>();
		capitals.add("갈매기");
		capitals.add("나비");
		capitals.add("다람쥐");
		capitals.add("라마");
		
		capitals.removeIf(city -> city.codePointCount(0, city.length()) > 2);

        for (String capital : capitals) {
            System.out.print(capital + " ");
        }
        System.out.println();
	}

}

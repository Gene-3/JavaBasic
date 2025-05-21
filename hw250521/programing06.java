package vmfhrmfoaldanswp;

import java.util.HashMap;
import java.util.Map;

public class programing06 {
	public static void main(String[] args) {
		
		 // 초기 해시맵 생성
        Map<String, String> animals = new HashMap<>();
        animals.put("호랑이", "tiger");
        animals.put("표범", "leopard");
        animals.put("사자", "lion");

        // 변경 전 출력
        System.out.println("변경전 : " + animals);

        // 모든 값을 대문자로 변경
        animals.replaceAll((k, v) -> v.toUpperCase());

        // 변경 후 출력
        System.out.println("변경후 : " + animals);
    }
}

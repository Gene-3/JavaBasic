package ehwjsrhkwp;

import java.util.*;

public class Challenge03 {
    public static void main(String[] args) {
        // Map 객체 생성 및 단어 등록
        Map<String, String> dic = new LinkedHashMap<>();
        dic.put("head", "다가빠리");
        dic.put("teacher", "쌤");
        dic.put("cat", "꼬이네");
        dic.put("aunt", "아지메");
        dic.put("nooble", "국사");
        dic.put("child", "얼라");

        // 1. Map 전체 출력 (람다식)
        dic.forEach((key, value) -> System.out.print(key + "=" + value + " "));
        System.out.println();  // 줄바꿈


        // 2. Collection 타입으로부터 값 추출
        Collection<String> collection1 = dic.values();

        
        // 3. Collection -> List로 변환
        List<String> list = new ArrayList<>(collection1);

        
        // 4. 리스트 섞기
        Collections.shuffle(list);

        
        // 5. 출력 (람다식 사용)
        list.forEach(x -> System.out.print(x + " "));
    }
}

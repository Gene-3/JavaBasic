package ehwjsrhkwp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Challenge02 {
    public static void main(String[] args) {
        // 1. 사전 객체 생성 및 단어 등록
        Map<String, String> dic = new HashMap<>();
        dic.put("head", "다가빠리");
        dic.put("teacher", "쌤");
        dic.put("cat", "꼬이네");
        dic.put("aunt", "아지메");
        dic.put("nooble", "국사");
        dic.put("child", "얼라");

        // 2. 키 반복자(iterator)를 사용하여 키-값 출력
        Set<String> keys = dic.keySet();                 // key만 뽑음
        Iterator<String> iter = keys.iterator();         // iterator 생성

        while (iter.hasNext()) {
            String key = iter.next();                    // 키 하나 꺼내고
            String value = dic.get(key);                 // 값 가져오기
            System.out.print(key + "=" + value + " ");   // 출력
        }
    }
}

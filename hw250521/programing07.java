package vmfhrmfoaldanswp;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class programing07 {
	public static void main(String[] args) {
		 
		String[] s1 = { "a", "b", "a", "b", "c" };
		String[] s2 = { "c" };

		
		 // 두 배열을 이용해 HashSet 객체 생성
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Collections.addAll(set1, s1);
        Collections.addAll(set2, s2);

        // 1. 두 HashSet 출력
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);

        // 2. 두 HashSet이 동일한지 비교
        System.out.println("set1과 set2가 동일한가? " + set1.equals(set2));

        // 3. set1이 set2의 모든 원소를 포함하는지
        System.out.println("set1이 set2의 모든 원소를 포함하는가? " + set1.containsAll(set2));

        // 4. 합집합 구하기
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("합집합: " + union);

        // 5. 교집합 구하기
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("교집합: " + intersection);
    }
}

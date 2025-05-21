package vmfhrmfoaldanswp;

import java.util.ArrayList;
import java.util.Scanner;

public class programing05 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();

        // 점수 입력 받기
        while (true) {
            System.out.print("점수를 입력하세요 : ");
            int score = sc.nextInt();
            if (score < 0) break;
            scores.add(score);
        }

        int studentCount = scores.size();
        System.out.println("전체 학생은 " + studentCount + "명이다.");

        // 점수 출력
        System.out.print("학생들의 성적 : ");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();

        // 최고 점수 구하기
        int max = scores.get(0);
        for (int score : scores) {
            if (score > max) max = score;
        }

        // 각 학생의 등급 출력
        for (int i = 0; i < scores.size(); i++) {
            int score = scores.get(i);
            char grade;

            if (score >= max - 10) {
                grade = 'A';
            } else if (score >= max - 20) {
                grade = 'B';
            } else if (score >= max - 30) {
                grade = 'C';
            } else if (score >= max - 40) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            System.out.println(i + "번 학생의 성적은 " + score + "점이며 등급은 " + grade + "이다.");
        }

        sc.close();
    }
}

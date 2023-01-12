package Inflearn.section02_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02_08 {
// N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
// 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
// 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
    
    public List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
    
        // 내 풀이
        for (int i = 0; i < n; i++) {
            int cnt = 1; // 내 등수. (처음엔 1등)
            for (int j = 0; j < n; j++) {
                if (arr[i] < arr[j]) { // 나보다 큰 수 있을때 등수 하나씩 증가
                    cnt++;
                }
            }
            answer.add(cnt);
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P02_08 T = new P02_08();
    
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}

package Inflearn.section02_Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P02_09 {
// 5*5 격자판에 아래와 같이 숫자가 적혀있습니다.
// N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
    
    // 내 풀이 (틀림)
    public int solution(int n, int[][] arr) {
        int answer = 0; // 최대값
        
        List<Integer> sum = new ArrayList<>(); // 각 줄의 합 저장할 리스트
        // -- 방향
        for (int i = 0; i < n; i++) {
            int tmp = 0; // 각 줄의 합
            for (int j = 0; j < n; j++) {
                tmp += arr[i][j];
            }
            sum.add(tmp);
        }
        // | 방향
        for (int j = 0; j < n; j++) {
            int tmp = 0; // 각 줄의 합
            for (int i = 0; i < n; i++) {
                tmp += arr[i][j];
            }
            sum.add(tmp);
        }
        // 대각선 방향 (2개)
        // 00 11 22 33 44 / 04 13 22 31 40
        for (int i = 0; i < n; i++) {
            int tmp = 0; // 각 줄의 합
            for (int j = 0; j < n; j++) {
                if(i == j) {
                    tmp += arr[i][j];
                } else if (i + j == 4) { // 4로 고정하면 안됨. 다양한 입력케이스가 들어옴 -> 여기서 틀린것같음
                    tmp += arr[i][j];
                }
            }
            sum.add(tmp);
        }
        // Collections.max(컬렉션타입) : 최대값 구하기
        // Collections.min(컬렉션타입) : 최소값 구하기
        answer = Collections.max(sum);
        
        return answer;
    }    
    
    // 강의 풀이
    public int solution2(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE; // 최대값 세팅할 곳
        
        // -- 방향 , | 방향
        int sum1; // -- 방향
        int sum2; //  | 방향
        for (int i = 0; i < n; i++) {
            sum1 = 0; // 새로운 줄 합 구해야 하니까 매번 0으로 초기화
            sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i]; // i는 고정, j는 움직이니까
            }
            answer = Math.max(answer, sum1); // Math.max(a, b) : 둘 중 최대값 구하기
            answer = Math.max(answer, sum2);
        }
        // 대각선 방향 (2개)
        // 00 11 22 33 44 / 04 13 22 31 40
        sum1 = 0;
        sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i]; // 첫번째 대각선
            sum2 += arr[i][n - i - 1]; // 두번째 대각선
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);
        
        return answer;
    }
    
    public static void main(String[] args) {
        P02_09 T = new P02_09();
    
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution2(n, arr));
    }
}
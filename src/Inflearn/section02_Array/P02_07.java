package Inflearn.section02_Array;

import java.util.Scanner;

public class P02_07 {
// OX 문제는 맞거나 틀린 두 경우의 답을 가지는 문제를 말한다.
// 여러 개의 OX 문제로 만들어진 시험에서 연속적으로 답을 맞히는 경우에는 가산점을 주기 위해서 다음과 같이 점수 계산을 하기로 하였다.
// 1번 문제가 맞는 경우에는 1점으로 계산한다. 앞의 문제에 대해서는 답을 틀리다가 답이 맞는 처음 문제는 1점으로 계산한다.
// 또한, 연속으로 문제의 답이 맞는 경우에서 두 번째 문제는 2점, 세 번째 문제는 3점, ..., K번째 문제는 K점으로 계산한다. 틀린 문제는 0점으로 계산한다.
// 시험문제의 채점 결과가 주어졌을 때, 총 점수를 계산하는 프로그램을 작성하시오.
// 채점 : 1 0 1 1 1 0 0 1 1 0
// 점수 : 1 0 1 2 3 0 0 1 2 0
    
    public int solution(int n, int[] arr) {
        
        // 내 풀이
//        int sum = 0; // 점수의 합
//
//        int[] sc = new int[n]; // 점수 -> 0으로 초기화상태
//        if (arr[0] == 1) {
//            sc[0] = 1;
//        }
//        for (int i = 1; i < n; i++) {
//            if (arr[i] == 1) {
//                sc[i] = sc[i - 1] + 1;
//            }
//        }
//        for (int x : sc) {
//            sum += x; // 점수의 합
//        }
//        return sum;
        
        // 강의 풀이
        int sum = 0; // 점수의 합
        int cnt = 0; // 연속된 1의 개수(누적)
    
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
                sum += cnt;
            } else {
                cnt = 0;
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        P02_07 T = new P02_07();
    
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}

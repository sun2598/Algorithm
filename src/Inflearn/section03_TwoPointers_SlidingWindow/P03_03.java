package Inflearn.section03_TwoPointers_SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P03_03 {
// 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
// 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
// 12 15 (11 20 25) 10 20 19 13 15
// 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
    
    // <내 풀이> -> 시간초과... 2중 for문은 오래걸림!!
    public int solution(int n, int k, int[] arr) {
        int answer = 0;
    
        ArrayList<Integer> sum = new ArrayList<>();
        for (int i = 0; i < n - (k - 1); i++) { // n=10, k=3일때 0<i<8 이니까. 8은 n-(k-1)
            int tmp = 0; // k개 합 더할 임시공간
            for (int j = 0; j < k; j++) {
                tmp += arr[i + j];
            }
            sum.add(tmp);
        }
        answer = Collections.max(sum);
        
        return answer;
    }
    
    // <강의 풀이> - sliding window
    // 창을 만들어서 쭉 옆으로 민다고 생각하면됨!
    // (12 15 11) 20 25 10 20 19 13 15   -> 합을 sum에 저장
    // 12 (15 11 20) 25 10 20 19 13 15
    // i-k            i                  -> sum에서 arr[i]를 더하고 arr[i-k]를 뺌
    public int solution2(int n, int k, int[] arr) {
        int answer = 0; // sum의 최대값
        
        // 우선 맨 처음 k개 합 구하기
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        answer = sum;
        // 쭉 옆으로 밀기
        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            answer = Math.max(answer, sum); // 더 큰 값 구하기
        }
        
        return answer;
    }
    
    
    public static void main(String[] args) {
        P03_03 T = new P03_03();
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(T.solution2(n, k, arr));
    }
}

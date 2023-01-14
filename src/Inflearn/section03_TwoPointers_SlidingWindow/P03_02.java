package Inflearn.section03_TwoPointers_SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P03_02 {
// A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
// 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
// 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
// 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
// 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
    
    // 내 풀이 -> 시간초과....
    public ArrayList<Integer> solution(int n, int[] arr1, int m, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        //        p1
        // arr1 : 1  3  9  5  2    // p1 고정하고 p2와 비교
        // arr2 : 3  2  5  7  8
        //        p2
        int p1 = 0;
        int p2 = 0;
        while (p1 < n) {
            while (p2 < m) {
                if (arr1[p1] == arr2[p2]) {
                    answer.add(arr1[p1]);
                }
                p2++;
            }
            p2 = 0; // p2가 한바퀴 돌고나면 초기화
            p1++;
        }
        Collections.sort(answer);
        
        return answer;
    }
    
    // <강의 풀이>
    public ArrayList<Integer> solution2(int n, int[] arr1, int m, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 일단 배열들 오름차순 정렬해놓고 시작!! ★★★
        //        p1                // arr1[p1] < arr2[p2] 라면
        // arr1 : 1  2  3  5  9     //      -> p1++; (작은 쪽 증가)
        // arr2 : 2  3  5  7  8     // arr1[p1] == arr2[p2] 라면
        //        p2                //      -> 같다면 p1++; p2++; (둘 다 증가)
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int p1 = 0;
        int p2 = 0;
        while (p1 < n && p2 < m) { // 둘 중 하나라도 끝까지 가면 while문 중단
            if (arr1[p1] == arr2[p2]) {
                answer.add(arr1[p1]);
                p1++;
                p2++;
            } else if (arr1[p1] < arr2[p2]) {
                p1++;
            } else { // arr1[p1] > arr2[p2]
                p2++;
            }

        }
        Collections.sort(answer);
        
        return answer;
    }
    
    public static void main(String[] args) {
        P03_02 T = new P03_02();
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        for (int x : T.solution2(n, arr1, m, arr2)) {
            System.out.print(x + " ");
        }
    }
}

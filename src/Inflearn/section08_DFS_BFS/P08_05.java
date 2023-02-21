package Inflearn.section08_DFS_BFS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P08_05 {
// <동전교환> - 중복순열과 유사
//다음과 같이 여러 단위의 동전들이 주어져 있을때 거슬러 줄 동전의 최소개수는?
//각 단위의 동전은 무한정 쓸 수 있다.
//동전의 종류개수 N(1<=N<=12), N개의 동전의 종류, 거슬러 줄 금액 M(1<=M<=500)
// n = 3
// 1 2 5 (동전의 종류)
// m = 15 (거슬러줘야하는금액)   => [5 5 5]로 3개가 최소개수임

//       0 1 2     시간복잡도줄이기     0 1 2
// arr [ 1 2 5 ]   ------------>   [ 5 2 1 ]
// D(L, sum)  -> L은 사용된 동전의 갯수, sum은 그 L개의 동전으로 만든 금액 합계
//                                 DFS(0,0)
//                        0           1          2              -> 번 인덱스 사용
//               DFS(1,1)          DFS(1,2)       DFS(1,5)
//            0    1    2        0    1    2      0    1    2   -> 번 인덱스 사용
//     DFS(2,2)DFS(2,3)DFS(2,6)
//      [1 1]   [1 2]   [1 5]

//    ... 이렇게 계속 뻗다가
//    sum == m 일때 멈추기. 그때의 L이 답임.
    
    static int answer = Integer.MAX_VALUE; // 거슬러 줄 동전의 최소개수
    static int n = 0; // 동전의 종류개수
    static int m = 0; // 거슬러줘야할 금액
    
    public void DFS(int L, int sum, Integer[] arr) {
    
        if (sum > m) { // 금액의 합이 m을 넘어버리면 리턴
            return;
        }
        if (L > answer) { // L이 현재의 answer보다 큰 상태면 의미없으므로 리턴 ★★
            return;       // -> 이거 안해주면 타임리밋뜸.. 시간복잡도 줄이기 위해선 필수
        }
        if (sum == m) { // 종착점
            answer = Math.min(answer, L);
        } else { // n가닥씩 뻗어나감 -> 하나당 n번 재귀호출
            for (int i = 0; i < n; i++) {
                DFS(L + 1, sum + arr[i], arr);
            }
        }
    }
    
    public static void main(String[] args) {
        P08_05 T = new P08_05();
    
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // 배열 내림차순 정렬 (시간복잡도 줄이기)
        Arrays.sort(arr, Collections.reverseOrder()); // arr을 int[]가 아닌 Integer[]로 선언해야함
        m = sc.nextInt();
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}

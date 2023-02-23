package Inflearn.section08_DFS_BFS;

import java.util.Scanner;

public class P08_06 {
// <순열 구하기>
// 10 이하의 n개의 자연수가 주어지면 이 중 m개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
// 입력 :
// n = 3, m = 2
// 3 6 9
// 출력 :
// 3 6
// 3 9
// 6 3
// 6 9
// 9 3
// 9 6

//           0 1 2
// 배열 arr [ 3 6 9 ]

//          0 1
// 배열 pm [ _ _ ]   (pm은 permutation, 순열)
//          3 6,9
//          6 3,9
//          9 3,6

//          0 1 2
// 배열 ch [ 0 0 0 ]  (arr[i]가 쓰였다면 ch[i]를 1로 변경. 백트래킹할땐 0으로 변경)

// D(L)  -> L은 pm배열의 인덱스번호
// pm[L] = arr[i]
//                                  DFS(0)
//                        0           1          2
//              DFS(1)              DFS(1)            DFS(1)
//                1    2          0       2         0    1
//              DFS(2)DFS(2)  DFS(2)     DFS(2)  DFS(2)DFS(2)
//              [3 6] [3 9]   [6 3]      [6 9]   [9 3] [9 6]
    
    static int n, m;
    static int[] arr, pm, ch;
    
    public void DFS(int L) {
    
        if (L == m) { // 순열 완성
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else { // n가닥씩 뻗어나감 -> 하나당 n번 재귀호출
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) { // 사용되지 않았을 경우만
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L + 1);
                    ch[i] = 0; // 백트래킹시 체크 풀어주기!★
                }
            }
        }
    }
    
    public static void main(String[] args) {
        P08_06 T = new P08_06();
    
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        pm = new int[m];
        ch = new int[n];
        T.DFS(0);
    }

}

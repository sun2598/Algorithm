package Inflearn.section08_DFS_BFS;

import java.util.Scanner;

public class P08_04 {
// <중복순열 구하기>
// 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
// 입력 : n = 3, m = 2
// 출력 :
// 1 1
// 1 2
// 1 3
// 2 1
// 2 2
// 2 3
// 3 1
// 3 2
// 3 3
//          0 1
// 배열 pm [ _ _ ]   (pm은 permutation, 순열)
//          1 1
//          2 2     => 총 3*3 = 9개의 경우의 수
//          3 3
// D(L)  -> L은 pm배열의 인덱스번호
//                                  DFS(0)
//                        1           2          3
//                 DFS(1)           DFS(1)          DFS(1)
//             1   2   3          1   2   3         1   2   3
//        DFS(2)DFS(2)DFS(2)  DFS(2)DFS(2)DFS(2)  DFS(2)DFS(2)DFS(2)
//        [1 1] [1 2] [1 3]   [2 1] [2 2] [2 3]   [3 1] [3 2] [3 3]
    
    static int n; // 1~n까지 번호
    static int m; // m번 뽑기
    static int[] pm; // m번 뽑는 순열
    
    public void DFS(int L) {
    
        if (L == m) { // 순열이 완성되었을 때
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println(); // 줄바꿈
        } else { // 두 가닥이 아니라 n가닥씩 뿌리내림 -> 하나당 n번 재귀호출
            for (int i = 1; i <= n; i++) {
                pm[L] = i; // pm[0]에 1,2,3 대입, pm[1]에 1,2,3 대입
                DFS(L + 1);
            }
        }
    }
    
    public static void main(String[] args) {
        P08_04 T = new P08_04();
    
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        T.DFS(0);
    }
}

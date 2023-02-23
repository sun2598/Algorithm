package Inflearn.section08_DFS_BFS;

import java.util.Scanner;

public class P08_07 {
// <조합의 경우 수(메모이제이션)>
// 다음 공식을 사용하여 재귀를 이용해 조합 수를 구해주는 프로그램을 작성하세요.
// nCr = n-1Cr-1 + n-1Cr
// (nCr : 조합 combination. n개 중에서 r개를 순서없이 뽑는 경우의 수)
// (nPr : 순열 permutation. n개 중에서 r개를 순서대로 뽑는 경우의 수)

// 입력 : n(3<=n<=33) = 5, r(0<=r<=n) = 3

//                           5C3
//                      O           X
//                 4C2                 4C3
//             O        X            0        x
//          3C1        3C2          3C2      3C3
//         O   X      O   X        O   X    O   X
//       2C0   2C1  2C1   2C2
//            O   x
//          1C0   1C1

//      0  1  2  3  4  5        => 계산한 적 있는 조합의 값을 저장해놓는 2차원배열
//     ------------------
//  0 |
//  1 |
//  2 |    2
//  3 |       3
//  4 |
//  5 |
    
    int[][] dy = new int[35][35]; // n의 입력가능범위 생각해서 넉넉하게 임의로 잡음.
    
    public int DFS(int n, int r) {
    
        if (dy[n][r] > 0) { // 이미 값이 구해져 있다면 더 이상 뻗지 말고 구해진 값을 써라.
            return dy[n][r];
        }
    
        if (n == r || r == 0) { // nCr 값이 1이 되는 경우
            return 1;
        } else {
            return dy[n][r] = DFS(n-1,r-1) + DFS(n-1, r);
            // 값을 2차원배열에 입력하고 그 값을 리턴
        }
    }
    
    public static void main(String[] args) {
        P08_07 T = new P08_07();
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(T.DFS(n, r));
    }
}

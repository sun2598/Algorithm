package Inflearn.section08_DFS_BFS;

import java.util.Scanner;

public class P08_01 {
// <합이 같은 부분집합> (DFS : 아마존 인터뷰)
//N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
//두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
//둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.
//예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.

// D(L, sum)  -> L은 앞에서부터 몇개를 부분집합으로 만드는지, sum은 그 합
//                         DFS(0,0)
//                       o         x
//                  DFS(1,1)      DFS(1,0)
//                o          x
//          DFS(2,4)         DFS(2,1)
//         o        x
//   DFS(3,9)       DFS(3,4)
//  { 1 3 5 }        { 1 3 }

// 전체의 합 total : 32
// 앞에서부터 부분집합의 합 sum : 16
// total - sum == sum 일때까지 돌리기
    
    static String answer = "NO";
    static int n = 0;
    static int total = 0; // 전체집합의 합
    boolean flag = false;
    
    public void DFS(int L, int sum, int[] arr) {
    
        if (flag) { // 스택에 쌓여있는 재귀함수들은 모두 리턴
            return;
        }
        if (sum > total/2) { // 부분집합의 합이 전체집합의 반의 합보다 클때는 더 볼 필요가 없으므로 리턴
            return;
        }
        if (L == n) { // 종착점에 왔을 때 -> 부분집합이 만들어짐
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(L + 1, sum + arr[L], arr); // L번째 원소를 사용하는 경우
            DFS(L + 1, sum, arr); // L번째 원소를 사용하지 않는 경우
        }
    }
    
    public static void main(String[] args) {
        P08_01 T = new P08_01();
    
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}

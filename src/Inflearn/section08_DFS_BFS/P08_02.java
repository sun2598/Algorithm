package Inflearn.section08_DFS_BFS;

import java.util.Scanner;

public class P08_02 {
// <바둑이 승차(DFS)>
//철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
//철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
//N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.

// c = 259, n = 5
// {81,58,42,33,61}

// D(L, sum)  -> L은 앞에서부터 몇개를 부분집합으로 만드는지, sum은 그 합
//                         DFS(0,0)
//                        o         x
//                  DFS(1,33)      DFS(1,0)
//                 o         x
//          DFS(2,75)        DFS(2,33)
//         o        x
//  DFS(3,133)      DFS(3,75)
// { 33 42 58 }     { 33 42 }

// 앞에서부터 부분집합의 합 : sum
    
    static int answer = Integer.MIN_VALUE; // 태울 수 있는 가장 큰 무게
    static int c = 0; // 최대킬로그램
    static int n = 0; // 마리 수
    
    public void DFS(int L, int sum, int[] arr) {
    
        if (sum > c) { // sum이 c를 넘어버리면 리턴
            return;
        }
        // 여기까지 왔다는건 sum이 answer가 될 조건을 만족했다는 것
        if (L == n) { // 종착점에 왔을 때 -> 부분집합이 완성됨
            answer = Math.max(answer, sum); // 둘 중 큰 값 저장
        } else {
            DFS(L + 1, sum + arr[L], arr); // L번째 원소를 사용하는 경우
            DFS(L + 1, sum, arr); // L번째 원소를 사용하지 않는 경우
        }
    }
    
    public static void main(String[] args) {
        P08_02 T = new P08_02();
    
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}

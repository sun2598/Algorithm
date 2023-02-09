package Inflearn.section07_Recursive_Tree_Graph;

import java.util.Scanner;

public class P07_12 {
// <경로 탐색> (인접행렬) : DFS
// 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
// 아래 그래프에서 1번에서 5번 정점으로 가는 가지 수는 총 6가지입니다.
// 첫째 줄에는 정점의 수 N, 간선의 수 M이 주어진다. 그 다음부터 M줄에 걸쳐 연결정보가 주어진다.

// [1]<->[2]-->[5]      먼저 ch배열로 들린 노드 체크            D(1)
//  | \ / ↑             0 1 2 3 4 5                   1  2  3  4  5
//  ↓ ↙ ↘ |                                             D(2)
// [3]-->[4]                                       1  2  3  4  5
//                                                      D(3)
// 1 2 3 4 5                                       1  2  3  4  5        -> 여기서 5를 안들렀으니까 여기로 백트래킹해서 D(5)로
// 1 2 5                                                   D(4)             (백트래킹하면서 이전의 4,5는 체크 풀어줘야함)
// 1 3 4 2 5                                          1  2  3  4  5
// 1 3 4 5                                                       D(5)   -> answer++; 해주고 백트래킹.
// 1 4 2 5
// 1 4 5
    
    static int n, m, answer;
    static int[][] graph;
    static int[] ch;
    
    public void DFS(int v) { // v는 vertex. 노드라는뜻임
        
        if (v == n) { // n번 노드와 같다면
            answer++;
        } else { // 아니라면 가지 뻗어나가야함
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) { // 갈 수 있는 노드인지 판별
                    ch[i] = 1;
                    DFS(i); // 여기까지 마친 후엔 백트래킹하게되어있음
                    ch[i] = 0; // 체크 풀어주기
                }
            }
        }
    }
    
    public static void main(String[] args) {
        P07_12 T = new P07_12();
    
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n + 1][n + 1]; // 0번 인덱스는 안쓸거임
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}

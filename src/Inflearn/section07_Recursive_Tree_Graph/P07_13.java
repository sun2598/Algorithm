package Inflearn.section07_Recursive_Tree_Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class P07_13 {
// <경로 탐색> (인접리스트) : DFS
// 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
// 아래 그래프에서 1번에서 5번 정점으로 가는 가지 수는 총 6가지입니다.
// 첫째 줄에는 정점의 수 N, 간선의 수 M이 주어진다. 그 다음부터 M줄에 걸쳐 연결정보가 주어진다.

// [1]<->[2]-->[5]      먼저 ch배열로 들린 노드 체크            D(1)
//  | \ / ↑    ↗        0 1 2 3 4 5                      2  3  4
//  ↓ ↙ ↘ |  /                                          D(2)
// [3]-->[4]                                       1     3
//                                                      D(3)
// 1 2 3 4 5                                                4           -> 여기서 5를 안들렀으니까 여기로 백트래킹해서 D(5)로
// 1 2 5                                                   D(4)             (백트래킹하면서 이전의 4,5는 체크 풀어줘야함)
// 1 3 4 2 5                                             2        5
// 1 3 4 5                                                       D(5)   -> answer++; 해주고 백트래킹.
// 1 4 2 5
// 1 4 5

// 1번 List : 2 3 4      -> for문으로 1~5 다 돌 필요 없고 얘네만 돌면 됨
// 2번 List : 1 3
// 3번 List : 4
// 4번 List : 2 5
// 5번 List :
    
    static int n, m, answer;
    static ArrayList<ArrayList<Integer>> graph; // ArrayList 안의 ArrayList
    static int[] ch;
    
    public void DFS(int v) { // v는 vertex. 노드라는뜻임
        
        if (v == n) { // n번 노드와 같다면
            answer++;
        } else { // 아니라면 가지 뻗어나가야함
            for (int x : graph.get(v)) { // 처음엔 1(v)번 List부터 내부 탐색
                if (ch[x] == 0) { // 갈 수 있는 노드인지 판별
                    ch[x] = 1;
                    DFS(x); // 여기까지 마친 후엔 백트래킹하게되어있음
                    ch[x] = 0; // 체크 풀어주기
                }
            }
        }
    }
    
    public static void main(String[] args) {
        P07_13 T = new P07_13();
    
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        ch = new int[n + 1];
        for (int i = 0; i <= n; i++) { // 0번인덱스는 사용안할거임
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b); // 1번 List : 2 3 4 -> 이런 식으로 추가해줌
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
//   <입력>
//    5 9
//    1 2
//    1 3
//    1 4
//    2 1
//    2 3
//    2 5
//    3 4
//    4 2
//    4 5
}

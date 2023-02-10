package Inflearn.section07_Recursive_Tree_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P07_14 {

// <그래프 최단거리> (BFS) -> 최단거리는 무조건 BFS!
// 다음 그래프에서 1번 정점에서 각 정점에 대한 최소 이동 간선수를 출력하세요.
// 첫째 줄에는 정점의 수 N, 간선의 수 M이 주어진다. 그 다음부터 M줄에 걸쳐 연결정보가 주어진다.

// [1]<--[2]-->[5]      먼저 ch배열로 들린 노드 체크              1 ------------ 0레벨   ==> <1번방법> 레벨 사용하는 풀이법
//  | \     ↖ ↗ ↑            0 1 2 3 4 5 6                 /   \
//  ↓   ↘   / \ |       ch [               ]              3     4 --------- 1레벨
// [3]-->[4]-->[6]                                             /  \
//                                                            5    6 ------ 2레벨
//                                                                 |
//                                                                 2 ------ 3레벨

// <2번방법>
// 먼저 ch배열로 들린 노드 체크        =>        dis배열에 각 정점까지의 최소거리 넣기
//      0 1 2 3 4 5 6                             0 1 2 3 4 5 6
// ch [               ]                     dis [   0 3 1 1 2 2 ]    -> dis[nv] = dis[v] + 1
//
    
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph; // ArrayList 안의 ArrayList
    static int[] ch, dis;
    
    public void BFS(int v) { // v는 vertex. 노드라는뜻임
    
        Queue<Integer> Q = new LinkedList<>();
        ch[v] = 1; // 1이 들어오면 체크
        dis[v] = 0; // 1이 들어오면 거리는 0
        Q.offer(v);
    
        while (!Q.isEmpty()) {
            int cv = Q.poll(); // cv(current vertex) -> 현재 노드의 인덱스값을 저장해둠
    
            for (int nv : graph.get(cv)) { // nv(next vertex) -> 현재 노드에 연결된 다음 노드들 탐색
                if (ch[nv] == 0) { // 갈 수 있는 노드인지 판별
                    ch[nv] = 1;
                    Q.offer(nv); // 큐에 넣기
                    dis[nv] = dis[cv] + 1; // 현재 노드의 거리에 +1해서 저장해줌 ★★
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        P07_14 T = new P07_14();
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) { // 0번인덱스는 사용안할거임
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n + 1];
        dis = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b); // 1번 List : 3 4 -> 이런 식으로 추가해줌
        }
        T.BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
//입력
//6 9
//1 3
//1 4
//2 1
//2 5
//3 4
//4 5
//4 6
//6 2
//6 5
}

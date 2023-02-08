package Inflearn.section07_Recursive_Tree_Graph;

// <Tree 말단 노드까지의 가장 짧은 경로> -> (최단거리는 BFS로 푸는게 맞음!)
// 아래 그림과 같은 이진트리에서 루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이를 구하는 프로그램을 작성하세요.
// 각 경로의 길이는 루트노드에서 말단노드까지 가는데 이동하는 횟수를 즉 간선(에지)의 개수를 길이로 하겠습니다.
//       1 ----------- 0레벨
//    2      3 ------- 1레벨
//  4  5 ------------- 2레벨

import java.util.LinkedList;
import java.util.Queue;

class Node4 { // 부모(root)가 주어지면 좌,우 노드의 주소값을 저장하기 위한 클래스
    
    int data;
    Node4 lt;
    Node4 rt;
    
    public Node4(int val) { // 생성자. 생성될때 lt, rt값은 null
        data = val; // 1, 2, 3, 4, 5
        lt = rt = null;
    }
}
public class P07_10 {
    
    Node4 root;
    
    public int BFS(Node4 root) {
    
        Queue<Node4> Q = new LinkedList<>();
        Q.offer(root); // 우선 100번지 저장
        int L = 0; // 0레벨부터 시작
    
        while (!Q.isEmpty()) {
            int len = Q.size();
    
            for (int i = 0; i < len; i++) {
                Node4 cur = Q.poll(); // 현재 노드를 꺼내서 cur에 담음
    
                if (cur.lt == null && cur.rt == null) { // 말단노드인 경우
                    return L;
                }
                if (cur.lt != null) { // 왼쪽자식이 있으면 큐에 추가
                    Q.offer(cur.lt);
                }
                if (cur.rt != null) { // 오른쪽자식이 있으면 큐에 추가
                    Q.offer(cur.rt);
                }
            }
            L++; // 레벨 증가시켜줌
        }
        return 0; // 위에서 무조건 리턴하게돼있음. 여기쓴건 문법오류안나게하기위해서
    }
    
    public static void main(String[] args) {
        P07_10 tree = new P07_10();
        
        tree.root = new Node4(1);
        tree.root.lt = new Node4(2);
        tree.root.rt = new Node4(3);
        tree.root.lt.lt = new Node4(4);
        tree.root.lt.rt = new Node4(5);
        System.out.println(tree.BFS(tree.root)); // 100번지
    }
}

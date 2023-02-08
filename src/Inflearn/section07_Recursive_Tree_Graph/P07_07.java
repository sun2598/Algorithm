package Inflearn.section07_Recursive_Tree_Graph;

// <이진트리 순회> (BFS - Breadth First Search 넓이우선탐색 : 레벨탐색)
// 아래 그림과 같은 이진트리를 레벨탐색 연습하세요
//       1 ----------- 0레벨
//    2      3 ------- 1레벨      => 결과 출력 : 1 2 3 4 5 6 7
//  4  5    6  7 ----- 2레벨

//                     100 <- 주소값
//                    [ 1 ] <- 데이터 (root.data == 1) 
//                   200|300                       
//          200                   300                         
//         [ 2 ]                 [ 3 ]                            
//        400|500               600|700                     
//     400       500         600        700
//   [ 4 ]      [ 5 ]       [ 6 ]      [ 7 ]
// null|null  null|null   null|null  null|null

import java.util.LinkedList;
import java.util.Queue;

class Node2 { // 부모(root)가 주어지면 좌,우 노드의 주소값(200,300,400,...)을 저장하기 위한 클래스
    
    int data;
    Node2 lt;
    Node2 rt;
    
    public Node2(int val) { // 생성자. 생성될때 lt, rt값은 null
        data = val; // 1, 2, 3, 4, 5, 6, 7
        lt = rt = null;
    }
}

public class P07_07 {
    
    Node2 root;
    
    public void BFS(Node2 root) {
        Queue<Node2> Q = new LinkedList<>();
    
        Q.offer(root); // 100번지가 들어감
        int L = 0; // 0레벨로 시작
    
        while (!Q.isEmpty()) { // 큐의 내용물이 있을 동안
            int len = Q.size(); // 레벨의 크기. 해당 레벨에 원소가 몇개 있는지 저장
            System.out.print(L + "레벨 : ");
            for (int i = 0; i < len; i++) { // 해당 레벨의 원소들 출력
                Node2 cur = Q.poll(); // 현재 노드를 꺼내서 cur에 담음
                
                System.out.print(cur.data + " "); // cur은 번지수. cur.data는 처음엔 1
                
                // 현재 노드의 자식 노드들을 큐에 넣기
                if (cur.lt != null) {
                    Q.offer(cur.lt);
                }
                if (cur.rt != null) {
                    Q.offer(cur.rt);
                }
            }
            L++; // 레벨 증가시켜주기
            System.out.println(); // 줄바꿈
        }
    }
//  -----------------
//  1
//  -----------------
//    2 3               -> 1번 노드를 꺼내고, 그 자식 노드들을 큐에 넣기
//  -----------------
//      3 4 5           -> 2번 노드를 꺼내고, 그 자식 노드들을 큐에 넣기
//  -----------------
//        4 5 6 7       -> 3번 노드를 꺼내고, 그 자식 노드들을 큐에 넣기
//  -----------------
    
    public static void main(String[] args) {
        P07_07 tree = new P07_07();
        
        tree.root = new Node2(1);
        tree.root.lt = new Node2(2);
        tree.root.rt = new Node2(3);
        tree.root.lt.lt = new Node2(4);
        tree.root.lt.rt = new Node2(5);
        tree.root.rt.lt = new Node2(6);
        tree.root.rt.rt = new Node2(7);
        tree.BFS(tree.root);
    }
}

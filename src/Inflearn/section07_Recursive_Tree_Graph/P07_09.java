package Inflearn.section07_Recursive_Tree_Graph;

// <Tree 말단 노드까지의 가장 짧은 경로> -> (최단거리는 BFS로 푸는게 맞음. 근데 여기서는 학습용으로 DFS로 풀어보는거임)
// 아래 그림과 같은 이진트리에서 루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이를 구하는 프로그램을 작성하세요.
// 각 경로의 길이는 루트노드에서 말단노드까지 가는데 이동하는 횟수를 즉 간선(에지)의 개수를 길이로 하겠습니다.
//       1 ----------- 0레벨
//    2      3 ------- 1레벨
//  4  5 ------------- 2레벨

class Node3 { // 부모(root)가 주어지면 좌,우 노드의 주소값을 저장하기 위한 클래스
    
    int data;
    Node3 lt;
    Node3 rt;
    
    public Node3(int val) { // 생성자. 생성될때 lt, rt값은 null
        data = val; // 1, 2, 3, 4, 5
        lt = rt = null;
    }
}

public class P07_09 {
    
    Node3 root;
    
    public int DFS(int L, Node3 root) {
    
        if (root.lt == null && root.rt == null) { // 자식 노드가 없다면 -> 말단노드임
            return L;
        } else { // 왼쪽/오른쪽 자식의 길이 구해서 (재귀함수) -> 더 작은 값 리턴
            return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));
        }
    }
//                     DFS(0,100) : 1
//                    /          \
//          DFS(1,200) : 2       DFS(1,300) : 1
//          /       \
// DFS(2,400) : 2    DFS(2,500) : 2
    
    public static void main(String[] args) {
        P07_09 tree = new P07_09();
        
        tree.root = new Node3(1);
        tree.root.lt = new Node3(2);
        tree.root.rt = new Node3(3);
        tree.root.lt.lt = new Node3(4);
        tree.root.lt.rt = new Node3(5);
        System.out.println(tree.DFS(0, tree.root)); // 0레벨, 100번지
    }
}

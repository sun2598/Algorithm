package Inflearn.section07_Recursive_Tree_Graph;

// <이진트리 순회 (깊이우선탐색 DFS)>
// 아래 그림과 같은 이진트리로 전위순회와 후위순회를 연습해보세요.
//       1
//    2      3
//  4  5    6  7
//
// 전위순회 (부모-왼-오) 출력 : 1 2 4 5 3 6 7
// 중위순회 (왼-부모-오) 출력 : 4 2 5 1 6 3 7
// 후위순회 (왼-오-부모) 출력 : 4 5 2 6 7 3 1

//                     100 <- 주소값                                   |             |
//                    [ 1 ] <- 데이터 (root.data == 1)                 | DFS(null)   |
//                   200|300                                          | DFS(400)    |
//          200                   300                                 | DFS(200)    |
//         [ 2 ]                 [ 3 ]                                | DFS(100)    |
//        400|500               600|700                               |_____________|
//     400       500         600        700
//   [ 4 ]      [ 5 ]       [ 6 ]      [ 7 ]
// null|null  null|null   null|null  null|null

class Node { // 부모(root)가 주어지면 좌,우 노드의 주소값(200,300,400,...)을 저장하기 위한 클래스
    
    int data;
    Node lt;
    Node rt;
    
    public Node(int val) { // 생성자. 생성될때 lt, rt값은 null
        data = val; // 1, 2, 3, 4, 5, 6, 7
        lt = rt = null;
    }
}

public class P07_05 {
    
    Node root;
    
    public void DFS(Node root) {
    
        if (root == null) { // 말단 노드일 경우 (주소값이 없음)
            return;
        } else {
            
            // 1. 전위순회 -> 출력 : 1 2 4 5 3 6 7
            System.out.print(root.data + " ");
            DFS(root.lt);
            DFS(root.rt);
    
            // 2. 중위순회 -> 출력 : 4 2 5 1 6 3 7
//            DFS(root.lt);
//            System.out.print(root.data + " ");
//            DFS(root.rt);
    
            // 3. 후위순회 -> 출력 : 4 5 2 6 7 3 1
//            DFS(root.lt);
//            DFS(root.rt);
//            System.out.print(root.data + " ");
        }
    }
    
    public static void main(String[] args) {
        P07_05 tree = new P07_05();
    
        // 전위순회의 경우
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }
}

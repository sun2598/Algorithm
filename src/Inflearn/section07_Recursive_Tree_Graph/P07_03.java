package Inflearn.section07_Recursive_Tree_Graph;

public class P07_03 {
// <팩토리얼>
// 자연수 N이 입력되면 N!을 구하는 프로그램을 작성하세요.
// 예를 들어 5! = 5 * 4 * 3 * 2 * 1 = 120 입니다.
    
    // | DFS(1) = 1      |
    // | DFS(2) = 2 * 1  |
    // | DFS(3) = 3 * 2  |
    // | DFS(4) = 4 * 6  |
    // | DFS(5) = 5 * 24 |
    // |_________________|
    
    // DFS(5)
    // 5 * DFS(4)
    //     4 * DFS(3)
    //         3 * DFS(2)
    //             2 * DFS(1)
    //                 1
    
    public int DFS(int n) {
        
        if (n == 1) {
            return 1; // DFS(1)이 된다면 1 리턴
        } else{
            return n * DFS(n - 1);
        }
    }
    
    public static void main(String[] args) {
        P07_03 T = new P07_03();
    
        System.out.println(T.DFS(5));
    }
}

package Inflearn.section07_Recursive_Tree_Graph;

import java.util.Scanner;

public class P07_01 {
// 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.
    
    // <재귀함수> DFS Depth First Search
    // 자기 자신을 호출하는 함수
    // 스택을 이용★★★
    // (매개변수, 지역변수, 복귀주소) 가 스택 프레임에 담김
    
    // | DFS(0)                                          |
    // | DFS(1) 6라인 (매개변수, 지역변수, 복귀주소 -> DFS(2)) |
    // | DFS(2) 6라인 (매개변수, 지역변수, 복귀주소 -> DFS(3)) |
    // | DFS(3) 6라인 (매개변수, 지역변수, 복귀주소)           |
    // |_________________________________________________|
    
    public void DFS(int n) {
    
        if (n == 0) {
            return; // DFS(0)이 된다면 함수 종료
        } else{
            DFS(n - 1); // DFS(3), DFS(2), DFS(1)
            System.out.print(n + " "); // 1 2 3 순서대로 출력!!★★★
        }
    }
    
    public static void main(String[] args) {
        P07_01 T = new P07_01();
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        T.DFS(n);
    }
}

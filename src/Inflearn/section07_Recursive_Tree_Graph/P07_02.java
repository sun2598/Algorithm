package Inflearn.section07_Recursive_Tree_Graph;

import java.util.Scanner;

public class P07_02 {
// 재귀함수를 이용한 이진수 출력
// 10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요.
// 단 재귀함수를 이용해서 출력해야 합니다.
// N = 11
    
    // <이진수 변환>
    // 2 | 11 ... 1
    // 2 | 5  ... 1
    // 2 | 2  ... 0
    // 2 | 1  ... 1  여기 DFS(n)을 2로 나눈 나머지를 아래부터 위로 출력 -> 1011
    //     0
    
    // | DFS(0)                                           |
    // | DFS(1) 30라인 (매개변수, 지역변수, 복귀주소 -> DFS(2)) |
    // | DFS(2) 30라인 (매개변수, 지역변수, 복귀주소 -> DFS(5)) |
    // | DFS(5) 30라인 (매개변수, 지역변수, 복귀주소 -> DFS(11))|
    // | DFS(11) 30라인 (매개변수, 지역변수, 복귀주소)          |
    // |__________________________________________________|
    
    public void DFS(int n) {
    
        if (n == 0) {
            return; // DFS(0)이 된다면 함수 종료
        } else{
            DFS(n / 2); // DFS(5), DFS(2), DFS(1)
            System.out.print(n + " "); // 1 2 5 11 출력
            System.out.print(n % 2 + " "); // 1 0 1 1 출력
        }
    }
    
    public static void main(String[] args) {
        P07_02 T = new P07_02();

        T.DFS(11);
    }
}

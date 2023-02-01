package Inflearn.section07_Recursive_Tree_Graph;

public class P07_04 {
// <피보나치 수열> ★★★
// 1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
// 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
    
    // | DFS(1) = 1          |
    // | DFS(2) = 1          |
    // | DFS(3) = 1 + 1 = 2  |
    // | DFS(4) = 1 + 2 = 3  |
    // | DFS(5) = 2 + 3 = 5  |
    // | DFS(6) = 3 + 5 = 8  |
    // | DFS(7) = 5 + 8 = 11 |
    // |_____________________|
    
    // <기본 풀이>
    public int DFS(int n) {
        
        if (n == 1) {
            return 1; // DFS(1)이 된다면 1 리턴
        } else if (n == 2){
            return 1;
        } else{
            return DFS(n - 2) + DFS(n - 1);
        }
    }
    
    // <심화 풀이>
    static int[] fibo; // 이렇게 배열에 저장해주기 -> memorization
    public int DFS2(int n) {
    
        if (fibo[n] > 0) { // 이미 구한 적 있는 값이면 배열에 저장돼있을거니까 또 구할 필요 없도록
            return fibo[n];
        }
        if (n == 1) {
            return fibo[n] = 1;
        } else if (n == 2){
            return fibo[n] = 1;
        } else{
            return fibo[n] = DFS2(n - 2) + DFS2(n - 1);
            // 이렇게 배열에 저장해주면 한 번만 돌면( 됨. 이렇게 하면
            // DFS(7), DFS(6), DFS(5) ... DFS(1) 이렇게 for문 돌면서 매번 호출하는게 아니라
            // DFS(7) 한 번만 호출하여도 위의 모든 값들을 구할 수 있어서 속도 빠름.
        }
    }
    
    public static void main(String[] args) {
        P07_04 T = new P07_04();
    
        int n = 7;
    
        fibo = new int[n + 1];// 1번 ~ 7번까지 사용해야하니까
        T.DFS2(n);
        
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}

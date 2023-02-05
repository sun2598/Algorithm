package Inflearn.section07_Recursive_Tree_Graph;

public class P07_06 {
// 부분집합 구하기 (DFS)
// 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.
// n = 3
// 1 2 3
// 1 2
// 1 3
// 1
// 2 3
// 2
// 3

//   2  *  2  *  2  =  8    => 이 부분집합 만드는 원리랑 같음!
// { 1,    2,    3 }
//  o/x   o/x   o/x
// {               }

//                      DFS(1)                          ch[] = { 1 , 1 , 1 }
//                   o          x                              { 1 , 1 , 0 }
//                DFS(2)       DFS(2)
//              o       x
//          DFS(3)      DFS(3)
//        o       x
//   DFS(4)       DFS(4)
// { 1 2 3 }     { 1 2 }
    
    static int n;
    static int[] ch;
    
    public void DFS(int L) { // L이 부분집합으로 쓰일지 판별
    
        if (L == n + 1) { // 종착점에 왔을 때 -> 부분집합이 만들어짐
            String tmp = ""; // 부분집합
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) { // 왼쪽. 부분집합으로 사용하는경우
                    tmp += (i + " ");
                }
            }
            if (tmp.length() > 0) { // 0 인 경우는 공집합이라 제외.
                System.out.println(tmp);
            }
        } else { // 종착점이 아닐 때 -> 두 갈래로 뻗어나감
            ch[L] = 1;
            DFS(L + 1); // 왼쪽. 부분집합으로 사용하는경우
            ch[L] = 0;
            DFS(L + 1); // 오른쪽. 부분집합으로 사용 안함
        }
    }
    
    public static void main(String[] args) {
        P07_06 T = new P07_06();
        
        n = 3;
        ch = new int[n + 1]; // 0번 인덱스 사용 안할거임
         T.DFS(1);
    }
}

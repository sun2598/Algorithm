package Inflearn.section08_DFS_BFS;

import java.util.Scanner;

public class P08_03 {
// <최대점수 구하기(DFS)>
//이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
//각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
//제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
//(해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)

// D(L, score, time)  -> L은 앞에서부터 몇개를 부분집합으로 만드는지, score는 점수의 합, time은 시간의 합
//                                 DFS(0,0,0)
//                              o             x
//                  DFS(1,10,5)                 DFS(1,0,0)
//                  o        x                  o        x
//        DFS(2,35,17)    DFS(2,10,5)    DFS(2,35,17)   DFS(2,10,5)
//          o      x        o      x       o      x       o      x
// DFS(3,50,25) DFS(3,35,17)
    
    
    static int answer = Integer.MIN_VALUE; // 제한시간 내 최대 점수
    static int n = 0; // 주어지는 문제 수
    static int m = 0; // 제한시간
    
    public void DFS(int L, int score, int time, int[] ps, int[] pt) { // problem score, problem time

        if (time > m) { // 시간이 제한시간을 넘어버리면 리턴
            return;
        }
        // 여기까지 왔다는건 score가 answer가 될 조건을 만족했다는 것
        if (L == n) { // 종착점에 왔을 때 -> 부분집합이 완성됨
            answer = Math.max(answer, score); // 둘 중 큰 값 저장
        } else {
            DFS(L + 1, score + ps[L], time + pt[L], ps, pt); // L번째 원소를 사용하는 경우
            DFS(L + 1, score, time, ps, pt); // L번째 원소를 사용하지 않는 경우
        }
    }
    
    public static void main(String[] args) {
        P08_03 T = new P08_03();
    
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
            arr2[i] = sc.nextInt();
        }
        T.DFS(0, 0, 0, arr1, arr2);
        System.out.println(answer);
    }
}

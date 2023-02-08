package Inflearn.section07_Recursive_Tree_Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P07_08 {
// <송아지 찾기> (BFS : 상태트리탐색) -> '최단거리'구하기!!
//현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
//현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
//송아지는 움직이지 않고 제자리에 있다.
//현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
//최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.

// 예) s(현수위치) = 5, e(송아지위치) = 14

//                                  [5] ----------------------------------- 0레벨
//              1                   -1                  5
//             [6]                  [4]                [10] --------------- 1레벨
//        [7]       [11]            [3]   [9]                [15] --------- 2레벨
//     [8]   [12]       [16]        [2]      [14] ------------------------- 3레벨
    
    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch; // 큐에 들어갔던(현수가 방문했던) 숫자 체크하는 배열
    Queue<Integer> Q = new LinkedList<>();
    
    public int BFS(int s, int e) {
        ch = new int[10001]; // 좌표는 1 ~ 10000 범위니까
        ch[s] = 1; // 처음 현수의 위치 저장 -> 방문한 숫자는 1로 바꿔주기
        Q.offer(s);
        int L = 0; // 0레벨로 시작
    
        while (!Q.isEmpty()) {
            int len = Q.size();
    
            for (int i = 0; i < len; i++) {
                int x = Q.poll(); // 처음엔 5
                
                for (int j = 0; j < 3; j++) { // 자식노드 세팅
                    int child = x + dis[j]; // 5에 {1, -1, 5} 더해짐
    
                    if (child == e) { // 숫자가 송아지 위치와 같다면
                        return L + 1;
                    }
                    if (child >= 1 && child <= 10000 && ch[child] == 0) {
                        ch[child] = 1;
                        Q.offer(child);
                    }
                }
            }
            L++; // 레벨 증가시켜줌
        }
        return 0; // 위에서 무조건 리턴하게돼있음. 여기쓴건 문법오류안나게하기위해서
    }
    
    public static void main(String[] args) {
        P07_08 T = new P07_08();
    
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(T.BFS(s, e));
    }
}

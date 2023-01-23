package Inflearn.section05_Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P05_06 {
// 정보 왕국의 이웃 나라 외동딸 공주가 숲속의 괴물에게 잡혀갔습니다.
//정보 왕국에는 왕자가 N명이 있는데 서로 공주를 구하러 가겠다고 합니다.
//정보왕국의 왕은 다음과 같은 방법으로 공주를 구하러 갈 왕자를 결정하기로 했습니다.
//왕은 왕자들을 나이 순으로 1번부터 N번까지 차례로 번호를 매긴다.
//그리고 1번 왕자부터 N번 왕자까지 순서대로 시계 방향으로 돌아가며 동그랗게 앉게 한다.
//그리고 1번 왕자부터 시계방향으로 돌아가며 1부터 시작하여 번호를 외치게 한다.
//한 왕자가 K(특정숫자)를 외치면 그 왕자는 공주를 구하러 가는데서 제외되고 원 밖으로 나오게 된다.
//그리고 다음 왕자부터 다시 1부터 시작하여 번호를 외친다.
//이렇게 해서 마지막까지 남은 왕자가 공주를 구하러 갈 수 있다.
//예를 들어 총 8명의 왕자가 있고, 3을 외친 왕자가 제외된다고 하자. 처음에는 3번 왕자가 3을 외쳐 제외된다.
//이어 6, 1, 5, 2, 8, 4번 왕자가 차례대로 제외되고 마지막까지 남게 된 7번 왕자에게 공주를 구하러갑니다.
//N과 K가 주어질 때 공주를 구하러 갈 왕자의 번호를 출력하는 프로그램을 작성하시오.
    
    // <큐 Queue>
    // 선언 : Queue<Integer> Q = new LinkedList<>();
    //                ----------------------
    //     Q.poll() <-                      <- Q.offer(x)
    // (꺼내고 리턴)   ----------------------
    // Q.peek() : 꺼내진 않고 맨 앞 값을 리턴
    // Q.size() : 큐의 개수
    // Q.contains(x) : x라는 원소가 있다면 True, 없다면 False 리턴
    // Q.isEmpty : 큐가 비어있다면 True, 아니라면 False 리턴
    
    // 1 2 3 4 5 6 7 8      -> 여기서 1, 2는 빼서 뒤에 넣음
    // 3 4 5 6 7 8 1 2      -> 여기서 3번(3 외친 애) poll()
    // 4 5 6 7 8            -> 여기서 4, 5는 빼서 뒤에 넣음
    // 6 7 8 4 5            -> 여기서 6번(3 외친 애) poll()
    // Q.size() = 1이 될때까지 위의 과정 반복...
    public int solution(int n, int k) {
        int answer = 0;
    
        Queue<Integer> Q = new LinkedList<>();
        
        // 큐에 1~8번 세팅
        for (int i = 1; i <= n; i++) {
            Q.offer(i);
        }
    
        // 큐에 원소가 남아있을때까지 반복
        while (!Q.isEmpty()) {
            for (int i = 1; i < k; i++) { // k 전까지는 poll해서 뒤에 넣음
                Q.offer(Q.poll());
            }
            Q.poll(); // k 외친 애 poll
    
            if (Q.size() == 1) { // 마지막 남은 왕자.
                answer = Q.poll();
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P05_06 T = new P05_06();
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
    
        System.out.println(T.solution(n, k));
    }
}

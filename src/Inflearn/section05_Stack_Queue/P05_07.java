package Inflearn.section05_Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P05_07 {
// 현수는 1년 과정의 수업계획을 짜야 합니다.
//수업중에는 필수과목이 있습니다. 이 필수과목은 반드시 이수해야 하며, 그 순서도 정해져 있습니다.
//만약 총 과목이 A, B, C, D, E, F, G가 있고, 여기서 필수과목이 CBA로 주어지면 필수과목은 C, B, A과목이며 이 순서대로 꼭 수업계획을 짜야 합니다.
//여기서 순서란 B과목은 C과목을 이수한 후에 들어야 하고, A과목은 C와 B를 이수한 후에 들어야 한다는 것입니다.
//현수가 C, B, D, A, G, E로 수업계획을 짜면 제대로 된 설계이지만
//C, G, E, A, D, B 순서로 짰다면 잘 못 설계된 수업계획이 됩니다.
//필수과목순서가 주어지면 현수가 짠 N개의 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력하는 프로그램을 작성하세요.
    
    // C B A
    // C B D A G E  -> "YES"
    // C G E A D B  -> "NO"
    public String solution(String need, String plan) {
        String answer = "YES";
    
        Queue<Character> Q = new LinkedList<>();
        
        // 큐에 need(필수과목) 세팅
        for (char x : need.toCharArray()) {
            Q.offer(x);
        }

        // plan 탐색
        for (char x : plan.toCharArray()) {
            if (Q.contains(x)) { // 큐에 x과목이 있는데
                if (x != Q.poll()) { // 큐를 poll한 값이 x와 같지 않다면 -> 필수과목 순서가 맞지 않은것
                    return "NO";
                }
            }
        }
        // 큐에 뭔가 남아있다면 -> 필수과목을 이수하지 않은것
        if (!Q.isEmpty()) {
            return "NO";
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P05_07 T = new P05_07();
    
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
    
        System.out.println(T.solution(a, b));
    }
}

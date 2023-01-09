package Inflearn.section01_String;

import java.util.Scanner;

public class P10 {
// 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
// teachermode e -> 1 0 1 2 1 0 1 2 2 1 0
    
    public int[] solution(String str, char c) {
        int[] answer = new int[str.length()];
    
        //    t e a c h e r m o d e
        // 1001 0 1 2 3 0 1 2 3 4 0 -> 왼쪽의 e로부터의 거리 먼저 계산
        //    1 0 1 2 1 0 1 2 2 1 0 -> 오른쪽의 e로부터의 거리 계산 후 더 작다면 교체
        
        // 왼쪽의 e로부터의 거리 먼저 계산
        int p = 1000; // 거리
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) { // 문자가 같다면 p(거리)는 0으로 초기화
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }
        // 오른쪽의 e로부터의 거리 계산 후 더 작다면 교체
        p = 1000;
        for (int i = str.length()-1; i>=0; i--) {
            if (str.charAt(i) == c) { // 문자가 같다면 p(거리)는 0으로 초기화
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p); // Main.min( , ) 사용해서 더 작은 값을 answer에 대입
            }
        }
        
        
        return answer;
    }
    
    public static void main(String[] args) {
        P10 T = new P10();
    
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0); // charAt(n) : String의 n번째 char 반환 -> char 한 개를 읽을 땐 이 방식으로!
    
        for (int x : T.solution(str, c)) {
            System.out.print(x + " ");
        }
    }
}

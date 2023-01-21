package Inflearn.section05_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class P05_02 {
// 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
// (A(BC)D)EF(G(H)(IJ)K)LM(N) --> EFLM
    
    // <나의 풀이>
    public String solution(String str) {
        String answer = "";
    
        Stack<Character> stack = new Stack<>();
        
        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else if (x == ')') {
                stack.pop();
            } else if (stack.isEmpty() && Character.isAlphabetic(x)) {
                // 괄호가 다 닫힌 상태에서 알파벳이 들어오면
                answer += x;
            }
        }
        
        return answer;
    }
    
    // <강의 풀이>
    public String solution2(String str) {
        String answer = "";
        
        Stack<Character> stack = new Stack<>();
        
        for (char x : str.toCharArray()) {
            if (x=='(' || Character.isAlphabetic(x)) { // '(' 이거나 알파벳인 경우 -> 다 담음
                stack.push(x);
            } else { // ')' 인 경우 -> '('까지 다 삭제
                while (stack.pop() != '(') { // .pop() -> 꺼낸 값을 리턴함
                    // 꺼냈는데 '('라면 while문을 빠져나옴.
                }
            }
        }
        // 스택에 남아있는 문자 출력
        for (int i = 0; i < stack.size(); i++) { // size() : 스택의 원소 개수.
            answer += stack.get(i); // get(i) : i번째 원소를 리턴. (먼저들어간게 0번째)
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P05_02 T = new P05_02();
    
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
    
}

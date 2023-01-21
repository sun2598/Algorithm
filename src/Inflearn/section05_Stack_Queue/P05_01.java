package Inflearn.section05_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class P05_01 {
// 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
// (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))(은 올바른 괄호가 아니다.
    
    // <Stack> 대표문제
    // push(item) : 스택에 넣기
    // pop() : 스택에서 빼기 (매개인자 없음)
    // isEmpty() : 스택이 비어있는지 판별
    public String solution(String str) {
        String answer = "YES";
    
        // 스택 생성
        Stack<Character> stack = new Stack<>();
    
        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else { // ')' 라면
                if (stack.isEmpty()) { // 여는괄호 없이 닫는괄호가 있는 상황
                    return "NO";
                }
                stack.pop(); // 매개인자 없어야함
            }
        }
        if (!stack.isEmpty()) { // 여는괄호가 더 많은 상황
            return "NO";
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P05_01 T = new P05_01();
    
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
    
        System.out.println(T.solution(str));
    }
}

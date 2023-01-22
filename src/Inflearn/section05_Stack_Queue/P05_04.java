package Inflearn.section05_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class P05_04 {
// 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
// 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
    
    // 중위연산식(infix) : 데 연 데
    // 전위연산식(prefix) : 연 데 데
    // 후위연산식(postfix) : 데 데 연
    
    // <후위 연산식 문제>
    // 1. 앞에서부터 탐색하면서 숫자면 stack에 넣음
    // 2. 연산자를 만나면 stack에서 pop() -> 리턴값을 rt에 넣기 (꼭 rt 먼저!)
    //                 stack에서 pop() -> 리턴값을 lt에 넣기
    // 3. (lt 연산자 rt) 값을 stack에 넣기
    // 위 과정 반복.
    // 마지막에 stack.get(0) 하면 최종연산값 리턴
    
    public int solution(String str) {
        int answer = 0;
    
        Stack<Integer> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) { // 숫자면 stack에 넣기
                stack.push(x - 48); // x가 char라 바꿔줘야함
                // 숫자(0~9)의 ASCII 코드 : 48~57
                // (x - 48) 또는 (x - '0')
                // Integer.parseInt(x) 는 안됨! (매개인자에 String만 가능)
            } else { // 연산자 만난 경우
                int rt = stack.pop();
                int lt = stack.pop();
                switch (x) {
                    case '+': stack.push(lt + rt); break;
                    case '-': stack.push(lt - rt); break;
                    case '*': stack.push(lt * rt); break;
                    case '/': stack.push(lt / rt); break;
                }
            }
        }
        answer = stack.get(0);
        
        return answer;
    }
    
    public static void main(String[] args) {
        P05_04 T = new P05_04();
    
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
    
        System.out.println(T.solution(str));
    }
}

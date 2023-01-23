package Inflearn.section05_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class P05_05 {
// 여러 개의 쇠막대기를 레이저로 절단하려고 한다. 효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고,
// 레이저를 위에서 수직으로 발사하여 쇠막대기들을 자른다. 쇠막대기와 레이저의 배치는 다음 조건을 만족한다.
//• 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다. - 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓는다.
//• 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
//• 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.
//1. 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ‘( ) ’ 으로 표현된다. 또한, 모든 ‘( ) ’는 반 드시 레이저를 표현한다.
//2. 쇠막대기의 왼쪽 끝은 여는 괄호 ‘ ( ’ 로, 오른쪽 끝은 닫힌 괄호 ‘) ’ 로 표현된다.
// 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때, 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램을 작성하시오.
    
    
    // 여는괄호 -> 일단 stack.push('(')
    // 닫는괄호 -> 일단 stack.pop()
    //         -> 앞이 여는괄호면 레이저임 -> 조각 수(answer) += 여는괄호 수(stack.size())
    //         -> 앞이 여는괄호가 아니면 막대기의 끝임 -> 조각 수(answer) += 1
    // 3 6 9 12
    public int solution(String str) {
        int answer = 0; // 조각 수 -> 여는 괄호 하나당 하나 증가
    
        Stack<Character> stack = new Stack<>();
    
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') { // 여는괄호
                stack.push('(');
            } else { // 닫는괄호
                stack.pop();
    
                if (str.charAt(i - 1) == '(') { // 앞이 여는괄호면 레이저임
                    // charAt(i - 1) 해도 여기선 nullPointerException 뜨지 않음. 첫번째에 )가 올 리는 없으니까.
                    answer += stack.size();
                } else { // 앞이 여는괄호가 아니면 막대기의 끝임
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P05_05 T = new P05_05();
    
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
    
        System.out.println(T.solution(str));
    }
}

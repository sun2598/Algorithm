package Inflearn.section01_String;

import java.util.Scanner;

public class P05 {
// 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
// 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.

    public String solution(String str) {
        String answer;

        char[] s = str.toCharArray();
        // (예)
        // lt                rt
        // a # b ! G E * T @ S
        // 0 1 2 3 4 5 6 7 8 9 => lt < rt일 동안, lt와 rt가 알파벳인 경우에만 (lt의 문자) <-> (rt의 문자) 바꿔줌
        int lt = 0; 
        int rt = s.length - 1; // str.length()-1 도 가능
        while(lt < rt) {
            if(!Character.isAlphabetic(s[lt])) { // lt가 특수문자인 경우
                lt++;
            } else if(!Character.isAlphabetic(s[rt])) { // rt가 특수문자인 경우
                rt--;
            } else { // 둘 다 알파벳인 경우
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(s);

        return answer;
    }

    public static void main(String[] args) {
        P05 T = new P05();

        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.solution(str));
    }
}

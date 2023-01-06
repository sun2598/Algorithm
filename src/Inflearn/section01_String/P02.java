package Inflearn.section01_String;

import java.util.Scanner;

public class P02 {
// 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
    // ASCII 코드 
    // A ~ Z : 65 ~ 90
    // a ~ z : 97 ~ 122
    // => 대소문자 차이는 '32' -> 대소문자 변환할때 32를 더하거나 빼주면 됨

    public String solution(String str) {
        String answer = "";

        // 방법 1
//        for(char x : str.toCharArray()) {
//            if(Character.isLowerCase(x)) { // Character라는 클래스 사용
//                answer += Character.toUpperCase(x);
//            } else {
//                answer += Character.toLowerCase(x);
//            }
//        }
        // 방법 2 : ASCII 코드 사용
        for(char x : str.toCharArray()) {
            if(x >= 97 && x <= 122) { // 소문자일때
                answer += (char)(x - 32); // cast(형변환)시켜줘야 char로 출력됨.(안하면 숫자로 출력)
            } else { // 대문자일때
                answer += (char)(x + 32);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        P02 T = new P02();

        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.solution(str));
    }
}

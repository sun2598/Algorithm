package Inflearn.section01_String;

import java.util.Scanner;

public class P07 {
// 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
// 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
// 단 회문을 검사할 때 대소문자를 구분하지 않습니다.

    public String solution(String str)  {
        
        // 내 풀이
//        String answer = "";
//        str = str.toUpperCase();
//        String strReverse = new StringBuilder(str).reverse().toString(); // StringBuilder 사용. toString()해줘야함
//        for(int i=0; i<str.length(); i++) {
//            if(str.charAt(i) == strReverse.charAt(i)) {
//                answer = "YES";
//                continue;
//            } else {
//                answer = "NO";
//                break;
//            }
//        }
//        return answer;
        
        // 강의 방법 1
//        String answer = "YES";
//        str = str.toUpperCase();
//        int len = str.length();
//        for(int i=0; i<len/2; i++) {
//            // g o o G
//            // 0 1 2 3
//            if(str.charAt(i) != str.charAt(len-i-1)) {
////              answer = "NO";
////              break;
//                return "NO";
//            }
//        }
//        // if문에서 걸리지 않으면 위의 초기값 그대로 YES 리턴
//        return answer;
        
        // 강의 방법 2
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)) { // .equalsIgnoreCase : 대소문자 구별 안하고 같은지 판별
            answer = "YES";
        }
        // if문에서 걸리지 않으면 위의 초기값 그대로 NO 리턴
        return answer;
    }
    
    public static void main(String[] args) {
        P07 T = new P07();
    
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
    
        System.out.println(T.solution(str));
    }
}

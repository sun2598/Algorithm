package Inflearn.section01_String;

import java.util.Scanner;

public class P08 {
// 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
// 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
// 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며(알파벳 이외의 문자들의 무시), 대소문자를 구분하지 않습니다.
    
    public String solution(String str) {
        String answer = "NO";
        
        // replaceAll(정규표현식, 바꿀문자열)
        str = str.toUpperCase().replaceAll("[^A-Z]", ""); // A-Z가 아닌 것들을 모두 공백으로 치환
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) {
            answer = "YES";
        }
        return answer;
    }
    
    public static void main(String[] args) {
        P08 T = new P08();
    
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
    
        System.out.println(T.solution(str));
    }
    
}

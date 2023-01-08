package Inflearn.section01_String;

import java.util.Scanner;

public class P06 {
// 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
// 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
    
    public String solution(String str) {
        String answer = "";
        
        for(int i=0; i<str.length(); i++) {
            // indexOf() : 주어진 값과 일치하는 첫 번째 인덱스를 반환. 없다면 -1 반환
//            System.out.println(str.charAt(i)+" "+i+" "+str.indexOf(str.charAt(i))); // str의 i번째 문자의 첫번째 index는 몇인지 출력
            
            if(i == str.indexOf(str.charAt(i))) { // (문자의 index) == (문자의 첫번째 index) 라면
                answer += str.charAt(i);
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P06 T = new P06();
    
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
    
        System.out.println(T.solution(str));
    }
}

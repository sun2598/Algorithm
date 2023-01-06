package Inflearn.section01_String;

import java.util.Scanner;

public class P01 {
// 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.

    public int solution(String str, char c) {

        int answer = 0;

        str = str.toUpperCase(); // String을 대문자로 변환 후 반환
        c = Character.toUpperCase(c); // char는 대문자로 이렇게 반환

        // 방법1
//        for(int i=0; i<str.length(); i++) {
//            if(str.charAt(i) == c) {
//                answer++;
//            }
//        }
        // 방법2 enhanced for
        for(char x : str.toCharArray()) { // :(콜론) 다음에는 배열이나 iterator만 올 수 있으니까 str을 char의 배열로 만들어줌
            if(x == c) {
                answer ++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        P01 T = new P01();
        Scanner kb = new Scanner(System.in);

        String str = kb.next();
        char c = kb.next().charAt(0); // charAt(n) : String의 n번째 char 반환

        System.out.println(T.solution(str, c));
    }

}
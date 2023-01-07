package Inflearn.section01_String;

import java.util.ArrayList;
import java.util.Scanner;

public class P04 {
// N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.

    public ArrayList<String> solution(int n,String[] str) {
        ArrayList<String> answer = new ArrayList<>();

        // <String 관련 클래스>
        // String : 문자열 값 수정 불가능, immuatble(불변), 수정시 수정된 문자열의 객체가 따로 할당됨
        // StringBuffer, StringBuilder : 문자열 값 수정 가능, mutable(가변), 수정/삭제 등이 기존 문자열에 수정되어 적용
        //      -> 메소드(append, insert, delete, replace, substring, reverse 등)
        // StringTokenizer : 생성시 정달받은 문자열을 구분자로 나누어 각 토큰에 저장

        // 방법 1 - StringBuilder 사용
//        for(String x : str) { // str은 배열 형태라 enhanced for 가능
//            String tmp = new StringBuilder(x).reverse().toString(); // toString()해줘야함
//            answer.add(tmp);
//        }

        // 방법 2 - char[]로 만들기
        for(String x : str){
            char[] s = x.toCharArray();
            // (예)
            // lt      rt
            // s t u d y
            // 0 1 2 3 4  => lt < rt일 동안만 (lt의 문자) <-> (rt의 문자) 바꿔줌
            int lt = 0; // 첫번째 char의 index값
            int rt = x.length() - 1; // 마지막 char의 index값
            while(lt < rt) {
                char tmp = s[lt]; // ★★이렇게 뒤집는거 완전 중요!!★★ 이정도는 손코딩할줄알아야함
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s); // String.valueOf(매개변수는어떤타입이든가능) : 다른타입 -> String 변환
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        P04 T = new P04();

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];
        for(int i=0; i<n; i++){
            str[i] = kb.next();
        }

        for(String x : T.solution(n, str)) { // T.solution(n, str)가 배열 형태라 enhanced for 가능.
            System.out.println(x);
        }
    }
}

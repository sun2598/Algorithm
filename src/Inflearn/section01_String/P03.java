package Inflearn.section01_String;

import java.util.Scanner;

public class P03 {
// 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
// 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다.

    public String solution(String str) {
        String answer = "";
        // Integer.MIN_VALUE : 정수의 최소값(-2,147,483,648)
        // Integer.MAX_VALUE : 정수의 최대값(2,147,483,647)

        // 방법 1
//        int max = Integer.MIN_VALUE;
//        String[] s = str.split(" ");
//        for(String x : s) { // s가 배열이니까 enhanced for 사용 가능
//            int len = x.length();
//            if(len > max) { // > : 뒤에서 길이가 같은 단어가 나오더라도 앞쪽 단어로 유지됨 ( >= 쓰면 뒤쪽 단어로 바뀌어버림!)
//                max = len;
//                answer = x;
//            }
//        }

        // 방법 2
        int max = Integer.MIN_VALUE;
        int pos;
        // indexOf() : 주어진 값과 일치하는 첫 번째 인덱스를 반환. 없다면 -1 반환
        while((pos = str.indexOf(' ')) != -1) { // ' '를 발견 못하면 -1을 반환 -> 즉 ' '을 만나기 전까지
            String tmp = str.substring(0, pos); // substring(a, b) : a <= x < b(불포함) // 현재 pos에는 ' '의 index가 들어있음
            int len = tmp.length();
            if(len > max) {
                max = len;
                answer = tmp;
            }
            str = str.substring(pos + 1); // 현재 pos에는 ' '의 index가 들어있으니까 + 1 부터 끝까지
            // "it is time to study" -> "is time to study"

        }
        // ' '이 없는 마지막 단어 처리 (while문에서 false라 빠져나오니까)
        if(str.length() > max) {
            answer = str;
        }

        return answer;
    }

    public static void main(String[] args) {
        P03 T = new P03();

        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine(); // 단어는 next() / 한 줄은 nextLine()

        System.out.println(T.solution(str));
    }
}

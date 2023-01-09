package Inflearn.section01_String;

import java.util.Scanner;

public class P11 {
// 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
// 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
// 단 반복횟수가 1인 경우 생략합니다.
    
    public String solution(String str) {
        
        // 0 1 2 3 4 5 6 7 8 9 10 11 -> i = i+1 인지 비교해서 같다면 cnt 증가
        // K K H S S S S S S S E  '' -> 맨 마지막에 아무 문자 추가해줘야 이 알고리즘이 먹힘
        // 반복되는 문자 중 마지막 index에서 문자 append하고 cnt값도 append
        String answer = "";
        str = str + " ";
        int cnt = 1;
    
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
            } else {
                answer += str.charAt(i);
                if (cnt > 1) { // 누적됐던 앞 문자의 cnt가 있다면 출력
                    answer += String.valueOf(cnt);
                    cnt = 1; // 다시 1로 초기화
                }
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P11 T = new P11();
    
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
    
        System.out.println(T.solution(str));
    }
}

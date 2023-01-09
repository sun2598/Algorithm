package Inflearn.section01_String;

import java.util.Scanner;

public class P09 {
// 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
// 만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
    
    public int solution(String str) {
        
        // 내 풀이
//        StringBuilder sb = new StringBuilder();
//
//        char[] s = str.toCharArray();
//        for (char x : s) {
//            if (!Character.isAlphabetic(x)) {
//                sb.append(x);
//            }
//            if(sb.length() != 0) { // 이 조건 안써주면 밑 sb.charAt(0) 에서 IndexOutOfBoundsException 뜸
//                if (sb.charAt(0) == '0') {
//                    sb.delete(0, 0);
//                }
//            }
//        }
//        int answer = Integer.parseInt(sb.toString());
//        return answer;
        
        // 강의 방법 1
        // ASCII 코드
        // 숫자(0 ~ 9) : 48 ~ 57
        // answer = (answer * 10) + (x - 48)
        //         (자리수 올려주기)
        //    0   = (   0 * 10  ) +    0
        //    1   = (   0 * 10  ) +    1
        //   12   = (   1 * 10  ) +    2
        //  120   = (  12 * 10  ) +    0
        
//        int answer = 0;
//
//        for (char x : str.toCharArray()) {
//            if (x >= 48 && x <= 57) {
//                answer = (answer * 10) + (x - 48);
//            }
//        }
//        return answer;
        
        // 강의 방법 2
        String answer = "";
    
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) { // Character.isDigit(char) : char가 숫자임을 판별
                answer += x; // String에는 이렇게 뒤에 append해주면 됨 (굳이 StrinhBuilder 쓸 필요 없음)
            }
        }
        return Integer.parseInt(answer); // "0208"을 Integer.parseInt하면 -> 208
    }
    
    public static void main(String[] args) {
        P09 T = new P09();
    
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
    
        System.out.println(T.solution(str));
    }
}

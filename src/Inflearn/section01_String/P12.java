package Inflearn.section01_String;

import java.util.Scanner;

public class P12 {
// 비밀편지는 알파벳 한 문자마다 # 또는 *이 일곱 개로 구성되어 있습니다.
// 만약 현수가 “#*****#”으로 구성된 문자를 보냈다면 영희는 현수와 약속한 규칙대로 다음과 같이 해석합니다.
// 1. “#*****#”를 일곱자리의 이진수로 바꿉니다. #은 이진수의 1로, *이진수의 0으로 변환합니다. 결과는 “1000001”로 변환됩니다.
// 2. 바뀐 2진수를 10진수화 합니다. “1000001”을 10진수화 하면 65가 됩니다.
// 3. 아스키 번호가 65문자로 변환합니다. 즉 아스키번호 65는 대문자 'A'입니다.
// 첫 줄에는 보낸 문자의 개수(10을 넘지 않습니다)가 입력된다. 다음 줄에는 문자의 개수의 일곱 배 만큼의 #또는 * 신호가 입력됩니다.
// 현수는 항상 대문자로 해석할 수 있는 신호를 보낸다고 가정하고, 해석한 문자열을 출력합니다.
    
    public String solution(int n, String str) {
        String answer = "";
    
        for (int i = 0; i < n; i++) {
            // substring(0, 7) : 0 ~ 6 임!! 뒤 index는 불포함!!
            String tmp = str.substring(7*i, 7*i+7).replace("#", "1").replace("*", "0");
            
            // n진수 -> 십진수 변환 : Integer.parseInt(n진수, n)
            // 십진수 -> n진수 변환 : Integer.toString(n진수, n) -> 10진수를 제외한 나머지 진수는 String으로 받아야 한다.
            int num = Integer.parseInt(tmp, 2);
            
            // 십진수 아스키번호 -> char 형변환
            answer += (char)num;
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P12 T = new P12();
    
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
    
        System.out.println(T.solution(n, str));
    }
}

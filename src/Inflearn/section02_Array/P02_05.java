package Inflearn.section02_Array;

import java.util.Scanner;

public class P02_05 {
// <에라토스테네스 체> -> 소수 구하는 방법중 가장 빠름
// 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
// 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
    
    public int solution(int n) {
        int answer = 0;
        
        // <에라토스테네스 체 방식으로 소수 구하기>
        //  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20
        //  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  -> 일단 이렇게 초기화
        //  1  0  1  0  1  0  1  0  1  0  1  0  1  0  1  0  1  0  1  -> 2가 0인지 판별, 맞으면 answer++ 해주고 2의 배수들 1로
        //  1  1  1  0  1  0  1  1  1  0  1  0  1  1  1  0  1  0  1  -> 3이 0인지 판별, 맞으면 answer++ 해주고 3의 배수들 1로
        //  1  1  1  0  1  0  1  1  1  0  1  0  1  1  1  0  1  0  1  -> 4가 0인지 판별, 아니면 그냥 넘어감
    
        int[] ch = new int[n+1]; // 1~20이면 21칸을 만들어야 index가 20번까지 생김
        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) {
                answer++;
                for (int j = i; j <= n; j = j + i) { // i의 배수들
                    ch[j] = 1;
                }
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P02_05 T = new P02_05();
    
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
    
        System.out.println(T.solution(n));
    }
}

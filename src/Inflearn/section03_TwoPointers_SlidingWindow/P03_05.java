package Inflearn.section03_TwoPointers_SlidingWindow;

import java.util.Scanner;

public class P03_05 {
// N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
// 만약 N=15이면
// 7+8=15
// 4+5+6=15
// 1+2+3+4+5=15
// 와 같이 총 3가지의 경우가 존재한다.
    
    // 앞 문제와 동일한 풀이법
    // 1  2  3  4  5  6  7  8  9  10    -> sum = 3, sum == n판별, 아니면 sum < n이니까 rt++
    // lt rt
    // 1  2  3  4  5  6  7  8  9  10    -> sum = 15, sum == n판별, 맞으면 lt++
    // lt          rt
    // 1  2  3  4  5  6  7  8  9  10    -> sum = 14, sum == n판별, 아니면 sum < n 이니까 rt++
    //    lt       rt
    // 1  2  3  4  5  6  7  8  9  10    -> sum = 20, sum == n판별, 아니면 sum > n 이니까 lt++
    //    lt          rt
    public int solution(int n) {
        int answer = 0;
        int lt = 0;
        int sum = 0; // lt ~ rt 합
        int m = (n / 2) + 1; // 사용할 연속된 자연수의 개수. n=15 면 7+8이 가능한 가장 큰 수니까 1~8까지 8개.
        int[] arr = new int[m]; // 1~8을 넣을 배열
    
        // arr 초기화
        for (int i = 0; i < m; i++) {
            arr[i] = i + 1; // arr : 1 2 3 4 5 6 7 8
        }
    
        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if (sum == n) { // lt,rt값이 변경되어 새로운 sum이 나왔을땐 무조건 먼저 sum == m인지 확인
                answer++;
            }
            while (sum >= n) {
                sum -= arr[lt];
                lt++;
                if (sum == n) { // lt,rt값이 변경되어 새로운 sum이 나왔을땐 무조건 먼저 sum == m인지 확인
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P03_05 T = new P03_05();
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}

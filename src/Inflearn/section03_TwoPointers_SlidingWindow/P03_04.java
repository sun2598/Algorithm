package Inflearn.section03_TwoPointers_SlidingWindow;

import java.util.Scanner;

public class P03_04 {
// N개의 수로 이루어진 수열이 주어집니다.
// 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
// 만약 N=8, M=6이고 수열이 다음과 같다면
// 1 2 1 3 1 1 1 2
// 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
    
    // <내 풀이> -> 시간초과... 역시 2중 for문은 안되나봄...
    public int solution(int n, int m, int[] arr) {
        int answer = 0; // 경우의 수
    
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == m) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
    
    // <강의 풀이> : O(n^2) -> O(n)
    // sum : lt ~ rt 까지의 부분수열의 합. 처음엔 rt 대입
    // 1  2  1  3  1  1  1  2   -> sum = 1, sum < m인지 판별 후 맞으면 rt++
    // lt
    // rt
    // 1  2  1  3  1  1  1  2   -> sum = 3, sum < m인지 판별 후 맞으면 rt++
    // lt rt
    // 1  2  1  3  1  1  1  2   -> sum = 7, sum > m인지 판별 후 맞으면 lt++(이제 sum==m이 될 일은 없으니까)
    // lt       rt
    // 1  2  1  3  1  1  1  2   -> sum = 6, sum == m인지 판별 후 맞으면 lt++(이제 sum==m이 될 일은 없으니까)
    //    lt    rt
    // 1  2  1  3  1  1  1  2   -> sum = 4, sum < m인지 판별 후 맞으면 rt++
    //       lt rt
    // => 따라서 sum < m 이면 rt++ / sum >= m 이면 lt++
    public int solution2(int n, int m, int[] arr) {
        int answer = 0; // 경우의 수
        int sum = 0;
        int lt = 0;
        
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) { // lt,rt값이 변경되어 새로운 sum이 나왔을땐 무조건 먼저 sum == m인지 확인
                answer++;
            }
            while (sum >= m) { 
                sum -= arr[lt]; // 우선 sum에서 lt값을 빼주고
                lt++;       // lt 증가시키기
                if (sum == m) { // lt,rt값이 변경되어 새로운 sum이 나왔을땐 무조건 먼저 sum == m인지 확인
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
        P03_04 T = new P03_04();
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution2(n, m, arr));
    }
}

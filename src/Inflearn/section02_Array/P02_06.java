package Inflearn.section02_Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02_06 {
// N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
// 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
// 첫 자리부터의 연속된 0은 무시한다.
    
    // 소수인지 판별
    public boolean isPrime(int num) {
        if (num == 1) { // 1은 소수 아님
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) { // 2부터 num 전까지 하나라도 나머지가 0인 숫자가 있다면
                return false; // 소수 아님
            }
        }
        return true; // 위에서 걸리지 않았다면 소수임
    }
    
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 숫자 뒤집기 -> 1,2,3 반복
        // 1. 원래 수의 일의자리 구하기 : t = 원래수 % 10
        // 2. 뒤집힌 수 세팅 : reverse = (reverse * 10) + t  // reverse 초기값 0
        // 3. 원래 수 일의자리 쳐내기 : 원래수 = 원래수 / 10
        for (int i = 0; i < n; i++) {
            int original = arr[i];
            int reverse = 0;
            while (original > 0) { // 계속 쳐내다가 0 이상일때까지만 반복
                int t = original % 10;
                reverse = (reverse * 10) + t;
                original = original / 10;
            }
            if(isPrime(reverse)) { // 소수인지 판별하는 함수 호출
                answer.add(reverse);
            }
        }

//        int[] tmp = new int[n];
//        for (int i = 0; i < n; i++) {
//            tmp[i] = Integer.parseInt(new StringBuilder(arr[i]).reverse().toString());
//            // String[] arr로 받아와서 이렇게 뒤집는 방법도 있음
//        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P02_06 T = new P02_06();
    
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}

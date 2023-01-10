package Inflearn.section02_Array;

import java.util.ArrayList;
import java.util.Scanner;

public class P02_04 {
// 1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
// 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
    
    // 내 풀이
    public int[] solution(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }
    
    public static void main(String[] args) {
        P02_04 T = new P02_04();
    
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
    
        for (int x : T.solution(n)) {
            System.out.print(x + " ");
        }
    }
    
    
    // 강의 풀이 (그냥 참고용) - 배열 사용 안한 방법
//    public void solution2(int n) {
//        int a = 1;
//        int b = 1;
//        int c;
//
//        System.out.println(a + " " + b + " ");
//        for (int i = 2; i < n; i++) {
//            c = a + b;
//            System.out.println(c + " ");
//            a = b;
//            b = c;
//        }
//    }
}

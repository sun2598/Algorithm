package Inflearn.section06_Sorting_Searching;

import java.util.Scanner;

public class P06_02 {
// N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
// 정렬하는 방법은 버블정렬입니다.
// 6
// 13 5 11 7 23 15
    
    // <버블정렬>
    // 인접한 두 값만 계속 비교 -> 큰 수를 뒤로 보내는 느낌~
    
    // 1회전
    // 13  5 11  7 23 15 - 초기상태
    //  5 13 11  7 23 15
    //  5 11 13  7 23 15
    //  5 11  7 13 23 15
    //  5 11  7 13 15 23 - 최대값인 23이 맨 뒤로 옴
    // 2회전
    //  5 11  7 13 15 23 - 초기상태
    //  5  7 11 13 15 23
    //  5  7 11 13 15 23 - 그 다음 최대값인 15이 뒤로 옴

    public int[] solution(int n, int[] arr) {
    
        for (int i = 0; i < n - 1; i++) { // n회전차. n=6이면 5바퀴만 돌면 되니까.
            
            for (int j = 0; j < n - i - 1; j++) { // 회차가 늘어날수록 끝 값은 하나씩 더 고정돼가니까
                
                if (arr[j] > arr[j+1]) { // 인접한 두 값 비교 -> 큰 값을 뒤로 보내기
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }
    
    public static void main(String[] args) {
        P06_02 T = new P06_02();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}

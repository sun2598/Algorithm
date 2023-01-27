package Inflearn.section06_Sorting_Searching;

import java.util.Scanner;

public class P06_03 {
// N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
// 정렬하는 방법은 삽입정렬입니다.
    
    // <삽입 정렬>
    // 두 번째 값부터 꺼내서 앞으로 보내면서 맞는 자리 찾아가는 방식
    // 자료가 어느 정도 정렬이 되어 있을 경우 빠른 성능을 가짐
    // 이중 for문
    
    // 11  7  5  6 10  9    -> 2번째값 꺼낼 차례
    //  7 11  5  6 10  9    -> 3번째값 꺼낼 차례
    //  5  7 11  6 10  9    -> 4번째값 꺼낼 차례
    //  5  6  7 11 10  9    -> 5번째값 꺼낼 차례
    //  5  6  7 10 11  9    -> 6번째값 꺼낼 차례
    //  5  6  7  9 10 11    -> 끝
    
    public int[] solution(int n, int[] arr) {
    
        for (int i = 1; i < n; i++) { // i번째값 꺼낼 차례
            int tmp = arr[i]; // i번째 값 저장
            int j;
            
            for (j = i - 1; j >= 0; j--) {
    
                if (tmp < arr[j]) {
                    arr[j + 1] = arr[j]; // 큰 값을 뒤로 밀기
                } else { // 그게 아니면 tmp가 삽입될 지점임
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
        
        
        return arr;
    }
    
    public static void main(String[] args) {
        P06_03 T = new P06_03();
        
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

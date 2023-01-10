package Inflearn.section02_Array;

import java.util.ArrayList;
import java.util.Scanner;

public class P02_01 {
// N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.(첫 번째 수는 무조건 출력한다)
// 6
// 7 3 9 5 6 12    ->    7 9 6 12
    
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        // List<Integer> , List<Character> 와 같이 < > 안에는 Wrapper 클래스 사용!
        // <List계열 주요 메소드>
        // add( , ), set( , ), get( ), isEmpty(), size(), clear(), remove( )
    
        answer.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                answer.add(arr[i]);
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P02_01 T = new P02_01();
    
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) { // 이렇게 배열에 담아주기
            arr[i] = kb.nextInt();
        }
        for (int x : T.solution(n, arr)) { // 이렇게 결과 받아와서 출력하기
            System.out.print(x + " ");
        }
    }
}

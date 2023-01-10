package Inflearn.section02_Array;

import java.util.ArrayList;
import java.util.Scanner;

public class P02_03 {
// A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
// 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
// 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
    
    public ArrayList<Character> solution(int n, int[] arrA, int[] arrB) {
        ArrayList<Character> answer = new ArrayList<>();
    
        // 내 풀이
        for (int i = 0; i < n; i++) {
            if (arrA[i] == 2 && arrB[i] == 1) {
                answer.add('A');
            } else if (arrA[i] == 3 && arrB[i] == 2) {
                answer.add('A');
            } else if (arrA[i] == 1 && arrB[i] == 3) {
                answer.add('A');
            } else if (arrA[i] == arrB[i]) {
                answer.add('D');
            } else {
                answer.add('B');
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P02_03 T = new P02_03();
    
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = kb.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arrB[i] = kb.nextInt();
        }
        
        for (char x : T.solution(n, arrA, arrB)) {
            System.out.println(x);
        }
        // 위에서 String으로 받아서 .toCharArray()해서 한줄씩 출력하는 방법도 있음!
//        for (char x : T.solution(n, arrA, arrB).toCharArray()) {
//            System.out.println(x);
//        }
    }
}

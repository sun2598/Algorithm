package Inflearn.section02_Array;

import java.util.Scanner;

public class P02_12 {
// 선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
// 만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
// M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.
// n(시험) = 3 / s(학생) = 4
// 3 4 1 2
// 4 3 2 1
// 3 1 4 2
    
    // TODO 이해 안됨...
    public int solution(int n, int s, int[][] arr) {
        int answer = 0;
    
        for (int i = 1; i <= s; i++) { // 학생 i
            for (int j = 1; j <= s; j++) { // 비교학생 j
                int cnt = 0; // 등수가 앞서는 횟수
                
                for (int k = 0; k < n; k++) { // 1~n번 시험까지
                    int pi = 0; // i 학생의 등수
                    int pj = 0; // j 학생의 등수
                    for (int l = 0; l < s; l++) { // 1번~s번 학생까지 스캔
                        if (arr[k][l] == i) {
                            pi = l;
                        }
                        if (arr[k][l] == j) {
                            pj = l;
                        }
                    }
                    if (pi > pj) {
                        cnt++;
                    }
                }
                if (cnt == n) {
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
        P02_12 T = new P02_12();
    
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt(); // 학생의 수
        int n = kb.nextInt(); // 시험의 수
        int[][] arr = new int[n][s];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < s; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, s, arr));
    }
}

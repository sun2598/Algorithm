package Inflearn.section02_Array;

import java.util.Scanner;

public class P02_11 {
//김갑동 선생님은 올해 6학년 1반 담임을 맡게 되었다.
//김갑동 선생님은 우선 임시로 반장을 정하고 학생들이 서로 친숙해진 후에 정식으로 선거를 통해 반장을 선출하려고 한다.
//그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
//그래서 김갑동 선생님은 각 학생들이 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 표를 만들었다.
//각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램을 작성하시오.
//     1 2 3 4 5 학년     => 이렇게 배열의 1 ~ 5까지만 사용할거임
// 1 | 2 3 1 7 3
// 2 | 4 1 9 6 8
// 3 | 5 5 2 4 4
// 4 | 6 5 2 6 7
// 5 | 8 4 2 2 2
//학생
    public int solution(int n, int[][] arr) {
        int answer = 0; // 같은반 수가 가장 큰 학생
        int max = Integer.MIN_VALUE; // 같은반 수 최대값
        
        for (int i = 1; i <= n; i++) { // 학생 i
            int cnt = 0; // 학생 i의 같은반 수
            for (int j = 1; j <= n; j++) { // 비교 대상 학생 j
                
                for (int k = 1; k <= 5; k++) { // 1학년~5학년까지
                    if (arr[i][k] == arr[j][k]) { // i와 j가 같은 반이었는지 판별
                        cnt++;
                        break; // j랑 한번 같은 반이었다면 break;해서 빠져나가야함(다른 학년에서 또 같은반일때 cnt 올라가지 않게)
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
                answer = i;
            }
        }
        
        
        return answer;
    }
    
    public static void main(String[] args) {
        P02_11 T = new P02_11();
    
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n+1][6]; // 0행0열은 사용 안할거임
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}

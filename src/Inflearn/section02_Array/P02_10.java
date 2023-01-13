package Inflearn.section02_Array;

import java.util.Scanner;

public class P02_10 {
// 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
// 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
// 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
// 만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
// 00 01 02 03 04 05 06 // 상: [n-1][n]
// 10 11 12 13 14 15 16 // 좌: [n][n-1] 우: [n][n+1]
// 20 21 22 23 24 25 26 // 하: [n+1][n]
// 30 31 32 33 34 35 36
    
    // <내 풀이>
    public int solution(int n, int[][] arr) {
        int answer = 0;
        
        // 가장자리가 0으로 초기화된 새로운 배열 만들기
        int[][] arr2 = new int[n + 2][n + 2];
        for (int i = 1; i < n + 1 ; i++) {
            for (int j = 1; j < n + 1 ; j++) {
                arr2[i][j] = arr[i - 1][j - 1];
            }
        }
        // 봉우리 개수 구하기
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1 ; j++) {
                if((arr2[i][j] > arr2[i-1][j]) && (arr2[i][j] > arr2[i][j-1])
                        && (arr2[i][j] > arr2[i][j+1]) &&(arr2[i][j] > arr2[i+1][j])) {
                    answer++;
                }
            }
        }
        // 새로운 배열 확인용 코드
//        for (int i = 0; i < n+2; i++) {
//            for (int j = 0; j < n+2; j++) {
//                System.out.print(arr2[i][j]);
//            }
//            System.out.println();
//        }
        return answer;
    }
    
    // <강의 풀이>
    // 인스턴스변수(iv) : 이 위치에 있고 static 안 붙어있음 -> 객체를 생성해야 사용 가능
    // 클래스변수(cv) :  이 위치에 있고 static 붙어있음    ->  객체 생성 안해도 사용 가능
    
    // 시계방향 순서로 (12시, 3시, 6시, 9시) 행,열 좌표 계산하기 위한 변수
    int[] dx = {-1, 0, 1, 0}; // 행 (dx: direction x)
    int[] dy = {0, 1, 0, -1}; // 열 (dy: direction y)
    
    public int solution2(int n, int[][] arr) {
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true; // 봉우리인지 판별하는 변수
                for (int k = 0; k < 4; k++) { // (12시, 3시, 6시, 9시) -> 4개 방향 탐색
                    int ax = i + dx[k]; // 행 좌표 (ax: around x)
                    int ay = j + dy[k]; // 열 좌표 (ay: around y)
                    
                    // 경계선을 걸러내는 4개 조건식은 앞쪽에 써야함. 그래야 걸러지고 마지막 조건식에서 참조를 안하게 됨
                    if (ax >= 0 && ax < n && ay >= 0 && ay < n &&
                            arr[ax][ay] >= arr[i][j]) { // 주변(경계선 걸러짐)에 하나라도 크거나 같은게 있다면 봉우리가 아님
                        
                        flag = false;
                        break; // 네 방향 다 볼 필요 없으니까 빠져나옴
                    }
                }
                if(flag) {
                    answer++;
                }
            }
        }

        return answer;
    }
    
    public static void main(String[] args) {
        P02_10 T = new P02_10();
    
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}

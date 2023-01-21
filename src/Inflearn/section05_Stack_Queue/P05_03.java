package Inflearn.section05_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class P05_03 {
// 게임개발자인 죠르디는 크레인 인형뽑기 기계를 모바일 게임으로 만들려고 합니다.
//게임 화면은 1 x 1 크기의 칸들로 이루어진 N x N 크기의 정사각 격자이며 위쪽에는 크레인이 있고 오른쪽에는 바구니가 있습니다.
//(위 그림은 5 x 5 크기의 예시입니다). 각 격자 칸에는 다양한 인형이 들어 있으며 인형이 없는 칸은 빈칸입니다.
//모든 인형은 1 x 1 크기의 격자 한 칸을 차지하며 격자의 가장 아래 칸부터 차곡차곡 쌓여 있습니다.
//게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다. 집어 올린 인형은 바구니에 쌓이게 되는 데,
//이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다.
//만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 됩니다.
//위 상태에서 이어서 [5번] 위치에서 인형을 집어 바구니에 쌓으면 같은 모양 인형 두 개가 없어집니다.
//크레인 작동 시 인형이 집어지지 않는 경우는 없으나 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다.
//또한 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정합니다. (그림에서는 화면표시 제약으로 5칸만으로 표현하였음)
//게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때,
//크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 구하는 프로그램을 작성하세요.
    
    public int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
    
        Stack<Integer> stack = new Stack<>(); // 바구니
    
        for (int pos : moves) { // pos -> 열 고정
            for (int i = 0; i < n; i++) { // -> 1행부터 인형 만날때까지 탐색
                
                if (board[i][pos-1] != 0) { // 인형 만남
                    int tmp = board[i][pos-1]; // 인형 번호 임시 저장
                    board[i][pos-1] = 0; // 뽑았으니까 0으로 바꿔주기
                    
                    // 뽑은 인형이 스택의 맨 상단 인형이랑 같은지 판별
                    if (!stack.isEmpty() && tmp == stack.peek()) { // stack.peek() : 스택의 맨 상단 값 리턴
                        stack.pop();
                        answer += 2;
                    } else { // 같지 않은 경우
                        stack.push(tmp);
                    }
                    break; // 그 밑은 더 탐색할 필요 없으니까 break;
                }
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P05_03 T = new P05_03();
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }
    
        System.out.println(T.solution(n, board, m, moves));
    }
}

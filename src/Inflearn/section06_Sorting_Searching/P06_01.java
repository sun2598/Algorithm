package Inflearn.section06_Sorting_Searching;

import java.util.Scanner;

public class P06_01 {
// N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
// 정렬하는 방법은 선택정렬입니다.
// 6
// 13 5 11 7 23 15
    
    // <선택 정렬>
    // 첫번째 값부터 리스트 중 최소값과 교체해나감
    // 2중 for문
    
    //  i  j                -> idx == 0 => 0(i)번째 인덱스에 들어올 숫자의 인덱스번호
    // 15  5 11  7 23 15    
    //  i              j    -> idx == 1 => 0(i)번째 인덱스에 들어올 숫자의 인덱스번호 (최소값 탐색 끝) -> arr[idx] <-> arr[i] 바꿔줌
    //  5 15 11  7 23 15
    
    //     i  j             -> idx == 1 => 1(i)번째 인덱스에 들어올 숫자의 인덱스번호
    //  5 15 11  7 23 15
    //     i           j    -> idx == 3 => 1(i)번째 인덱스에 들어올 숫자의 인덱스번호 (최소값 탐색 끝) -> arr[idx] <-> arr[i] 바꿔줌
    //  5  7 11 15 23 15
    
    public int[] solution(int n, int[] arr) {
    
        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[idx] > arr[j]) { // 더 작은 애가 나타나면 걔로 인덱스 바꿈. 그럼 for문 끝나면 최소값이 idx에 대입돼있을것임
                    idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        
        return arr;
    }
    
    public static void main(String[] args) {
        P06_01 T = new P06_01();
    
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

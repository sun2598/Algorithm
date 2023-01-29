package Inflearn.section06_Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class P06_08 {
// 임의의 N개의 숫자가 입력으로 주어집니다.
// N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
// 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요.
// 단 중복값은 존재하지 않습니다.
    
    // <이분검색>
    // 오름차순이든 내림차순이든 정렬된 상태에서만 통함!
    
    // lt                   rt
    // 12 23 32 57 65 81 87 99
    //          mid
    
    // mid = (lt + rt) / 2
    // 일단 mid가 m인지 확인 후 맞다면 (mid+1)가 정답.
    // 아니라면 
    // mid > m -> 왼쪽에있는거  -> rt = (mid-1) 로 옮겨감
    // mid < m -> 오른쪽에있는거 -> lt = (mid+1) 로 옮겨감
    // 위 과정 반복하다가
    // 숫자 하나만 남게 된다면 lt, rt, mid 값이 모두 같아짐 -> (mid+1)가 정답.
    
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
    
        // 일단 오름차순 정렬
        Arrays.sort(arr);
        
        // 이분검색으로 m의 위치 찾기
        int lt = 0;
        int rt = n - 1;
        while (lt <= rt) { // 이 조건일 때까지 계속 돌기
            int mid = (lt + rt) / 2;
            if (arr[mid] == m) { // 일단 mid가 m인지 확인
                answer = mid + 1;
                break;
            } else if (arr[mid] > m) { // 왼쪽에있는경우  -> rt = (mid-1) 로 옮겨감
                rt = mid - 1;
            } else { // 오른쪽에있는경우 -> lt = (mid+1) 로 옮겨감
                lt = mid + 1;
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P06_08 T = new P06_08();
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}

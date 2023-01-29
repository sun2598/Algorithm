package Inflearn.section06_Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class P06_10 {
// N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간 간에 좌표가 중복되는 일은 없습니다.
//현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다.
//각 마구간에는 한 마리의 말만 넣을 수 있고, 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
//C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.
    
    // n=5(마구간 수), c=3(말 수)
    // 1 2 8 4 9
    
    // <결정알고리즘>
    // 이분 검색을 이용
    // 가능할 것 같은 값의 범위를 미리 파악해놓고 lt rt 설정
    
    // lt : 그냥 1로 설정
    // rt : 그냥 arr[n-1](배열의최대값)으로 설정
    
    // lt                     rt
    // 1           5          9
    //            mid
    //  1  2  4  8  9
    //  ㅇ       ㅇ
    // 현재 mid == 5인 상태 -> 가까운 두 말의 최대거리가 가능한지 검증해야함
    // 1. 일단 arr[0]에 첫 번째 말을 넣기 -> ep = 1 (end position)
    // 2. (arr[i] - ep >= 5 )인 위치에 두 번째 말을 넣기 -> ep = 8
    // -> 두 마리 밖에 배치 못함 (count == 2)
    
    // <count 구한 후>
    // -> (count < 3) 인 경우 -> mid를 줄여야함(저장x) -> rt = (mid - 1)로 재배치
    // -> (count >= 3) 인 경우 -> 일단 (answer = mid) 저장 -> mid를 늘려봄 -> lt = (mid + 1)로 재배치
    
    // lt          rt
    // 1   2       4
    //    mid
    //  1  2  4  8  9
    //  ㅇ    ㅇ  ㅇ
    // 현재 mid == 2인 상태 -> 가까운 두 말의 최대거리가 가능한지 검증해야함
    // 1. 일단 arr[0]에 첫 번째 말을 넣기 -> ep = 1 (end position)
    // 2. (arr[i] - ep >= 2 )인 위치에 두 번째 말을 넣기 -> ep = 4
    // 3. (arr[i] - ep >= 2 )인 위치에 세 번째 말을 넣기 -> ep = 8
    // -> 세 마리 배치 가능 (count == 3) -> 일단 (answer = mid) 저장 -> mid를 늘려봄 -> lt = (mid + 1)로 재배치
    
    // lt  rt
    // 3   4
    // mid
    //  1  2  4  8  9
    //  ㅇ    ㅇ  ㅇ
    // 현재 mid == 3인 상태 -> 가까운 두 말의 최대거리가 가능한지 검증해야함
    // 1. 일단 arr[0]에 첫 번째 말을 넣기 -> ep = 1 (end position)
    // 2. (arr[i] - ep >= 3 )인 위치에 두 번째 말을 넣기 -> ep = 4
    // 3. (arr[i] - ep >= 3 )인 위치에 세 번째 말을 넣기 -> ep = 8
    // -> 세 마리 배치 가능 (count == 3) -> 일단 (answer = mid) 저장 -> mid를 늘려봄 -> lt = (mid + 1)로 재배치
    
    // 배치 가능한 말의 수 구하는 함수
    public int count(int[] arr, int mid) {
        int cnt = 1; // 말 1마리로 시작
        int ep = arr[0];
    
        for (int i = 1; i < arr.length; i++) { // arr[0]에는 이미 배치돼있으니까
            if (arr[i] - ep >= mid) {
                ep = arr[i];
                cnt++;
            }
        }
        return cnt;
    }
    
    public int solution(int n, int c, int[] arr) {
        int answer = 0; // 가까운 두 말의 최대 거리
        
        // 우선 정렬해줘야함
        Arrays.sort(arr);
        
        int lt = 1; // 그냥 1로 설정
        int rt = arr[n - 1]; // 그냥 arr[n-1](배열의최대값)으로 설정
        
        // 이분검색
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            
            // <count 구한 후>
            // -> (count < 3) 인 경우 -> mid를 줄여야함(저장x) -> rt = (mid - 1)로 재배치
            // -> (count >= 3) 인 경우 -> 일단 (answer = mid) 저장 -> mid를 늘려봄 -> lt = (mid + 1)로 재배치
            if (count(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
        P06_10 T = new P06_10();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, c, arr));
    }

}

package Inflearn.section06_Sorting_Searching;

import java.util.Scanner;

public class P06_04 {
//캐시메모리는 CPU와 주기억장치(DRAM) 사이의 고속의 임시 메모리로서 CPU가 처리할 작업을 저장해 놓았다가
//필요할 바로 사용해서 처리속도를 높이는 장치이다. 워낙 비싸고 용량이 작아 효율적으로 사용해야 한다.
//철수의 컴퓨터는 캐시메모리 사용 규칙이 LRU 알고리즘을 따른다.
//LRU 알고리즘은 Least Recently Used 의 약자로 직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.
//캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘입니다.
//캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후
//캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.
    
    // <Least Recently Used>
    // 작업번호 : 1 2 3 2 6 2 3 5 7
    // 1 0 0 0 0
    // 2 1 0 0 0
    // 3 2 1 0 0
    // 2 3 1 0 0
    // 6 3 2 1 0
    // 2 6 3 1 0
    // 3 2 6 1 0
    // 5 3 2 6 1
    // 7 5 3 2 6
    
    public int[] solution(int s, int n, int[] arr) {
        int[] cache = new int[s]; // 캐시메모리
    
        for (int x : arr) {// 처리해야할 작업번호
            int pos = -1; // 인덱스번호
            
            for (int i = 0; i < s; i++) {
    
                if (x == cache[i]) { // 이미 작업번호가 캐시메모리에 존재한다면 (캐시히트)
                    pos = i; // 히트 난 지점의 인덱스를 저장
                }
            }
    
            if (pos == -1) { // 작업번호가 캐시메모리에 존재하지 않는다면 (캐시미스)
                for (int i = s - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1]; // 오른쪽으로 밀기
                }
            } else { // 이미 작업번호가 캐시메모리에 존재한다면 (캐시히트) -> 히트 난 지점부터 1까지 밀기
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1]; // 오른쪽으로 밀기
                }
            }
            cache[0] = x; // 캐시메모리 첫번째에 저장
            
        }
        
        
        return cache;
    }
    
    public static void main(String[] args) {
        P06_04 T = new P06_04();
        
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(); // 캐시의 크기
        int n = sc.nextInt(); // 작업의 개수
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        for (int x : T.solution(s, n, arr)) {
            System.out.print(x + " ");
        }
    }
    
}

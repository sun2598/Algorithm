package Inflearn.section04_HashMap_TreeSet;

import java.util.*;

public class P04_05 {
// 현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
// 현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
// 기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요. (K번째 수가 존재하지 않으면 -1를 출력합니다.)
// 만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.
    
    public int solution(int n, int k, int[] arr) {
        int answer = -1; // k번쨰 값이 없다면 -1 리턴
    
        // List : 순서 유지, 중복 저장
        // Set : 순서 유지 X, 중복 저장 X  -> 이 중복저장되지 않는 특성을 이용
        //     -- TreeSet : 기본적으로 오름차순으로 정렬되어 저장됨! (Collections.reverseOrder()로 내림차순도 가능)
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        
        // 3개 숫자의 합들을 TreeSet에 세팅 -> 3중 for문
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        // k번째 수 구하기
        int cnt = 0;
        for (int x : Tset) {
            cnt++;
            if (cnt == k) {
                return x; // answer = x; 하지 않고 그냥 바로 리턴해버림
            }
        }
        
        // <TreeSet>의 메소드들
        Tset.remove(143); // 143을 지움
        Tset.size(); // 개수
        Tset.first(); // 첫번째 원소.
        Tset.last(); // 마지막 원소.
        
        return answer;
    }
    
    public static void main(String[] args) {
        P04_05 T = new P04_05();
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
    }
}

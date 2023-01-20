package Inflearn.section04_HashMap_TreeSet;

import java.util.*;

public class P04_05 {
// 현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
// 현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
// 기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요. (K번째 수가 존재하지 않으면 -1를 출력합니다.)
// 만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.
    
    // lt    rt
    // 13 15 34 23 45 65 33 11 26 42
    
    public int solution(int n, int k, int[] arr) {
        int answer = 0;
    
        // 3개 숫자의 합들을 map에 세팅
        HashMap<Integer, Integer> map = new HashMap<>();
        int lt = 0;
        for (int rt = 2; rt < n; rt++) {
            map.put(arr[lt] + arr[lt+1] + arr[lt+2], map.getOrDefault(arr[lt] + arr[lt+1] + arr[lt+2], 0) + 1);
            
            lt++;
        }
        // k번째 큰 수 구하기 : map -> keyset으로 바꾸기
        List<Integer> keySet = new ArrayList<>(map.keySet());
    
        // 키 값으로 오름차순 정렬 : Collections.sort(keySet);
        // 키 값으로 내림차순 정렬 : Collections.reverse(keySet);
        Collections.reverse(keySet);

        
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

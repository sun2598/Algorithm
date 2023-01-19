package Inflearn.section04_HashMap_TreeSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class P04_03 {
// 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를 각 구간별로 구하라고 했습니다.
// 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
// 20 12 20 10 23 17 10
// 각 연속 4일간의 구간의 매출종류는
// 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
// 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
// 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
// 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
// N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별 매출액의 종류를 출력하는 프로그램을 작성하세요.
    
    // Two Pointer, Sliding Window 둘 다 적용!!
    
    // lt       rt
    // 20 12 20 10 23 17 10   -> 일단 rt전까지 3개만 hashmap에 넣고 시작.
    // <HashMap>
    // key :   20 12 10       -> map.size()가 매출액 종류 개수임
    // value : 2  1  1
    //
    //    lt       rt
    // 20 12 20 10 23 17 10
    // <HashMap>
    // key :   20 12 10 23     -> lt가 가리키던 key에 value 1 감소, rt가 가리키는 key에 value 1 증가
    // value : 1  1  1  1         (만약 감소시킨 후의 value가 0이라면 그 key는 삭제! 그 후 lt값 증가시켜야함)
    public ArrayList<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<Integer, Integer> HM = new HashMap<>();
        
        // 일단 rt전까지 3개만 hashmap에 넣고 시작.
        for (int i = 0; i < k - 1; i++) {
            HM.put(arr[i], HM.getOrDefault(arr[i], 0) + 1);
        }
        
        // Two Pointer, Sliding Window
        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            HM.put(arr[rt], HM.getOrDefault(arr[rt], 0) + 1);
            
            answer.add(HM.size()); // map.size()가 매출액 종류 개수임
            
            HM.put(arr[lt], HM.get(arr[lt]) - 1); // window 밀기 전 -> lt가 가리킨 key의 value 1 감소
            
            if (HM.get(arr[lt]) == 0) { // 감소시킨 후의 value가 0이라면 그 key는 삭제!
                HM.remove(arr[lt]);
            }
            lt++; // window 밀기.
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P04_03 T = new P04_03();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : T.solution(n, k, arr)) {
            System.out.print(x + " ");
        }
    }
}

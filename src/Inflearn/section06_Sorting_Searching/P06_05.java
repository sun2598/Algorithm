package Inflearn.section06_Sorting_Searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class P06_05 {
//현수네 반에는 N명의 학생들이 있습니다.
//선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어 내라고 했습니다.
//만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,
//N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.
    
    // 20 25 52 30 39 33 43 33
    
    // <나의 풀이> -> 이중for문이라 시간복잡도 n^2라 비추...
    public Character solution(int n, int[] arr) {
        char answer = 'U';
    
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    return 'D';
                }
            }
        }
        return answer;
    }
    
    // <강의 풀이 1> -> HashMap 사용
    public Character solution2(int n, int[] arr) {
        char answer = 'U';
    
        // map에 값 세팅하면서 map.containsKey(key) 가 true면 D 리턴
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                return 'D';
            } else {
                map.put(arr[i], 1);
            }
        }
        return answer;
    }
    
    // <강의 풀이 2> -> Arrays.sort 사용
    public Character solution3(int n, int[] arr) {
        char answer = 'U';
        
        Arrays.sort(arr); // 오름차순 정렬
        for (int i = 0; i < n-1; i++) {
            if (arr[i] == arr[i + 1]) {
                return 'D';
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
        P06_05 T = new P06_05();
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution3(n, arr));
    }
}

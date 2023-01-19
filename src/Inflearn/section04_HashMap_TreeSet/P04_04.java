package Inflearn.section04_HashMap_TreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class P04_04 {
// S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
// 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
    
    // 앞 문제랑 풀이법 똑같음!
    
    // <HashMap, Two Pointers, Sliding Window>
    // lt    rt
    // b  a  c  a  A  a  c  b  a    -> // 일단 rt전까지 2개만 hashmap에 넣고 시작.
    // a  b  c
    // <map1>          <map2>
    // b  a  c         a  b  c
    // 1  1  1         1  1  1
    
    // <나의 풀이>
    public int solution(String s, String t) {
        int answer = 0;
    
        char[] arr1 = s.toCharArray(); // 우선 배열로 바꾸기
        char[] arr2 = t.toCharArray();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        // 먼저 arr2를 map2에 넣어서 세팅.
        for (int i = 0; i < arr2.length; i++) {
            map2.put(arr2[i], map2.getOrDefault(arr2[i], 0) + 1);
        }
    
        // 일단 rt전까지 2개만 map1에 넣고 시작.
        for (int i = 0; i < arr2.length - 1; i++) {
            map1.put(arr1[i], map1.getOrDefault(arr1[i], 0) + 1);
        }
    
        // Two Pointer, Sliding Window
        int lt = 0;
        for (int rt = arr2.length - 1; rt < arr1.length; rt++) {
            map1.put(arr1[rt], map1.getOrDefault(arr1[rt], 0) + 1);
    
            // map1과 map2가 같은지 확인하기 (HashMap은 순서 상관없음!)
            if (map1.equals(map2)) {
                answer++;
            }
            
            // window 옆으로 밀기 전에 lt가 가리키는 key의 value 1 감소시켜주기
            map1.put(arr1[lt], map1.get(arr1[lt]) - 1);
            if (map1.get(arr1[lt]) == 0) { // 감소시킨 후의 value가 0이라면 그 key는 삭제!
                map1.remove(arr1[lt]);
            }
            
            lt++; // 밀기!
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P04_04 T = new P04_04();
    
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
    
        System.out.println(T.solution(s, t));
    }
}

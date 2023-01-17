package Inflearn.section04_HashMap_TreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class P04_02 {
// Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
// 예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
// 알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
// 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.
    
    // <내 풀이>
    // A a b C e
    // 2 1 1 1 2
    public String solution(String str1, String str2) {
        String answer = "NO";
    
        // 문자열을 HashMap에 저장
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (char x : str1.toCharArray()) {
            map1.put(x, map1.getOrDefault(x, 0) + 1);
            // ★★★★★ map.getOrDefault(x, 0) : x에 매핑된 value 가져오고 없다면 0 리턴 => 카운팅할때 엄청 중요!!
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char x : str2.toCharArray()) {
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }
        
        // map1과 map2 비교
        int cnt = 0; // map1와 map2에서 개수가 같은 문자 수
        for (char key : map1.keySet()) { // map.keySet() : 모든 key를 Set객체에 담아서 리턴. => map을 탐색할때는 이렇게 함!
            if (map1.get(key) == map2.get(key)) {
                cnt++;
            }
        }
        if (cnt == map1.size()) {
            answer = "YES";
        }
        
        return answer;
    }
    
    // <강의 풀이>
    // A B A C B
    // B B A C A
    // 1. 첫번째 문자열만 HashMap에 저장
    // -> A B C
    //    2 2 1
    // 2. 두번째 문자열에서 같은 key가 있다면 value를 하나씩 감소. value가 모두 0이 된다면 애너그램임.
    // -> A B C
    //    0 0 0
    public String solution2(String str1, String str2) {
        String answer = "YES";
        
        // 1. 첫번째 문자열만 HashMap에 저장
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (char x : str1.toCharArray()) {
            map1.put(x, map1.getOrDefault(x, 0) + 1);
            // ★★★★★ map.getOrDefault(x, 0) : x에 매핑된 value 가져오고 없다면 0 리턴 => 카운팅할때 엄청 중요!!
        }
        
        // 2. 두번째 문자열에서 같은 key가 있다면 value를 하나씩 감소
        for (char x : str2.toCharArray()) {
            if (!map1.containsKey(x) || map1.get(x) == 0) { // 같은 키가 없거나 str2에 있는 key가 str1에 없는 경우
                return "NO"; // 애너그램이 아님.
            }
            map1.put(x, map1.get(x) - 1);
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P04_02 T = new P04_02();
    
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
    
        System.out.println(T.solution2(str1, str2));
    }
}

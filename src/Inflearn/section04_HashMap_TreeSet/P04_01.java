package Inflearn.section04_HashMap_TreeSet;

import Inflearn.section03_TwoPointers_SlidingWindow.P03_06;

import java.util.HashMap;
import java.util.Scanner;

public class P04_01 {
// 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
// 투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
// 선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
// 반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
    
    // HashMap 사용
    public char solution(int n, String str) {
        char answer = ' ';
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1); // map.getOrDefault(x, 0) : x에 매핑된 value 가져오고 없다면 0
        }
        //System.out.println(map.containsKey('F'));
        //System.out.println(map.size());
        //System.out.println(map.remove('C'));
        
        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) { // map -> set 변환
            //System.out.println(key+" "+map.get(key));
            if (map.get(key) > max) { // map.get(key) : 해당 key의 value를 반환
                max = map.get(key);
                answer = key;
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P04_01 T = new P04_01();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.nextLine();
        System.out.print(T.solution(n, str));
    }
}

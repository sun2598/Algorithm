package Inflearn.section03_TwoPointers_SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P03_01 {
// 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
// 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
// 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
// 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
// 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
    
    // 내 풀이 : 인상적이지 않은 방법...
    public int[] solution(int n, int[] arr1, int m, int[] arr2) {
        int[] arr = new int[n + m];
    
        for (int i = 0; i < n; i++) {
            arr[i] = arr1[i];
        }
        for (int i = n; i < n+m; i++) {
            arr[i] = arr2[i - n];
        }
        
        // 오름차순 정렬
        Arrays.sort(arr); // arr = Arrays.sort(arr); -> 이렇게 다시 대입하면 안됨
        
        return arr;
    }
    
    // <강의 풀이> : two pointer algorithm -> 이렇게 푸는게 좋음!!
    //        p1
    // arr1 : 1  3  5           // arr1[p1] < arr2[p2] 인지 비교
    // arr2 : 2  3  5  7  9     //  -> 맞으면 arr1[p1]을 arr에 더해주고, p1++
    //        p2
    public ArrayList<Integer> solution2(int n, int[] arr1, int m, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
    
        int p1 = 0;
        int p2 = 0;
    
        while (p1 < n && p2 < m) { // 둘 중 하나라도 끝까지 가면 while문 중단
            if (arr1[p1] < arr2[p2]) {
                answer.add(arr1[p1++]); // p1이 연산에 사용된 후 증가
            } else {
                answer.add(arr2[p2++]);
            }
        }
        while (p1 < n) { // p2가 끝나서 p1이 남아있는 경우
            answer.add(arr1[p1++]);
        }
        while (p2 < n) { // p1이 끝나서 p2가 남아있는 경우
            answer.add(arr2[p2++]);
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P03_01 T = new P03_01();
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        for (int x : T.solution2(n, arr1, m, arr2)) {
            System.out.print(x + " ");
        }
    }
}

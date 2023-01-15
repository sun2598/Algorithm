package Inflearn.section03_TwoPointers_SlidingWindow;

import java.util.Scanner;

public class P03_06 {
// 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
// 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
// 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
// 1 1 0 0 1 1 0 1 1 0 1 1 0 1
// 여러분이 만들 수 있는 1이 연속된 연속부분수열은
// 1 1 0 0 1 1 0 (1 1 1 1 1 1 1)
// 이며 그 길이는 8입니다.
    
    // <rt는 0을 만나면 무조건 1로 바꿈. cnt가 k보다 커지면 lt가 rt를 쫓아오면서 rt가 바꾼 1을 0으로 원상복구>
    // 1  1  0  0  1  1  0  1  1  0  1  1  0  1
    // lt
    // rt
    // 1  1  0  0  1  1  0  1  1  0  1  1  0  1     => rt에서 1로 바꿈 -> cnt=1 (len=3으로 갱신 -> answer=3)
    // lt    rt{
    // 1  1  1  1  1  1  0  1  1  0  1  1  0  1     => rt에서 1로 바꿈 -> cnt=3 이제는 lt를 증가시킬것임 (-> answer=6)
    // lt                rt
    // 1  1  0  1  1  1  1  1  1  0  1  1  0  1     => lt에서 0으로 바꿈 -> cnt=2 (len=4로 갱신 -> answer=6)
    //       lt          rt
    public int solution(int n, int k, int[] arr) {
        int answer = 0; // lt~rt 연속부분수열의 길이의 최대값
        int lt =  0;
        int cnt = 0; // 0->1 바꾼 횟수 (cnt <= k)
    
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) { // rt에서 0이면 1로 바꿔야하니까 cnt++. (★★실제로 arr[rt]를 바꾸진 않아야함!)
                cnt++;
            }
            while (cnt > k) {
                if (arr[lt] == 0) { // lt에서 0이면 rt가 1로 바꿔놨던 애니까 0으로 원상복구. cnt--. (★★실제로 arr[lt]를 바꾸진 않아야함!)
                    cnt--;
                }
                lt++; // 0이든 1이든 lt는 증가시켜야함
            }
            // cnt가 k보다 크면 안되니까 위 while문에서 cnt조정을 한 다음 길이 구해야함
            answer = Math.max(answer, rt - lt + 1); // rt - lt + 1 : lt~rt 연속부분수열의 길이
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        P03_06 T = new P03_06();
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(T.solution(n, k, arr));
    }
}
package Inflearn.section06_Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class P06_09 {
//지니레코드에서는 불세출의 가수 조영필의 라이브 동영상을 DVD로 만들어 판매하려 한다.
//DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 한다.
//순서가 바뀌는 것을 우리의 가수 조영필씨가 매우 싫어한다. 즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는
//1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다. 또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다.
//고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다. 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
//그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 한다.
//DVD의 최소 용량 크기를 구하세요.
//힌트 : 3개의 DVD용량이 17분짜리이면 (1, 2, 3, 4, 5) (6, 7), (8, 9) 이렇게 3개의 DVD로 녹음을 할 수 있다.
//17분 용량보다 작은 용량으로는 3개의 DVD에 모든 영상을 녹화할 수 없다.
    
    // n=9(곡 수), m=3(DVD 수)
    // 1 2 3 4 5 6 7 8 9
    
    // <결정알고리즘>
    // 이분 검색을 이용
    // 가능할 것 같은 값의 범위를 미리 파악해놓고 lt rt 설정
    
    // lt : 주어진 곡들 중 최대값 / rt : 주어진 곡들 다 합한 값
    // lt                      rt
    // 9          27           45
    //            mid
    
    // lt       rt
    // 9   17   26
    //     mid
    
    // mid = (lt + rt) / 2
    // 현재 mid에 3개이하의 dvd에 곡들을 담을 수 있는지 확인
    // -> 가능하다면 (answer = mid) 대입하고
    // 범위를 왼쪽으로 좁혀나가야 함 -> rt = (mid-1) 로 옮겨감
    // -> 불가능하다면
    // 범위를 오른쪽으로 좁혀나가야 함 -> lt = (mid+1) 로 옮겨감
    // 위 과정을 lt == rt 가 될때까지 반복.
    
    // dvd용량(capacity)이 주어지면 곡들을 다 담으려면 dvd가 몇 장이 필요한지 구하는 함수
    public int count(int[] arr, int capacity) { 
        int cnt = 1; // dvd는 최소 한 장
        int sum = 0; // 현 dvd에 곡들의 합을 담는 저장소
    
        for (int x : arr) {
            // 일단 첫 번째 dvd에 담는다고 생각
            if (sum + x > capacity) { // 곡들의 합이 dvd 용량을 넘어버리면 새로운 dvd 필요
                cnt++;
                sum = x; // sum 초기화
            } else {
                sum += x;
            }
        }
        return cnt;
    }
    
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
    
        // 배열 최대/최소값 구하는 방법 1 : Arrays.sort 사용 (근데 얘는 배열이 바뀌어짐)
//       Arrays.sort(arr);
//       int lt = arr[n - 1];
        
        // 배열 최대/최소값 구하는 방법 2 : Arrays.stream 사용 (얘는 배열이 바뀌지 않고 값만 찾아줌)
        int lt = Arrays.stream(arr).max().getAsInt(); // getAsInt()로 형변환 해줘야함
        
        // 배열 총합 구하는 방법 : Arrays.stream 사용
        int rt = Arrays.stream(arr).sum(); // getAsInt()로 형변환 안해줌
        
        // 이분검색
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            
            // 현재 mid에 m개 이하의 dvd에 곡들을 담을 수 있는지 확인
            if (count(arr, mid) <= m) { // 가능하다면
                answer = mid;
                rt = mid - 1; // 범위를 왼쪽으로 좁혀나가야 함
            } else { // 불가능하다면
                lt = mid + 1; // 범위를 오른쪽으로 좁혀나가야 함
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
        P06_09 T = new P06_09();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}

package Inflearn.section05_Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P05_08 {
// 메디컬 병원 응급실에는 의사가 한 명밖에 없습니다.
//응급실은 환자가 도착한 순서대로 진료를 합니다. 하지만 위험도가 높은 환자는 빨리 응급조치를 의사가 해야 합니다.
//이런 문제를 보완하기 위해 응급실은 다음과 같은 방법으로 환자의 진료순서를 정합니다.
//• 환자가 접수한 순서대로의 목록에서 제일 앞에 있는 환자목록을 꺼냅니다.
//• 나머지 대기 목록에서 꺼낸 환자 보다 위험도가 높은 환자가 존재하면 대기목록 제일 뒤로 다시 넣습니다. 그렇지 않으면 진료를 받습니다.
//즉 대기목록에 자기 보다 위험도가 높은 환자가 없을 때 자신이 진료를 받는 구조입니다.
//현재 N명의 환자가 대기목록에 있습니다.
//N명의 대기목록 순서의 환자 위험도가 주어지면, 대기목록상의 M번째 환자는 몇 번째로 진료를 받는지 출력하는 프로그램을 작성하세요.
//대기목록상의 M번째는 대기목록의 제일 처음 환자를 0번째로 간주하여 표현한 것입니다.
    
    
    // n=5, m=2
    // 60 50 70 80 90
    
    class Person {
        
        int id; // 아이디(순서)
        int priority; // 위험도
    
        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
    
    // (아이디, 위험도)
    // (0, 60) (1, 50) (2, 70) (3, 80) (4, 90)
    // ...
    // (4, 90) (0, 60) (1, 50) (2, 70) (3, 80)  -> 여기서 poll() 되면서 answer++ -> 현재 answer는 1, 아이디(4)를 m과 비교 -> 같지 않음
    // ...
    // (3, 80) (0, 60) (1, 50) (2, 70)          -> 여기서 poll() 되면서 answer++ -> 현재 answer는 2, 아이디(3)를 m과 비교 -> 같지 않음
    // ...
    // (3, 80) (0, 60) (1, 50) (2, 70)          -> 여기서 poll() 되면서 answer++ -> 현재 answer는 3, 아이디(2)를 m과 비교 -> 같음
    
    public int solution(int n, int m, int[] arr) {
        int answer = 0; // 각 환자의 진료 순서
    
        Queue<Person> Q = new LinkedList<>();
        // 큐에 (아이디, 위험도) 세팅
        for (int i = 0; i < n; i++) {
            Q.add(new Person(i, arr[i])); // Q.add()는 Q.offer()와 기능적으로 동일
        }
        
        while (!Q.isEmpty()) {
            Person tmp = Q.poll(); // 일단 하나 꺼내고 그 값 저장
            for (Person x : Q) { // 큐를 스캔하면서
                if (x.priority > tmp.priority) { // 하나라도 tmp의 위험도보다 큰 위험도를 가진 요소가 있다면 큐에 다시 넣기
                    Q.offer(tmp);
                    tmp = null; // tmp 초기화
                    break;
                }
            }
            if (tmp != null) { // tmp가 null이 아니라는건 -> 위의 for문을 통과했다는 얘기. 진료받을 수 있는 환자.
                answer++;
                if (tmp.id == m) { // 아이디(순서)를 m과 비교 -> 같다면 우리가 찾던 그 환자
                    return answer; 
                }
            }
        }
        
        return answer; // 사실상 없어도 되지만 없애면 컴파일에러남.
    }
    
    public static void main(String[] args) {
        P05_08 T = new P05_08();
    
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

package Inflearn.section06_Sorting_Searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
// 정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.

// 좌표 (x, y) 형태의 클래스 : Point
// Point는 Comparable<Point>의 구현체임!
class Point implements Comparable<Point> {
    
    public int x;
    public int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // 이 방법은 그냥 암기해야함..!
    // 정렬 기준을 재정의 (원래 Point 클래스엔 compareTo 메소드가 있음)
    @Override
    public int compareTo(Point object) {
        
        // (이 메소드를 호출한 객체 == 매개변수로 넘어온 객체) 같다면
        if (this.x == object.x) {
            // x가 같다면 y값 기준으로 정렬
            return this.y - object.y;
        } else {
            // x가 다르다면 x값 기준으로 정렬
            return this.x - object.x;
        }
    }
    // this   -  object
    //  10    -    20   =  음수 --> 오름차순  (오름차순 기준으로 그냥 암기!)
    // object -   this
    //  10    -    20   =  음수 --> 내림차순
    
    // => 무조건 음수값이 리턴되도록 빼기 식 설정해야함! 그래야 그 기준으로 compareTo 메소드가 정렬해줌!
}

public class P06_07 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x, y));
        }
        
        Collections.sort(arr);
        // -> Comparable<Point>이라는 인터페이스를 통해서 Point라는 객체를 정렬함.
        // 이 때 정렬 기준은 compareTo 메소드.
        
        for (Point o : arr) {
            System.out.println(o.x + " " + o.y);
        }
    }
}
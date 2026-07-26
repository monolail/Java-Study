import java.util.*;

public class Ex11_01 {
    public static void main(String[] args) throws Exception {
        // 기본길이가 10인 ArrayList생성.
        ArrayList list1 = new ArrayList(10);
        list1.add(new Integer(5)); // Auto Boxing 자동 수행.
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));
        ArrayList list2 = new ArrayList(10);
        
        
        System.out.println(list1);
        System.out.println(list2);
        
        // Collection은 인터페이스, Collections는 유틸 클래스
        Collections.sort(list1);
        Collections.sort(list2);
        
        System.out.println("정렬 후 list1");
        System.out.println(list1);

        // indexOf 인덱스 위치 알아내기
        System.out.println(list1.indexOf(3));
        // 없다면 -1을 출력.
        System.out.println(list1.indexOf(4));

        // remove삭제
        list1.remove(4); // 값이 아닌 인덱스의 객체가 삭제
        System.out.println(list1); // 인덱스 4인 값 5가 삭제.
    }
}

import java.util.*;

class Tv{}
class Audio{}
public class Ex12_02 {
    public static void main(String[] args) {
        // Tv타입의 객체만 저장가능
        // Arraylist<Object>에서 Object를 Tv로 바꾼 것이다.
        ArrayList<Tv> list = new ArrayList<Tv>();
        
        list.add(new Tv());
        // list.add(new Audio()); // 에러 : 타입 불일치

        // List의 첫 요소를 꺼낸다.
        // Tv t = (Tv)list.get(0); 
        Tv t = list.get(0); // 형변환 생략 가능. 지네릭스를 사용했기 때문.

        System.out.println(t);
    }
    
}

import java.util.ArrayList;

public class Ex9_07 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(new Integer(100)); // list 객체만 추가가능
        list.add(100);
        // Integer i = list.get(0).intValue(); 
        Integer i = list.get(0); // list에 저장된 첫 번째 객체를 꺼낸다.
        
    }
    
}

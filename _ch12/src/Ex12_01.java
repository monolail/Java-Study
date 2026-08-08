import java.util.*;

public class Ex12_01 {
    public static void main(String[] args) throws Exception {
        //ArrayList list = new ArrayList();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        list.add(10);
        list.add(20);
        // 에러 : list.add("30");

        list.add(30); // 타입 체크 강화 : 지네릭스 덕분.

        // 컴파일 에러가 없다.
        // list.get(2)에서 30은 Object 타입으로 반환되므로 Integer 타입으로 형변환이 필요하다.
        Integer i = (Integer) list.get(2);

        // 실행 시 ClassCastException 발생
        // 형변환 에러. (실행시 발생하는 에러.)
        // 컴파일러의 한계.

        System.out.println(list);
    }
}

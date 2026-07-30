import java.util.*;

public class Ex11_13 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("김휘용", new Integer(90));
        map.put("정재민", new Integer(100));
        map.put("이상렬", new Integer(80));
        map.put("박민정", new Integer(90));
        map.put("오재욱", new Integer(85));

        Set set = map.entrySet();
        Iterator it = set.iterator();

        Collection values = map.values();
        it = values.iterator();

        int total = 0;

        while (it.hasNext()){
            int i = (int)it.next();
            total += i;
        }
        System.out.println("총점 : " + total);
        System.out.println("평균 : " + (float)total/set.size());
        System.out.println("최고 점수 : " + Collections.max(values));
        System.out.println("최저 점수 : " + Collections.min(values));

    }
}

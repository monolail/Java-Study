import java.util.*;

public class Ex11_08 {
    public static void main(String[] args) {
        Object[] objARR = {"1" , new Integer(1),"2","2","3","3","4","5","6"};
        Set set = new HashSet();

        for (int i=0;i<objARR.length;i++){
            System.out.println(objARR[i] + "="+set.add(objARR[i]));
        }
        // Hashsetㅇ 저장된 요소들 출력
        System.out.println(set);

        Iterator it = set.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}

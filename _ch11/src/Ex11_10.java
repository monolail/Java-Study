import java.util.*;

class Ex11_10 {
    public static void main(String[] args) {
        // TreeSet예제
        Set set = new TreeSet(new TestComp());

        // for (int i=0;set.size()<6;i++){
        //     int num = (int)(Math.random()*45)+ 1;        
        //     set.add(num);
        // }
        set.add(new Test());
        set.add(new Test());
        set.add(new Test());

        System.out.println(set);
    }
}

class Test {} // 비교 기준이 없다.

class TestComp implements Comparator {
    public int compare(Object o1, Object o2) {
        return -1;
    }
}
class Data1 {
    int value;
}

class Data2 {
    int value;
    
    Data2(){} // 기본 생성자

    Data2(int x) { // 매개변수가 있는 생성자
        value = x;
    }
}

public class Ex06_6 {
    public static void main(String[] args) {
        Data1 d1 = new Data1();
        d1.value = 10;
        System.out.println("d1.value : " + d1.value);

        Data2 d2 = new Data2(20);
        System.out.println("d2.value : " + d2.value);

    }
    
}

public class Ex9_01 {
    public static void main(String[] args)  {
        Value v1 = new Value(10);
        Value v2 = new Value(10);
    
        if (v1.equals(v2)) 
            System.out.println("V1과 V2는 같다");
        else
            System.out.println("V1과 V2는 다르다");
        

    }
}

class Value {
    int value;

    Value(int value) {
        this.value = value;
    }

    public boolean equals(Object obj) {
        // return this == obj : 주소비교 -> 서로다른 객체는 항상 거짓
        // 참조변수의 형변환 전에는 반드시 instanceof로 확인해야한다.
        
        Value v = (Value)obj; // obj를 value로 형변환
        return this.value == v.value;
    }
}
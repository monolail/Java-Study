import java.util.function.Function;
import java.util.function.Supplier;

class Ex14_04 {
    public static void main(String[] args) {
        Function<Integer, Integer> f1 = x -> x * x;
        System.out.println(f1.apply(5));

        Supplier<MyClass> s = () -> new MyClass();
        
        MyClass mc = s.get();
        System.out.println(mc.getValue());
    }
}

class MyClass{
    int iv;
    MyClass(){
        this.iv = 100;
    }
    public int getValue() {
        return iv;
    }
}
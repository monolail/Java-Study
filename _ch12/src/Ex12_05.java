import java.util.*;

class Fruit{
    public String toString() {
        return "Fruit";
    }
}

class Apple extends Fruit{
    public String toString() {
        return "Apple";
    }
}

class Grape extends Fruit{
    public String toString() {
        return "Grape";
    }
}

class Juice{
    String name;
    Juice(String name){
        this.name = name + "Juice";
    }
    public String toString() {
        return name;
    }
}

class Juicer {
    static Juice makeJuice(Fruitbox<? extends Fruit> box) {
        String tmp = "";
        for(Fruit f : box.getList())
            tmp += f + " ";
        return new Juice(tmp);
    }
}

public class Ex12_05 {
    public static void main(String[] args) {
        Box b = null;
        Box<String> b1 = null;

        // b = (Box)bstr; // Box<string> -> Box 가능 but 경고
        // bstr = (Box<String>)b1; // Box -> Box<string> 가능 but 경고

        // 와일드 카드가 사용된 제네릭 타입 형변환 가능.
        Fruitbox<? extends Fruit> fruitBox = new Fruitbox<Fruit>();
        Fruitbox<? extends Apple> appleBox = new Fruitbox<Apple>();
        // Fruitbox<Apple> -> Fruitbox<? extends Fruit> 가능

        // Fruitbox<? extends Fruit> -> Fruitbox<Apple> 가능하지만 경고 발생.
    
    }
}

class Fruitbox<T extends Fruit> extends Box<T> {}

class Box<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item) { list.add(item); }
    T get(int i) { return list.get(i); }
    ArrayList<T> getList() { return list; }
    int size() { return list.size(); }
    public String toString() { return list.toString(); }
}
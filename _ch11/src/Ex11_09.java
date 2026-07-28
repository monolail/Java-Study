import java.util.*;

public class Ex11_09 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");
        set.add(new Person("David",10));
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return age == p.age && Objects.equals(name, p.name);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(name, age);
    }
}

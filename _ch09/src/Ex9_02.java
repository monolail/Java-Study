public class Ex9_02 {
    public static void main(String[] args) {
        Person p1 = new Person(8011081111222L);
        Person p2 = new Person(8011081111222L);
    
        if(p1.equals(p2))
            System.out.println("p1과 p2는 같은 사람이다.");
    
        else 
            System.out.println("p1과 p2는 다른 사람이다.");
    
    }
}

class Person{
    long id;

    public boolean equals(Object obj) {
        if(!(obj instanceof Person)) {
            return false;
        }
        Person p = (Person)obj;
        return this.id == p.id;
    }

    Person(long id) {
        this.id = id;
    }

    
}

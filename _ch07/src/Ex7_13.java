class A{
    public void method (I i) {
        i.method();
    }
}

// 클래스로 할 경우 
// class B {
//     public void method() {
//         System.out.println("B클래스의 메서드");
//     }
// }

// 인터페이스로 할 경우 (선택과 구현을 분리하여 코드 변형에 유리함)
interface  I {
    public void method();
}

class B implements I{
    public void method() {
        System.out.println("B클래스의 메서드");
    }
}


class C implements I {
    public void method() {
        System.out.println("C클래스의 메서드");
    }
}

public class Ex7_13 {
    public static void main(String[] args) {
        A a = new A();
        a.method(new C()); // A가 B를 사용 (의존)
    }
}

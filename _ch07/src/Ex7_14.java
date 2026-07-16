// inner class

class AAA {
    int i = 100;
    BBB b = new BBB();

    class BBB{ // BBB는 AAA의 내부 클래스
        
        // 장점
        // 1. 캡슐화를 통한 간단함
        // 객체 생성없이 외부 클래스의 멤버 접근 가능
        void method() {
            // AAA a = new AAA();
            // System.out.println(a.i);
            System.out.println(i);
        }
    }
}

// class CCC {
//     BBB b = new BBB();

// }

public class Ex7_14 {
    public static void main(String[] args){
        // BBB 생성 불가능 : 이제 내부이기에 AAA를 통해 객체 생성
        // BBB b = new BBB();
        // b.method();
        AAA a = new AAA();
        a.b.method();
    }
}

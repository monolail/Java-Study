class parent{
    void print(){
        System.out.println("parent");
    }
}

class child extends parent{
    // void print(){
    //     System.out.println("child");
    // }
}

public class Ex7_03 {
    public static void main(String[] args) {
        //오버라이딩
        // child 클래스에서 주석처리된 부분을 제거하면 오버라이딩이 된다.
        // 이때, child클래스에서의 구현부에서 정의된 내용이 출력된다.
        parent p = new parent();
        child c = new child();

        p.print();
        c.print();
    }
}

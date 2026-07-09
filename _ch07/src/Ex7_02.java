class Point{
    int x;
    int y;
}

class Circle extends Point{
    int r;
}

class Circle2{
    Point p = new Point();
    int r;
}
// 두 결과는 같다.
// 클래스간의 관계는 상속과 포함으로 나눌 수 있다. 상속은 is-a 관계, 포함은 has-a 관계라고 한다.
public class Ex7_02 {
    public static void main(String[] args){
        Circle c = new Circle();
        c.x = 10;
        c.y = 20;
        c.r = 5;

        System.out.println("원점은 (" + c.x + "," + c.y + ") 이고, 반지름은 " + c.r + " 입니다.");

        System.out.println("=====");

        Circle2 c2 = new Circle2();

        c2.p.x = 10;
        c2.p.y = 20;
        c2.r = 5;

        System.out.println("원점은 (" + c2.p.x + "," + c2.p.y + ") 이고, 반지름은 " + c2.r + " 입니다.");
    }
}


// 참조변수 형변환
public class Ex7_07 {

    public static void main(String[] args) {
        Car car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null; // 실제 인스턴스가 무엇인지가 중요하다.

        fe.water();
        car = fe; // car = (Car)fe;에서 형변환이 생략
        // Car.water(); 안됨. - Car 타입의 참조변수는 water()를 사용 불가능.

        fe2= (FireEngine)car; // 조상 -> 자손으로 형변환
        Car car2 = (Car)fe2; // 자손 -> 조상으로 형변환
        // 객체가 없어도 형변환에는 아무런 문제가 없다.
        fe2.water();

    }
    
}

// 부모 클래스
class Car{
    String color;
    int door;

    void drive(){
        System.out.println("Drive. Brrrrr~!!");

    }

    void stop(){
        System.out.println("Stop!!");

    }


}

class FireEngine extends Car {
    void water(){
        System.out.println("Water!!");
    }
}
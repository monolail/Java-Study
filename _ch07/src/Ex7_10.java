// 추상 클래스 / 메서드
// abstract를 꼭 붙여야한다.


abstract class Player { // 추상 클래스
    abstract void play (int pos); // 추상 메서드
    abstract void stop(); // 추상 메서드 (선언부만 있고 구현부는 없는 메서드)
}

// 추상 클래스는 상속을 통해 완성해야 객체 생성가능.
class AudioPlayer extends Player{
    void play(int pos){
        System.out.println("위치는 " + pos +"이다.");
    }
    // 만약 stop()을 구현하지 않을 경우 사용이 불가하다.
    void stop(){
        System.out.println("재생을 멈춥니다.");
    }
}

public class Ex7_10 {
    public static void main(String[] args) {
        AudioPlayer ap = new AudioPlayer();
        ap.play(100);
        ap.stop();
    }    
}

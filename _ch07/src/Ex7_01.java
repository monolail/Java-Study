class Tv{
    boolean power;
    int channel;

    void power() {power = !power;}
    void channelUp() {channel++;}
    void channelDown() {channel--;}

}

// 상속 클래스
class SmartTv extends Tv {
    boolean caption;
    void displayCaption(String text) {
        if(caption) {
            System.out.println(text);
        }
    }
}
// 상속 관계를 이용한 클래스의 활용
// 자식 클래스는 부모 클래스의 멤버를 모두 상속받는다. 따라서 자식 클래스의 객체를 생성하면 부모 클래스의 멤버도 사용할 수 있다. 
public class Ex7_01 {
    public static void main(String[] args) throws Exception {
        SmartTv stv = new SmartTv();
        stv.channel = 10;
        stv.channelUp();
        System.out.println("현재 채널은 " + stv.channel + " 입니다.");
        stv.caption = true;
        stv.displayCaption("Hello, World!");
        stv.caption = false;
    }
}

// private을 통해 캡슐화 및 접근제어
// 외부로부터 데이터 보호 -> 간접적인 접근을 유도한다.

class Time {
    private int hour;
    private int minute;
    private int second;

    public void setHour(int hour){
        if (hour<0|| hour>23) {return;}

        this.hour = hour;
    }
    
    public int getHour(){return hour;};

}

public class Ex7_06 {
    public static void main(String[] args) {
        Time t = new Time();
        // t.hour = 100;
        t.setHour(21);
        System.out.println(t.getHour());
        t.setHour(100);
        System.out.println(t.getHour());


    }
}

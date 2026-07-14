abstract  class Unit2{
    int x, y;
    public abstract void move(int x, int y);
    void stop(){System.out.println("멈춥니다.");}
}

interface Fightable {
    void move(int x, int y); // public abstract가 생략.
    void attack(Fightable f); // public abstract가 생략.
}

class Fighter extends Unit2 implements Fightable {
    
    // public 명시해야한다.
    // 오버라이딩 규칙 : 조상(public)보다 접근 제어자가 범위가 좁으면 안된다.
    public void move(int x, int y){
        System.out.println("["+x+","+y+"]로 이동");
    }
    public void attack(Fightable f){
        System.out.println(f+"를 공격");
    }

    Fightable getFightable(){
        Fightable f = new Fighter(); // Fighter를 생성해서 반환
        return f;
    }
}

public class Ex7_12 {
    public static void main(String[] args) {
        Fighter f = new Fighter();
        // Unit2 클래스는 사용 불가.
        // Fightable 인터페이스는 사용이 가능하다.
        f.move(100,200);
        f.attack(new Fighter());      
        f.stop();  
        Fightable f2 = f.getFightable();
        f2.move(230, 100);
    }
}

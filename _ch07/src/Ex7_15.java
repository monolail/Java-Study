import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// 익명 클래스
public class Ex7_15 {
    public static void main(String[] args) { // 클래스 정의와 객체 생성을 동시에
        
        Button b = new Button("Start");
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("액션 발생!!");
            }
        });
         
    }
}
    


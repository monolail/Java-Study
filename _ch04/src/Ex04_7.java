import java.util.*;

public class Ex04_7 {
    
    public static void main(String[] args){

        int answer = (int)(Math.random()*100)+1;

        int input = 0;
        System.out.println("answer = "+answer);
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("1~100 사이의 정수를 입력하세요.>");
            input = sc.nextInt();

            if(input>answer){
                System.out.println("더 작은 수를 입력하세요.");
            }else if(input<answer){
                System.out.println("더 큰 수를 입력하세요.");
            }

        } while (input != answer);

        System.out.println("정답입니다.");
    }
}
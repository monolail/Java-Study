import java.util.*;

public class Ex04_8 {
    
    public static void main(String[] args){

        // break Loop name
        System.out.println("break Loop name");
        System.out.println("Loop1까지 break");

        Loop1 : for(int i=2; i<=9; i++){
            for(int j=1; j<=9; j++){
                if(j==5)
                    break Loop1;
                System.out.println(i+" * "+j+" = "+(i*j));
            }
            System.out.println();
        }
        // Loop2
        
        System.out.println("Loop2 하나만 반복문 break");
        for(int i=2; i<=9; i++){
            for(int j=1; j<=9; j++){
                if(j==5)
                    break ;
                System.out.println(i+" * "+j+" = "+(i*j));
            }
            System.out.println();
        }

    }
}

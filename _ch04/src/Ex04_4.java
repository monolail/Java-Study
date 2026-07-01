public class Ex04_4 {

    public static void main(String[] args) {
        
        int num = 0;

        for (int i = 1; i<=5; i++){
            System.out.println((int)(Math.random()*6));

        }

        System.out.println(Math.random()); // 0.0<=x<1.0
        System.out.println(Math.random()*10); // 0.0<=x<10.0
        System.out.println(Math.random()*2 - 1); // -1.0<=x<1.0

        
    }
    
}

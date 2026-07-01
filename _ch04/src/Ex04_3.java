import java.util.Scanner;

public class Ex04_3 {

    public static void main(String[] args){

        System.out.println("Enter the month number: ");
        Scanner scan = new Scanner(System.in);
        int month = scan.nextInt();

        switch (month){
            case 12:
            case 1:
            case 2:
                System.out.println("It is winter");
                break;
            case 3 :
            case 4:
            case 5:
                System.out.println("It is spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("It is summer");
                break;
            default :
                System.out.println("It is fall");
                break;
                


        }

    }
    
}

import java.util.Scanner;

public class Ex04_2 {
    public static void main(String[] args) {
        int score = 0;
        char grade = ' ';
        char opt = '0';

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your score: ");
        score = scan.nextInt();

        System.out.printf("your score is %d \n", score);

        if (score >= 90) {
            grade = 'A';
            if (score >= 98) opt = '+';
            else if (score < 94) opt = '-';
        } else if (score >= 80) {
            grade = 'B';
            if (score >= 88) opt = '+';
            else if (score < 84) opt = '-';
        } else {
            grade = 'C';
        }

        System.out.printf("your grade is %c", grade);

    }
}

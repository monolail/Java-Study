import java.util.Scanner;

public class Ex04_1 {
    public static void main(String[] args) {
        int score = 0;
        char grade = ' ';
        System.out.print("Enter your score: ");
        Scanner scan = new Scanner(System.in);

        score = scan.nextInt();
        

        if (score >= 90) grade = 'A';
        else if (score >=80) grade = 'B';
        else if (score >=80) grade = 'C';
        else grade = 'D';

        System.out.printf("your grade is %c",grade);
    }
}

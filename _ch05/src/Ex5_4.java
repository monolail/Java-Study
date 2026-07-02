import java.util.Arrays;
import java.util.Scanner;

public class Ex5_4 {

    public static void main(String[] args) throws Exception {
        String [] names = {"홍길동", "이순신", "강감찬", "을지문덕", "김유신"};
        System.out.println(Arrays.toString(names));
    


        // 간단 프로그램

        String[] strArr = {"가위","바위", "보"};
        System.out.println(Arrays.toString(strArr));
        int wincount = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("사용자의 생각 : {가위,바위,보} 순서대로 1,2,3이라는 숫자를 입력하십시오.\n");

        for (int i = 0; i < 10; i++) {
            System.out.print("안내면 진거 가위바위보!! : \n");
            int userInput = sc.nextInt();
            int userIndex = userInput - 1;
            System.out.println("사용자의 생각 : " + strArr[userIndex]);

            int tmp = (int)(Math.random() * 3); // 0~2 사이의 난수 발생
            System.out.print("컴퓨터의 생각 : "+strArr[tmp]+"\n");

            if (strArr[userIndex].equals(strArr[tmp])){
                System.out.println("비겼습니다.");
            }
            else if (((strArr[userIndex].equals("가위")) && (strArr[tmp].equals("바위"))) ||
                    ((strArr[userIndex].equals("바위")) && (strArr[tmp].equals("보"))) ||
                    ((strArr[userIndex].equals("보")) && (strArr[tmp].equals("가위")))){
                        System.out.println("졌습니다.");

                    }
            else {
                wincount += 1;

                System.out.println("이겼습니다.");

            }
        }
        System.out.println("승리 횟수 : " + wincount);
    
    }
    
    
}

import java.util.Arrays; // ctrl + shift + o -> array 관련 클래스 import

public class Ex5_2 {
        public static void main(String[] args) throws Exception {
        int[] score; // 배열 score 선언(참조 변수)
        score = new int[]{100, 90, 80, 70, 60}; // 배열 생성 (int 타입의 5개짜리 배열)
        
        System.out.println(score.length); // 배열의 길이 출력
        
        for (int i = 0; i < score.length; i++) {
            System.out.println("score[" + i + "] : " + score[i]);
        }

        System.out.println(score); // 배열의 주소값 출력 
        System.out.println(Arrays.toString(score)); // 배열의 내용 출력
    
        char[] chArr = {'a', 'b', 'c', 'd', 'e'}; // char 타입 배열 생성
        System.out.println(chArr); //1. char 배열은 배열의 내용 출력
        // char 배열은 문자열처럼 출력되기 때문에 배열의 주소값이 아닌 배열의 내용이 출력됨
        
        System.out.println(Arrays.toString(chArr)); //2. char 배열은 배열의 내용 출력
    }
}

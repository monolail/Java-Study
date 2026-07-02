public class Ex5_1 {
    public static void main(String[] args) throws Exception {
        int[] score; // 배열 score 선언(참조 변수)
        score = new int[5]; // 배열 생성 (int 타입의 5개짜리 배열)

        // int[] score = new int[5]; // 배열 생성 (int 타입의 5개짜리 배열)
        
        score[0] = 100;
        // score배열에서 0번째 인덱스는 변수처럼 저장
        // score 배열의 초기값은 0으로 초기화 되어 있음
        System.out.println("score[0] : " + score[0]);
        System.out.println("score[1] : " + score[1]);
        System.out.println("score[2] : " + score[2]);
        System.out.println("score[3] : " + score[3]);
        System.out.println("score[4] : " + score[4]);

        
    }
}

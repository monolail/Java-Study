public class Ex5_3 {
    public static void main(String[] args) throws Exception {
        int[] score; // 배열 생성 (int 타입의 5개짜리 배열)
        
        score = new int[]{100, 90, 80, 70, 60}; // 배열 생성 (int 타입의 5개짜리 배열)

        int sum = 0;
        for (int i=0; i<score.length;i++){

            sum+= score[i];

        }

        System.out.println("총합 : " + sum);
        System.out.println("평균 :" + (double)sum / score.length);

        // 최대 / 최솟값
        int max = score[0];
        int min = score[0];

        for (int i=0; i<score.length; i++){
            if (max < score[i]){
                max = score[i];
            }

            if (min > score[i]){
                min = score[i];
            }


        }

        System.out.println("최대값 : " + max);
        System.out.println("최소값 : " + min);

    }
    
}

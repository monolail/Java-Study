public class Ex5_5 {
    public static void main(String[] args) {
        
        // 2차원 배열
        int[][] score = {

            {100, 90, 80, 70, 60},
            {90, 80, 70, 60, 50},
            {80, 70, 60, 50, 40}

        };
        int num = 0;
        int sum = 0;

        // score.length : 2차원 배열의 행의 길이
        // score[i].length : 2차원 배열의 i번째 행의 열의 길이
        for (int i = 0; i < score.length;i++){
            for (int j =0; j<score[i].length;j++){
                sum += score[i][j];
                num +=1;
                System.out.println("score["+i+"]["+j+"] : " + score[i][j]);
            }
        }
        int mean = sum/num;
        System.out.println("sum is "+sum);
        System.out.println("total mean is "+mean);
    }
}

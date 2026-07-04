import java.util.Arrays;

public class Ex5_8 {

    public static void main(String[] args){
        // 배열의 메소드
        int[] arr = {1, 4, 5, 2, 3};
        System.out.println("배열의 길이: " + arr.length);

        // 배열을 정렬
        System.out.println("정렬 전: " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("정렬 후: " + Arrays.toString(arr));

        String[][] str2DD = {{"aaa", "bbb"}, {"AAA", "BBB"}};
        String[][] str2DD2 = {{"aaa", "bbb"}, {"AAA", "BBB"}};
        // 2차원 배열 출력
        System.out.println("2차원 배열 출력: " + Arrays.deepToString(str2DD));
        
        // 2차원 배열 비교
        System.out.println("2차원 배열 비교: " + Arrays.deepEquals(str2DD, str2DD2));
        // System.out.println("2차원 배열 비교: " + Arrays.equals(str2DD, str2DD2)); // false
        // 이유 : Arrays.equals()는 1차원 배열의 요소를 비교할 때만 사용되며, 2차원 배열에서는 각 요소가 또 다른 배열이기 때문에 참조 주소를 비교하게 되어 false를 반환합니다. 반면, Arrays.deepEquals()는 2차원 배열의 각 요소를 재귀적으로 비교하여 실제 값이 같은지 확인합니다.


        // 배열 복사
        // copyof() : 배열을 복사하여 새로운 배열을 생성 (arr이름, 복사할 길이)
        int [] arr2 = Arrays.copyOf(arr, 3);
        System.out.println("배열 복사: " + Arrays.toString(arr2));

        // copyofRange() : 배열의 일부를 복사하여 새로운 배열을 생성 (arr이름, 시작인덱스, 끝인덱스)
        int [] arr3 = Arrays.copyOfRange(arr, 1, 4); // 1~3까지 복사
        System.out.println("배열 복사: " + Arrays.toString(arr3));
    }
    
}


public class Ex5_7 {

    // String 주요 메서드

    public static void main(String[] args){
        // 01234
        String str = "ABCDE";

        char ch = str.charAt(4);
        System.out.println("ch : " + ch);

        String str2 = str.substring(1,4);
        // (자바는 0부터 시작)시작 : 1, 끝 : 4-1 = 3
        System.out.println(str2);


    }
    
}

// 예외처리 : try - catch

public class Ex8_02 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);

        try {
            System.out.println(3);
            System.out.println(0/0);
            System.out.println(args[0]); // ArrayIndexOutofRange : 인덱스 범위를 벗어남.
            System.out.println(4); // 실행되지 않는다.
            // 예외 후의 문장은 실행되지 않는다.
        } catch (ArithmeticException ae){
                System.out.println("숫자 계산 불과");

        } catch (ArrayIndexOutOfBoundsException Ie){
            System.out.println("인덱스 에러.");
        } catch (Exception e) {
            System.out.println("예외발생");
        }
        System.out.println(6);
    } // main 메서드 끝
    
}

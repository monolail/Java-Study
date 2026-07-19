

public class Ex8_03 {
    public static void main(String[] args) {
        try {
            throw new Exception(); // Exception을 고의로 발생시킨다.
        } catch (Exception e) {
        
        }
        // RuntimeException은 컴파일이 아니어도 예외처리 가능.
        throw new RuntimeException();
    }
}

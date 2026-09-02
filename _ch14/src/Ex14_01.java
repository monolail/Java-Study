public class Ex14_01 {
    public static void main(String[] args) throws Exception {
        // MyFunction2 obj = (a, b) -> a > b ? a : b; // 람다식 , 익명객체
        // MyFunction2 f = new MyFunction2() {
        //     public int max(int a, int b) {
        //         return a > b ? a : b;
        //     }
        // };

        MyFunction2 f = (a, b) -> a > b ? a : b;

        int value = f.max(3,5); // 5; // 익명객체의 메서드 호출
        // obj는 Object 타입이므로 max() 메서드를 호출할 수 없다. 따라서 obj를 익명객체로 형변환해야 한다.
    
        System.out.println(value);
    }

}
// 함수형 인터페이스 -> 단 하나의 추상 메서드만 가져야한다.
@FunctionalInterface
interface MyFunction2 {
    
    public abstract int max(int a, int b);
}
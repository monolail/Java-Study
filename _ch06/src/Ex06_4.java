public class Ex06_4 {
    public static void main(String args[]){

        MyMath mm = new MyMath();
        long result1 = mm.add(5L, 3L); // 5L과 3L은 long타입의 리터럴이다.
        long result2 = mm.subtract(5L,3L);
        long result3 = mm.multiply(5L,3L);
        double result4 = mm.divide(5.0,3.0);
        long result5 = mm.maxgap(5L,6L);



        System.out.println("The result is: " + result1);
        System.out.println("The result is: " + result2);
        System.out.println("The result is: " + result3);
        System.out.println("The result is: " + result4);
        System.out.println("The result is: " + result5);
    }
    
}

class MyMath { // method는 클래스 영역에서만 정의 가능.
    long add(long a, long b){
        return a+b;
    }

    long subtract(long a, long b){
        return a-b;
    }

    long multiply(long a, long b){
        return a*b;
    }

    double divide(double a, double b){
        // 소수점 3자리까지 반영
        // 방법 설명
        // 1. a/b를 계산한다.
        // 2. 계산된 값을 100.0을 곱한다.
        // 3. Math.round()를 이용하여 반올림한다.
        // 4. 다시 100.0으로 나누어 소수점 2자리까지 표현한다.
        // Math.round()는 소수점 첫째자리에서 반올림을 수행하므로, 소수점 2자리까지 표현하기 위해서는 100.0을 곱하고 나누는 과정을 거쳐야 한다.
        return Math.round((a/b) * 100.0) / 100.0;
    }

    long maxgap(long a, long b){

        return a > b ? a : b;

    }

}
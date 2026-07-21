public class Ex9_04 {
    public static void main(String[] args) {
        int ival = 100;

        String strval = ival + ""; // 숫자를 String으로 변환

        double dval = 200.0;
        String strval2 = dval + "";

        double sum = Integer.valueOf("+"+strval) + Double.parseDouble(strval2);
        double sum2 = Integer.valueOf(strval) + Double.valueOf(strval2);

        System.out.println("첫 번째 : " + sum);
        System.out.println("두 번째 : " + sum2);

    }
}

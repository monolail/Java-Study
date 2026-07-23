import java.text.*;

public class Ex10_03 {
    public static void main(String[] args){
        DecimalFormat df = new DecimalFormat("#,###.##");

        try {
            Number num = df.parse("1,234,567,89");
            System.out.print("1,234,567,89" + " -> ");

            double d = num.doubleValue();
            System.out.println(d);
        } catch(Exception e){

        }
    }
}

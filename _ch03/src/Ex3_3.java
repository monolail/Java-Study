public class Ex3_3 {
    public static void main(String[] args) throws Exception {
        int a = 1_000_000;
        int b = 2_000_000;

        long c = (long)a*b; // 

        System.out.println(c); 
        // 형변환 없이 : -1454759936
        // 형변환 시 : 2000000000000

        double pi = 3.141592;

        System.out.println(pi);
        System.out.println(pi*1000);
        System.out.println(Math.round(pi*1000));
        System.out.println(Math.round(pi*1000)/1000); // 3
        System.out.println((double)Math.round(pi*1000)/1000); // 3.142

            
    }
}

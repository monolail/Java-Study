public class Ex3_1 {
    public static void main(String[] args) throws Exception {
        int i = 5;
        

        int j = i; // 후위
        i++;
        System.out.println("j=i++; : i = " + i + ", j =" + j );

        i = 5;
        j = 0;

        i++;
        j = i; // 전위
        System.out.println("j=i++; : i = " + i + ", j =" + j );


    }
}

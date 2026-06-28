public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(3+5);
        System.out.println(10/3);
        System.out.println(10.0/3);

        System.out.printf("%d%n",15);
        System.out.printf("%o%n",15);
        System.out.printf("%x%n",15);
        System.out.printf("%#o%n",15);
        System.out.printf("%#x%n",15);

        System.out.printf("%s%n",Integer.toBinaryString(15));

        System.out.printf("[%5d]%n",10);
        System.out.printf("[%-5d]%n",10); 
        // ctrl + alt + shift + down : 행단위 복사
    }
}

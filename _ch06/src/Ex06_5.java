class Ex06_5 {
    public static void main(String[] args) {

        MyMath3 mm = new MyMath3();
        
        System.out.println(mm.add(3, 4));
        System.out.println(mm.add(3, 4L));
        System.out.println(mm.add(3.0f, 4.0f));
        System.out.println(mm.add(new int[]{1, 2, 3, 4, 5}));
    }
}
// Method Overloading 
class MyMath3 {
    int add(int a, int b){
        System.out.println("int add(int a, int b) called");
        return a + b;
    }

    long add(int a, long b){
        System.out.println("long add(int a, long b) called");
        return a + b;
    }

    float add(float a, float b){
        System.out.println("float add(float a, float b) called");
        return a + b;
    }

    int add(int[] a){
        System.out.println("int add(int[] a) called");
        int result = 0;
        for(int i=0; i<a.length; i++){
            result += a[i];
        }
        return result;
    }


}
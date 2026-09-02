interface MyFuunction {
    void run();
}

class Ex14_02{
    static void execute(MyFuunction f){
        f.run();
    }
    static MyFuunction getMyFuunction(){
        MyFuunction f = () -> System.out.println("f3.run()");
        return f;
    }
    public static void main(String[] args) {
       
        MyFuunction f1 = () -> System.out.println("f1.run()");
        
        MyFuunction f2 = new MyFuunction() {
            public void run() {
                System.out.println("f2.run()");
            }
        };

        MyFuunction f3 = getMyFuunction();

        f1.run();
        f2.run();
        f3.run();

        execute(f1);
        execute( () -> System.out.println("run()"));
    }
}
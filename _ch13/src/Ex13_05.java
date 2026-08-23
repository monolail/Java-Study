class Ex13_05{
    public static void main(String args[]) {
        ThreadEx5_1 th1 = new ThreadEx5_1();
        ThreadEx5_2 th2 = new ThreadEx5_2();

        th1.setPriority(5);
        th2.setPriority(7);

        System.out.println("Priority of th1(-) : "+ th1.getPriority());
        System.out.println("Priority of th2(|) : "+ th2.getPriority());
        th1.start();
        th2.start();
        
        
    }
}

class ThreadEx5_1 extends Thread {
    public void run() {
        for (int i =0 ; i < 300; i++) {
            System.out.print("-");
            for (int x =0; x<10000000; x++);
        }
    }
}

class ThreadEx5_2 extends Thread {
    public void run() {
        for (int i =0 ; i < 300; i++) {
            System.out.print("|");
            for (int x =0; x<10000000; x++);
        }
    }
}

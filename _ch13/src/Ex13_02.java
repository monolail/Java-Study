class Ex13_02 {
    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx2_1 th1 = new ThreadEx2_1();
        ThreadEx2_2 th2 = new ThreadEx2_2();
        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {}
    
        System.out.print("소요시간 : " + (System.currentTimeMillis() - startTime));
    }
}

class ThreadEx2_1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(new String("-"));
        }
    }
}

class ThreadEx2_2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(new String("|"));
        }
    }
}

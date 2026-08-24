class Ex13_07 {
    public static void main(String[] args) {
        ThreadEx7_1 th1 = new ThreadEx7_1();
        ThreadEx7_2 th2 = new ThreadEx7_2();

        th1.start();
        th2.start();

        try {
            // th1.sleep(2000); 과 같이 인스턴스로 호출해도 실제로 잠드는 것은 이 코드를 호출하는 main 쓰레드임
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
        System.out.print("<<main 종료>>");
    }
}

class ThreadEx7_1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
        System.out.print("<<th1 종료>>");
    }
}

class ThreadEx7_2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
        }
        System.out.print("<<th2 종료>>");
    }
}

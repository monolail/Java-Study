public class Ex13_01 {
    public static void main(String[] args) throws Exception {
        ThreadEx1_1 t1 = new ThreadEx1_1();

        Runnable r = new ThreadEx1_2();
        Thread t2 = new Thread(r); // 생성자 Thread

        t1.start(); // 0을 출력
        t2.start(); // 1을 출력
        // 왜 0이 항상 먼저가 아닌가?
        // 그것은 OS가 결정. -> 임의로 수정할 수 없다.
    }
}


class ThreadEx1_1 extends Thread { // Thread클래스 상속해서 쓰레드 구현
    public void run() {
        for(int i=0;i<5;i++) {
            System.out.println(getName()); // 조상 Thread의 getName호출
        }
    }
}

class ThreadEx1_2 implements Runnable { // Runnable인터페이스를 구현해서 쓰레드 구현
    public void run() { // 쓰레드가 수행할 작업을 작성
        for (int i = 0; i < 5; i++) { 
            // Thread.cuurentThread() - 현재 실행중인 Thread를 반환.
            System.out.println(Thread.currentThread().getName());
        }
    }
}
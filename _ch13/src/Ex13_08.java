import javax.swing.JOptionPane;

class Ex13_08 {
    public static void main(String[] args) throws Exception {
        ThreadEx8_1 th1 = new ThreadEx8_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");
        th1.interrupt(); // th1에 인터럽트 신호 전송

        System.out.println("isInterrupted(): " + th1.isInterrupted()); // true
    }
}

class ThreadEx8_1 extends Thread {
    public void run() {
        int i = 10;
        while (i != 0 && !isInterrupted()) {
            System.out.println(i--);
            for (long x = 0; x < 250000000L; x++); // 시간 지연
        }
        System.out.print("th1 종료");
    }
}

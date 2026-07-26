import java.util.*;

public class Ex11_04 {
    static Queue qe = new LinkedList();
    static final int MAX_SIZE = 5;

    public static void main(String[] args)  {
        while(true){
            System.out.println(">>");
            try {
                Scanner s = new Scanner(System.in);
                String input = s.nextLine().trim();

                if ("".equals(input)) continue;

                if (input.equalsIgnoreCase("q")){
                    System.exit(0);
                } else if (input.equalsIgnoreCase("help")) {
                    System.out.println("help - 도움말.");
                    System.out.println("q 또는 Q - 프로그램 종료.");
                    System.out.println("history - 최근 이력.");
                } else if (input.equalsIgnoreCase("history")) {
                    save(input);
                    LinkedList list = (LinkedList)qe;

                    for (int i = 0; i < list.size(); i++){
                        System.out.println((i+1)+"."+list.get(i));
                    }
                } else {
                    save(input);
                }
            } catch (Exception e) {
                System.out.println("입력 오류");
            }
        }
    }

    static void save(String input) {
        if(!"".equals(input)){
            qe.offer(input);
        }

        if (qe.size()> MAX_SIZE) {
            qe.remove();
        }
    }
}

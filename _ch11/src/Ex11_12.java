import java.util.*;

public class Ex11_12 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("MYID", "1234");
        map.put("asdf", "1111");
        map.put("asdf", "1234");

        Scanner s = new Scanner(System.in); // 화면으로 부터 라인단위로 입력.

        while(true) {
            System.out.println("id 및 password를 입력하시오.");
            System.out.println("id : ");
            String id = s.nextLine().trim();

            System.out.println("password : ");
            String password = s.nextLine().trim();
            
            if (!map.containsKey(id)) {
                System.out.println("입력한 id가 존재하지 않는다. 다시 입력하라. ");
                continue;
            
            }

            if (!(map.get(id)).equals(password)) {
                System.out.println("입력한 비밀번호가 일치하지 않는다. 다시 입력하라. ");
                
            
            } else {
                System.out.println("축하합니다. 로그인 되셨습니다. ");
                break;
            }

            
        }
    }
}

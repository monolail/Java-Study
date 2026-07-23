// Calendar 예제1
import java.util.Calendar;

public class Ex10_01 {
    public static void main(String[] args) throws Exception {
        Calendar today = Calendar.getInstance(); // Calendar 객체 생성
    
        System.out.println(today.get((Calendar.MONTH))+1); // Month는 0~11 즉 0은 1월, 11은 12월이다.
        System.out.println(today.get(Calendar.YEAR)); 
        System.out.println(today.get(Calendar.WEEK_OF_MONTH)); 
        System.out.println(today.get(Calendar.WEEK_OF_YEAR));

        //Date와 DAY_OF_MONTH는 같다.

        System.out.println(today.get(Calendar.DATE)); 
        System.out.println(today.get(Calendar.DAY_OF_MONTH)); 
        
        // set()을 통한, 시간 지정하기.
        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        
        date1.set(2019,3,20); // 2019년 3월 20일로 설정.
        System.out.println(toString(date1));
    }

    static String toString(Calendar c) {
        if (c == null) return "";
        return c.get(Calendar.YEAR) + "년 "
                + (c.get(Calendar.MONTH) + 1) + "월 "
                + c.get(Calendar.DATE) + "일";
    }
}

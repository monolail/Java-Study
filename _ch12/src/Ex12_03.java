import java.util.*;

public class Ex12_03 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("홍길동", 1, 1, 90, 80, 70));
        list.add(new Student("김철수", 1, 2, 85, 75, 65));
        list.add(new Student("이영희", 2, 1, 95, 85, 75));

        //    Iterator<Student> it = list.iterator();
        Iterator it = list.iterator(); // 지네릭스를 사용하지 않으면 형변환 필요.
        while(it.hasNext()) {
        // Student s = (Student)it.next(); // 지네릭스 사용하지 않으면 형변환.
        // Student s = it.next();
            System.out.println(((Student)it.next()).name); // 지네릭스를 사용하지 않으면 형변환 필요.
        //     System.out.println(it.next().name);
        }

        //HashMap
        HashMap<String, Student> map = new HashMap<String, Student>();
        map.put("1-1", new Student("홍길동", 1, 1, 90, 80, 70));
        map.put("1-2", new Student("김철수", 1, 2, 85, 75, 65));
        map.put("2-1", new Student("이영희", 2, 1, 95, 85, 75));
        //   Iterator<String> it2 = map.keySet().iterator();
        System.out.println(map);
    }

}

class Student {
    String name = "";
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    public Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }



}
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // 실행 시에 리플렉션으로 참조할 수 있도록 설정
@interface DateTime {
    String yymmdd();
    String hhmmss() default "000000"; // hhmmss 요소 추가
}

@Retention(RetentionPolicy.RUNTIME) // 실행 시에 리플렉션으로 참조할 수 있도록 설정
@interface TestInfo {
    int count() default 1;
    String testedBy();
    String[] testTools() default "JUnit";
    TestType testType() default TestType.FIRST;
    DateTime testDate();
}

enum TestType { FIRST, FINAL }

@Deprecated
@SuppressWarnings("1111")
@TestInfo(
    testedBy = "aaa",
    testTools = {"JUnit", "JUnit5"},
    testDate = @DateTime(yymmdd = "160101", hhmmss = "235959")
)
class Ex12_08 {
    public static void main(String[] args) {
        // Ex12_08의 Class 객체를 획득
        Class<Ex12_08> cls = Ex12_08.class;

        // 적용된 TestInfo 애너테이션 정보를 리플렉션으로 추출
        TestInfo anno = cls.getAnnotation(TestInfo.class);

        System.out.println("anno.testedBy()=" + anno.testedBy());
        System.out.println("anno.testDate().yymmdd()=" + anno.testDate().yymmdd());
        System.out.println("anno.testDate().hhmmss()=" + anno.testDate().hhmmss());

        for (String str : anno.testTools()) {
            System.out.println("TestTools=" + str);
        }
        System.out.println();

        // 모든 애너테이션 가져오기
        Annotation[] annoArr = cls.getAnnotations();
        for (Annotation a : annoArr) {
            System.out.println(a);
        }
    }
}

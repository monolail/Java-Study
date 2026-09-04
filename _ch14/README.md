# Chapter 14. 람다와 스트림 (Lambda & Stream)

이 챕터에서는 자바 8부터 추가된 함수형 프로그래밍 요소인 람다식(Lambda Expression)과 다양한 함수형 인터페이스의 활용, 그리고 메서드 참조를 실습합니다.

---

### 1. [Ex14_01.java](./src/Ex14_01.java) - 람다식의 기본과 함수형 인터페이스
- 익명 객체(Anonymous Object)를 생성하여 구현하던 기존 방식과 람다식을 이용한 방식을 비교 실습합니다.
- `@FunctionalInterface` 어노테이션을 통해 단 하나의 추상 메서드만을 가지는 인터페이스를 선언하고, 이를 람다식으로 구현하는 문법(`(a, b) -> a > b ? a : b`)을 익힙니다.

### 2. [Ex14_02.java](./src/Ex14_02.java) - 람다식의 매개변수 전달과 반환
- 람다식(함수형 인터페이스를 구현한 객체)을 메서드의 매개변수로 전달하거나 메서드의 반환 값으로 반환하는 구조를 실습합니다.
- `execute(() -> System.out.println("run()"))` 형태와 같이 코드를 일급 객체(First-class object)처럼 다루는 방식을 파악합니다.

### 3. [Ex14_03.java](./src/Ex14_03.java) - java.util.function 패키지 (표준 함수형 인터페이스)
- 자바에서 기본적으로 제공하는 표준 함수형 인터페이스인 `Supplier`, `Consumer`, `Predicate`, `Function`을 실습합니다.
- 각 인터페이스가 컬렉션(List)과 결합하여 생성(`Supplier`), 소모(`Consumer`), 조건 판별(`Predicate`), 변환(`Function`)을 어떻게 처리하는지 파악합니다.

### 4. [Ex14_04.java](./src/Ex14_04.java) - 메서드 참조 (Method Reference)
- 람다식이 단 하나의 메서드만을 호출할 때, 이를 더 간결하게 표현할 수 있는 **메서드 참조**를 실습합니다.
- 생성자 호출 시 사용하는 생성자 메서드 참조(`Supplier<MyClass> s = MyClass::new`)와 클래스의 정적/인스턴스 메서드를 참조하는 방식(`ClassName::methodName`)의 축약 과정을 살펴봅니다.

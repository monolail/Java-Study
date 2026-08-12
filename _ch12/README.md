# 12. 제네릭스, 열거형, 애너테이션 (Generics, Enumeration, Annotation)

## 💡 주요 개념 정리

### 1. 제네릭스 (Generics)
- **정의**: 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일 시의 **타입 체크(Compile-time type check)**를 해주는 기능입니다.
- **도입 배경**: JDK 1.5 이전에 도입된 컬렉션은 모든 객체의 조상인 `Object` 타입으로 데이터를 다루었습니다. 이로 인해 컬렉션에서 요소를 꺼낼 때마다 명시적인 형변환(Casting)이 필수적이었으며, 개발자의 실수로 엉뚱한 타입으로 형변환을 시도할 경우 런타임에 `ClassCastException`이 발생해 프로그램이 강제 종료되는 치명적인 결함이 존재했습니다.
- **장점**:
  1. **타입 안정성(Type-safety) 향상**: 의도하지 않은 타입의 객체가 컬렉션에 저장되는 것을 방지합니다.
  2. **형변환의 생략**: 컬렉션에서 객체를 꺼낼 때 매번 캐스팅 연산자를 쓸 필요가 없어 코드가 간결해집니다.
  3. **런타임 에러의 컴파일 타임 에러화**: 코드를 실행하기 전(컴파일 단계)에 잘못된 타입 매핑을 잡아내어 버그를 미연에 방지합니다.

### 2. 타입 변수 (Type Variable)
- 제네릭 클래스를 선언할 때는 클래스 이름 옆에 `<T>`와 같은 형태로 타입 매개변수를 선언합니다.
  ```java
  public class ArrayList<E> extends AbstractList<E> { ... }
  ```
- 기호 `T`는 'Type'의 약자이며, 상황에 따라 다른 기호를 사용하기도 합니다:
  - `T`: 일반적인 타입 (Type)
  - `E`: 컬렉션 내부 요소 (Element)
  - `K`: 맵의 키 (Key)
  - `V`: 맵의 값 (Value)
- 인스턴스를 생성할 때 실제 적용할 타입을 대입하면, 컴파일러가 해당 클래스 내부의 타입 변수들을 지정된 실제 타입으로 매핑 및 대체하여 처리합니다.

### 3. 제네릭스의 제한 사항 및 규칙
- **참조변수와 생성자의 타입 일치**:
  - 제네릭 클래스의 객체를 생성할 때, 참조변수에 지정한 제네릭 타입 매개변수와 생성자에 대입한 타입 매개변수는 **반드시 일치**해야 합니다. 다형성이 적용되어 조상-자손 관계라 하더라도 제네릭 타입 자체가 다르면 컴파일 에러가 발생합니다.
    ```java
    ArrayList<Tv> list = new ArrayList<Tv>(); // OK (일치)
    ArrayList<Product> list = new ArrayList<Tv>(); // 에러! (Tv가 Product의 자손이더라도 제네릭 타입은 완전히 일치해야 함)
    ```
  - JDK 1.7부터는 생성자 측의 타입을 생략하고 다이아몬드 연산자 `<>`로 대체할 수 있습니다.
    ```java
    ArrayList<Tv> list = new ArrayList<>(); // OK (타입 추론)
    ```

### 4. 제네릭 Iterator (Iterator<E>)
- `Iterator` 인터페이스 또한 제네릭스를 지원합니다. `Iterator<E>` 형식으로 반환받으면, `next()` 메서드가 꺼내는 객체의 반환 타입이 지정된 타입 `E`로 확정됩니다.
- 이로 인해 요소를 호출할 때마다 매번 명시적으로 형변환(Casting) 연산을 수동 작성해 주어야 했던 번거로움과 오류 가능성이 일시에 해소됩니다.

### 5. 다중 타입 매개변수
- `HashMap`처럼 키(Key)와 값(Value)과 같이 여러 개의 타입 인자를 대입받는 클래스는 선언부에 쉼표(`,`)를 구분자로 여러 개의 타입 변수를 가집니다.
- 예: `class HashMap<K, V> { ... }`
- 실제 객체를 선언하여 다룰 때 키와 값의 타입을 각각 대입해 유연하고도 안전한 해시맵 구조를 정적으로 바인딩하여 운용할 수 있습니다.

### 6. 제한된 제네릭 클래스 (Bounded Generic Class)
- 제네릭스 타입 변수에 대입할 수 있는 타입을 제한하여 안전한 코드를 설계하는 문법입니다.
- **`extends` 키워드 지정**: `<T extends Fruit>` 형태로 선언하면, `T`는 `Fruit`를 포함하여 **`Fruit`의 자손 클래스들만 대입** 가능하게 됩니다.
- 만일 인터페이스를 구현한 클래스로 제한하려 할 때도 `implements` 대신 동일하게 `extends`를 사용하며, 여러 제한 조건을 연결할 때는 `&` 기호를 사용합니다 (예: `<T extends Fruit & Eatable>`).

### 7. 와일드카드 (Wildcard `?`)
제네릭 타입 매개변수의 유연성을 늘리기 위해 설계된 미확정 기호(`?`)입니다.
- **`<? extends T>`**: 와일드카드의 **상한 제한**. `T`와 그 자손들만 대입 가능합니다.
- **`<? super T>`**: 와일드카드의 **하한 제한**. `T`와 그 조상들만 대입 가능합니다.
- **`<?>`**: 제한 없음. `<? extends Object>` 와 동일하여 모든 타입이 매핑될 수 있습니다.
- 메서드 선언부에 와일드카드를 적용하면 매개변수가 다른 다양한 제네릭스 객체들을 일괄적으로 수용할 수 있게 되어 코드의 재사용성이 획기적으로 상승합니다.

### 8. 제네릭 타입의 형변환 (Generic Casting Rules)
- **제네릭 타입과 원시 타입 간**: 형변환이 가능하나 안전성 경고(Warning)가 발생합니다. (예: `Box` <-> `Box<String>`).
- **서로 다른 제네릭 타입 간**: 타입 매개변수가 다를 경우 조상-자손 관계가 성립하더라도 직접적인 형변환은 **불가능**합니다 (예: `Box<String>` <-> `Box<Integer>`, `Fruitbox<Fruit>` <-> `Fruitbox<Apple>` 캐스팅 불가).
- **와일드카드 개입 시**: 와일드카드 타입으로의 형변환(업캐스팅)은 언제나 가능합니다 (예: `Fruitbox<Apple>` -> `Fruitbox<? extends Fruit>`). 이를 매개체 삼아 서로 다른 제네릭 타입 간의 우회 형변환도 처리가 가능합니다.

### 9. 열거형 (Enum)
- 서로 연관된 상수를 간결하고 강력하게 정의하기 위해 JDK 1.5에 도입된 특별한 자료형입니다.
- **특징**:
  - **타입 안전성(Typesafe)**: 단순 값의 대조뿐 아니라 실제 타입 자체를 비교하므로, 정수형 상수가 지닌 값 매핑 오류 등을 사전에 차단합니다.
  - **값 비교**: 열거형 상수는 물리적으로 단 하나만 생성되는 인스턴스 형태이므로 `==` 연산자로 빠르게 동등성을 비교할 수 있습니다.
- **주요 기본 API**:
  - `name()`: 열거형 상수의 이름을 문자열로 반환.
  - `ordinal()`: 열거형 상수가 정의된 순서(0부터 시작하는 인덱스)를 반환.
  - `values()`: 정의된 모든 상수를 배열 형태로 반환.
  - `valueOf(String name)`: 지정된 이름의 열거형 상수 객체를 탐색해 반환.

### 10. 애너테이션 (Annotation)
- **정의**: 소스코드에 특수한 형식으로 정보를 기록하여, 프로그램 자체의 로직에는 영향을 주지 않으면서 **컴파일러나 빌드 툴, 런타임 프레임워크에게 중요한 메타데이터 설정 정보를 제공**하는 주석적 마크업 기법입니다.
- **역할**:
  - 컴파일러에게 유효성 검사 지시 (예: 잘못 설계된 오버라이딩 탐지).
  - 소프트웨어 개발 툴 및 프레임워크를 위한 빌드/설정 정보 제공.
  - 실행 시점(Runtime)에 리플렉션 기법을 이용해 메타 코드를 기반으로 동적으로 동작을 변경하도록 유도.

### 11. 표준 애너테이션 (Standard Annotations)
자바가 기본으로 내장하여 제공하는 대표적인 컴파일 지시용 애너테이션들입니다.
- **`@Override`**: 메서드 앞에 붙여 해당 메서드가 조상 클래스의 메서드를 **올바르게 오버라이딩**했는지 컴파일러에게 검증을 요청합니다. 철자 실수나 매개변수 개수 오류 등으로 오버라이딩이 되지 않았을 경우 컴파일 에러를 즉각 발생시켜 실수를 완벽하게 제어합니다.
- **`@Deprecated`**: 더 이상 사용되지 않거나 권장되지 않는 멤버(클래스, 필드, 메서드)에 선언합니다. 다른 클래스에서 이 멤버를 호출하려고 하면 컴파일러가 경고 메시지를 노출하여 하위 호환성을 깨지 않는 한도 내에서 새 메서드로의 전환을 독려합니다.
- **`@FunctionalInterface`**: 해당 인터페이스가 단 하나의 추상 메서드만 정의하는 **함수형 인터페이스(Functional Interface)** 규격에 부합하는지 컴파일러에게 체크를 지시합니다. (추상 메서드가 없거나 2개 이상이면 즉시 빌드 에러를 유발합니다.)
- **`@SuppressWarnings`**: 컴파일러가 노출하는 특정 경고 메시지가 화면에 찍히지 않도록 억제합니다. 애너테이션 괄호 안에 대상 경고 타입을 문자열 매개변수로 지정할 수 있습니다 (예: `@SuppressWarnings("deprecation")` - 감가 경고 비활성화).

### 12. 메타 애너테이션 (Meta-Annotations)
애너테이션에 붙는 애너테이션으로, 애너테이션을 정의할 때 적용 대상이나 유지 범위 등을 지정하기 위해 사용합니다.
- **`@Target`**: 애너테이션이 적용될 수 있는 대상(위치)을 지정합니다.
  - `ElementType.TYPE` (클래스, 인터페이스, 열거형)
  - `ElementType.FIELD` (멤버 변수, 열거형 상수)
  - `ElementType.METHOD` (메서드)
  - `ElementType.PARAMETER` (매개변수)
  - `ElementType.LOCAL_VARIABLE` (지역 변수)
- **`@Retention`**: 애너테이션이 컴파일된 후에도 소스 내에서 유지되는 범위(기간)를 정의합니다.
  - `RetentionPolicy.SOURCE`: 소스 파일에만 존재하고, 컴파일 시 클래스 파일에서 제거됩니다 (예: `@Override`).
  - `RetentionPolicy.CLASS`: 클래스 파일에는 포함되지만, 실행 시(JVM 로드 시) 메모리에 올라가지 않습니다 (디폴트 범위).
  - `RetentionPolicy.RUNTIME`: 클래스 파일에 기록되며 런타임 실행 중에도 **리플렉션(Reflection)을 통해 정보 조회가 가능**합니다. (동적 설정 분석 시 주로 활용).
- **`@Documented`**: 애너테이션 정보가 javadoc으로 작성된 문서에 포함되도록 지시합니다.
- **`@Inherited`**: 애너테이션이 자손 클래스에 상속되도록 설정합니다. 조상 클래스에 붙이면 자손 클래스에도 동일하게 선언된 것으로 간주됩니다.

### 13. 사용자 정의 애너테이션 설계 규칙
새로운 애너테이션을 개발자가 직접 선언할 때 지켜야 하는 문법과 규약입니다.
- **선언 문법**: `@interface` 키워드를 사용해 정의합니다.
  ```java
  @Retention(RetentionPolicy.RUNTIME)
  @interface MyAnnotation {
      String value(); // 요소 선언
      int count() default 1; // default 키워드로 기본값 부여 가능
  }
  ```
- **애너테이션 요소(Element) 선언 규칙**:
  1. 매개변수를 가질 수 없으며, 예외(`throws`)를 선언할 수 없습니다.
  2. 요소의 반환 타입은 **기본형(primitive), String, enum, 애너테이션, Class 객체**만 가능합니다.
  3. 요소의 이름 뒤에는 비어있는 괄호 `()`를 붙여야 합니다.
  4. 기본값을 지정하고 싶을 때는 `default [기본값]` 형태로 선언합니다.

---

## 📂 파일 구성 및 학습 내용

### 1. [Ex12_01.java](./src/Ex12_01.java) - 제네릭스의 필요성과 기본 문법
- 제네릭스가 적용되지 않은 일반 컬렉션 구조에서 발생하던 문제점과, `ArrayList<Integer>`로 제네릭스를 지정했을 때 컴파일러가 다른 타입(예: 문자열 `"30"`)의 삽입을 원천 차단하고 데이터를 조회할 때 명시적 형변환을 생략하게 돕는 기초 코드를 실습합니다.

```java
ArrayList<Integer> list = new ArrayList<Integer>();
list.add(10);
list.add(20);
// list.add("30"); // 컴파일 에러 발생: Integer 타입 외 대입 차단

Integer i = list.get(2); // 형변환 생략 가능 (컴파일러가 자동 처리)
```

---

### 2. [Ex12_02.java](./src/Ex12_02.java) - 제네릭 타입 불일치와 제한
- `ArrayList<Tv>` 컬렉션을 설계하여 지정된 `Tv` 타입만을 저장하게 강제하는 실습입니다. `Audio`와 같은 엉뚱한 타입의 인스턴스를 추가할 시 발생하는 컴파일 에러를 관찰하고, 참조변수와 생성자의 제네릭 타입이 완벽하게 일치해야 함을 학습합니다.

```java
ArrayList<Tv> list = new ArrayList<Tv>();
list.add(new Tv());
// list.add(new Audio()); // 컴파일 에러: Tv 타입으로 제한됨

Tv t = list.get(0); // 캐스팅 캐스팅 연산 없이 데이터를 바로 꺼내어 안전하게 사용
```

---

### 3. [Ex12_03.java](./src/Ex12_03.java) - 제네릭 Iterator와 HashMap 활용
- 제네릭 `Iterator<Student>`를 설정하여 반복 조회를 시도함으로써, `next()` 호출 시 강제 형변환 연산 없이 컬렉션 요소의 속성(`Student.name`)에 바로 접근하는 구조를 배웁니다.
- 복수의 제네릭 타입 변수를 지정하여 선언하는 `HashMap<String, Student>` 컬렉션을 선언하고, 데이터를 주입하는 실습 예제입니다.

```java
ArrayList<Student> list = new ArrayList<Student>();
// ... 데이터 추가

Iterator<Student> it = list.iterator(); // 제네릭 Iterator 적용
while(it.hasNext()) {
    Student s = it.next(); // 형변환 연산 배제 가능
    System.out.println(s.name);
}

// HashMap에 2개의 타입 매개변수 바인딩
HashMap<String, Student> map = new HashMap<String, Student>();
map.put("1-1", new Student("홍길동", 1, 1, 90, 80, 70));
```

---

### 4. [Ex12_04.java](./src/Ex12_04.java) - Bounded Type 제네릭 클래스와 와일드카드
- `<T extends Fruit>`로 타입 파라미터 경계를 짓는 Bounded Generic 클래스 `Fruitbox`를 설계합니다.
- `makeJuice(Fruitbox<? extends Fruit> box)` 와 같이 상한 제한 와일드카드(`? extends Fruit`)를 매개변수 타입으로 채택해, 자손 타입을 지닌 다채로운 제네릭 상자들을 유연하고도 안전하게 쥬서기로 인입시키는 메커니즘을 테스트합니다.

```java
class Fruitbox<T extends Fruit> extends Box<T> {}

// Juicer
static Juice makeJuice(Fruitbox<? extends Fruit> box) { ... }
```

---

### 5. [Ex12_05.java](./src/Ex12_05.java) - 제네릭 타입 캐스팅 규칙
- 제네릭 타입 간 형변환 한계를 확인하는 예제입니다. `Box<String>`과 `Box<Integer>` 간의 불가능한 다이렉트 캐스팅을 경험하고, 와일드카드를 포함한 제네릭 타입(`Fruitbox<? extends Fruit>`)이 일종의 공통 슈퍼타입 역할을 하여 업캐스팅 캐스팅 가교 역할을 수행하는 규칙을 검증합니다.

```java
Fruitbox<? extends Fruit> fruitBox = new Fruitbox<Fruit>(); // OK
Fruitbox<? extends Apple> appleBox = new Fruitbox<Apple>(); // OK
```

---

### 6. [Ex12_06.java](./src/Ex12_06.java) - 열거형 Enum 기초 활용
- 동서남북 방향을 상징하는 `enum Direction { EAST, WEST, SOUTH, NORTH }` 을 선언하여 사용합니다.
- 열거형 상수에 대한 비교 연산(`==` 및 `compareTo()`), `switch-case` 문 연계 매핑, 그리고 상수의 메타 정보를 조회하는 API(`name()`, `ordinal()`, `values()`, `valueOf()`) 들의 작동 방식을 실습합니다.

```java
Direction d1 = Direction.EAST;
Direction d2 = Direction.valueOf("WEST");

System.out.println(d1.compareTo(d2)); // ordinal 정수 위치 편차 비교
Direction[] dArr = Direction.values(); // 전체 원소 뷰 반환
```

---

### 7. [Ex12_07.java](./src/Ex12_07.java) - 자바 내장 표준 애너테이션 실습
- 자바의 4가지 주요 표준 애너테이션의 검증 과정을 학습합니다.
- 조상 클래스의 메서드를 재정의할 때 오버라이딩 유효성을 확인하는 `@Override`, 구버전 메서드 호출 시 컴파일 경고를 내는 `@Deprecated`, 컴파일러 지시 경고 메시지를 억제하는 `@SuppressWarnings`, 그리고 추상 메서드가 정확히 1개인 인터페이스 형태인지 체크하는 `@FunctionalInterface`를 테스트합니다.

```java
class Child extends Parent {
    @Override // 오버라이딩 검증
    @Deprecated // 더 이상 권장하지 않음 선언
    void parentMethod() {}
}

@FunctionalInterface // 함수형 인터페이스 검증 (추상 메서드 단 1개 제한)
interface Test {
    void checkMethod();
}

class Ex12_07 {
    @SuppressWarnings("deprecation") // Deprecated 경고 무시
    public static void main(String[] args) {
        Child c = new Child();
        c.parentMethod();
    }
}
```

---

### 8. [Ex12_08.java](./src/Ex12_08.java) - 사용자 정의 애너테이션과 리플렉션
- 커스텀 애너테이션 `@TestInfo`와 `@DateTime`을 설계하고 클래스 레벨에 적용하는 실습입니다.
- 실행 시간에 메모리에 정보를 유지시키기 위한 메타 애너테이션 `@Retention(RetentionPolicy.RUNTIME)`의 활용법을 익히고, **리플렉션 API(`cls.getAnnotation()`, `cls.getAnnotations()`)**를 호출하여 클래스에 주입된 애너테이션 값과 메타 데이터를 동적으로 로드 및 출력하는 기법을 실습합니다.

```java
@Retention(RetentionPolicy.RUNTIME)
@interface TestInfo {
    int count() default 1;
    String testedBy();
    String[] testTools() default "JUnit";
    DateTime testDate();
}

// 리플렉션을 통한 동적 정보 조회
Class<Ex12_08> cls = Ex12_08.class;
TestInfo anno = cls.getAnnotation(TestInfo.class);
System.out.println("testedBy=" + anno.testedBy());
```

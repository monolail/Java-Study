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

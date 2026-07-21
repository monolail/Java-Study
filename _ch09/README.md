# 09. java.lang 패키지와 유용한 클래스 (java.lang Package & Useful Classes)

자바 프로그래밍의 가장 기본이 되는 **java.lang 패키지**의 핵심 클래스(`Object`, `String` 등)와 주요 메서드 오버라이딩 기법 및 자료형 형변환 방식을 정리한 공간입니다.

---

## 💡 주요 개념 정리

### 1. java.lang 패키지
- **정의**: 자바 프로그래밍에 필수적이고 기본적인 클래스들을 담고 있는 패키지입니다.
- **특징**: 다른 패키지들과 다르게 `import`문 없이도 프로그램 내에서 바로 사용할 수 있도록 기본 제공됩니다. (예: `System`, `String`, `Object` 등)

### 2. Object 클래스
- 모든 클래스의 최상위 조상 클래스입니다. 별도의 조상을 상속받지 않는 모든 클래스는 컴파일러가 자동으로 `extends Object`를 추가합니다.
- 이에 따라 자바의 모든 객체는 Object 클래스의 멤버(11개의 메서드)를 기본적으로 상속받아 사용할 수 있습니다.

### 3. equals(Object obj)
- **기본 동작**: 매개변수로 전달받은 객체의 참조변수 값(물리적 메모리 주소값)을 비교하여 같은 인스턴스인지 판단합니다 (`this == obj`).
- **오버라이딩 목적**: 물리적 주소가 다르더라도, 두 객체가 가지고 있는 핵심 멤버 데이터의 내용이 같으면(논리적으로 동등하면) 참(`true`)을 반환하도록 재정의합니다.
- **오버라이딩 규칙**:
  - 매개변수가 `Object` 타입이므로 인스턴스 비교 및 형변환 전에 반드시 `instanceof` 연산자로 타입 검사를 수행해 호환 여부를 확인해야 안전합니다.

### 4. toString()
- **기본 동작**: 객체의 클래스 이름과 16진수 해시코드를 연결한 문자열을 반환합니다 (`클래스이름@해시코드`).
- **오버라이딩 목적**: 객체가 가진 멤버 필드들의 값 정보를 한눈에 알아보기 쉽도록 문자열로 출력되게 재정의합니다.
- **특징**: `System.out.println(객체)`를 수행할 때 자동으로 객체의 `toString()`이 실행되어 출력됩니다.

### 5. 기본형(Primitive)과 문자열(String) 간의 변환
- **기본형 -> String**:
  - 빈 문자열 `""`을 더해 간편하게 변환하거나 (`value + ""`), `String.valueOf(value)` 메서드를 이용합니다.
- **String -> 기본형**:
  - `Integer.parseInt(str)`, `Double.parseDouble(str)` 등을 이용해 원시 타입(Primitive)으로 변환합니다.
  - `Integer.valueOf(str)`, `Double.valueOf(str)`를 이용하면 기본형뿐만 아니라 객체(Wrapper 클래스)로도 자동 형변환되어 유연하게 대입할 수 있습니다.

---

## 파일 구성 및 학습 내용

### 1. [Ex9_01.java](./src/Ex9_01.java) - equals(Object obj) 오버라이딩 기초
- 물리적으로 서로 다른 두 인스턴스(`v1`, `v2`)에 대해, 두 인스턴스가 가진 정수값(`value`)이 같을 때 `equals()`가 참(`true`)을 반환하도록 오버라이딩하여 물리 주소가 아닌 논리 값을 비교하는 실습입니다.

```java
class Value {
    int value;
    Value(int value) { this.value = value; }

    @Override
    public boolean equals(Object obj) {
        // Object 타입을 자손 타입으로 형변환하여 내부 값을 비교
        Value v = (Value)obj; 
        return this.value == v.value;
    }
}
```

---

### 2. [Ex9_02.java](./src/Ex9_02.java) - instanceof를 이용한 안전한 equals 오버라이딩
- `equals(Object obj)` 오버라이딩 시, 예외 발생을 방지하기 위해 매개변수가 해당 클래스 타입(`Person`)의 인스턴스가 맞는지 `instanceof` 연산자로 검사 후 형변환하는 안전한 비교 기법을 학습합니다.

```java
class Person {
    long id;
    Person(long id) { this.id = id; }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) return false; // 타입 체크 필수
        Person p = (Person)obj;
        return this.id == p.id;
    }
}
```

---

### 3. [Ex9_03.java](./src/Ex9_03.java) - toString() 오버라이딩과 다중 조건 equals
- `toString()` 메서드를 오버라이딩하여 카드 객체의 모양(`kind`)과 숫자(`number`)를 사람이 읽기 쉬운 포맷으로 출력하도록 정의합니다.
- 카드 모양 문자열(`kind`)과 정수(`number`)가 동시에 일치할 때 동등한 객체로 판단하도록 `equals()`를 확장 실습합니다.

```java
class Card {
    String kind;
    int number;

    @Override
    public String toString() {
        return "kind: " + kind + ", number: " + number;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) return false;
        Card c = (Card)obj;
        return this.kind.equals(c.kind) && this.number == c.number; // 문자열 및 기본형 비교
    }
}
```

---

### 4. [Ex9_04.java](./src/Ex9_04.java) - 자료형 변환 (Primitive <-> String)
- 문자열 결합(`+ ""`) 및 다양한 파싱 메서드(`Integer.valueOf()`, `Double.parseDouble()`)를 사용해 기본형 변수들을 문자열로 변환하거나 그 역으로 파싱하는 동작을 실습합니다.

```java
int ival = 100;
String strval = ival + ""; // int -> String

double sum = Integer.valueOf(strval) + Double.parseDouble("200.0"); // String -> Wrapper/Primitive
```

---

## 핵심 비교 요약

| 개념 | 주요 특징 및 주의사항 | 예시 / 메서드 |
| :--- | :--- | :--- |
| **java.lang 패키지** | 별도의 import 선언 없이 어디서나 사용 가능 | `String`, `System`, `Math` |
| **Object 클래스** | 모든 자바 클래스의 최상위 조상 클래스 | 멤버 메서드 `equals()`, `toString()` 등 제공 |
| **기본 equals()** | 객체의 물리적 메모리 주소값 비교 (동일성) | `this == obj` |
| **오버라이딩 equals()** | 객체의 내용 필드가 같은지 논리적 비교 (동등성) | `this.id == p.id` |
| **기본 toString()** | `클래스명@16진수해시코드` 반환 | `Card@2f9ee1ac` |
| **오버라이딩 toString()** | 객체의 멤버 필드 정보 요약을 알기 쉬운 문자열로 반환 | `kind: Spade, number: 1` |
| **`instanceof`** | equals 구현 시 매개변수 객체가 비교 가능한 타입인지 안전하게 검증 | `obj instanceof Card` |
| **기본형 -> String** | 문자열 합치기(`+ ""`) 또는 `String.valueOf()` 사용 | `100 + ""` |
| **String -> 기본형** | Wrapper 클래스의 파싱(parse) 및 ValueOf 메서드 활용 | `Integer.parseInt("100")` |

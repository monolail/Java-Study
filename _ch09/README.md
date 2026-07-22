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

### 6. StringBuffer & StringBuilder 클래스
- **공통점**:
  - 지정된 크기의 버퍼(char 배열)를 내부에 가지며, 한번 생성하면 값을 변경할 수 없는 `String` 클래스와 달리 **내부 문자열 데이터의 자유로운 변경(수정/추가)이 가능**합니다.
  - 문자열 결합 연산이 빈번하게 일어나는 구조에서 `String`에 비해 인스턴스 생성 및 가비지 컬렉션 부담이 크게 줄어듭니다.
- **차이점 (동기화 여부)**:
  - **`StringBuffer`**: 멀티스레드 환경에서 안전하도록 **동기화(Synchronization)** 처리가 되어 있어 Thread-safe합니다.
  - **`StringBuilder`**: 동기화 처리를 배제하여 단일스레드 환경이나 멀티스레드 동기화가 불필요한 환경에서 **`StringBuffer`보다 빠른 속도와 우수한 성능**을 제공합니다 (두 클래스는 제공하는 기능과 API가 동일합니다).

### 7. Wrapper 클래스
- **정의**: 자바의 8가지 기본형(Primitive type) 변수를 객체로 다루어야 할 때(예: 컬렉션에 추가, 객체 참조 전달 등) 객체 형태로 감싸서 제공하는 클래스들입니다.
- **매칭**: `boolean`->`Boolean`, `char`->`Character`, `int`->`Integer`, `double`->`Double` 등.
- **오토박싱(Autoboxing) & 언박싱(Unboxing)**:
  - **오토박싱**: 기본형 값을 자동으로 Wrapper 객체로 변환해주는 기법 (예: `Integer i = 100;`).
  - **언박싱**: Wrapper 객체의 값을 자동으로 기본형으로 꺼내주는 기법 (예: `int val = i;`).
  - 컴파일러가 바이트코드로 변환 시 형변환 메서드(`valueOf()`, `intValue()`)를 자동으로 작성해주므로 편리한 혼용 연산이 가능합니다.

### 8. Number 클래스
- **정의**: 숫자를 나타내는 래퍼 클래스들(`Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`)과 매우 큰 수치 연산을 돕는 `BigInteger`, `BigDecimal` 등의 공통 조상이 되는 추상 클래스입니다.
- **역할**: 객체 상태로 저장된 숫자들을 기본형으로 변환해주는 메서드들(`intValue()`, `longValue()`, `floatValue()`, `doubleValue()` 등)을 하위 클래스에서 반드시 구현하도록 추상화하여, 다형성 구조 속에서 유연한 기본형 자료형 변환을 지원합니다.

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

### 5. [Ex9_05.java](./src/Ex9_05.java) - Math.round()와 Math.rint()의 반올림 비교

- 소수점 첫째자리에서 반올림을 수행하는 `Math.round()`와 가장 가까운 짝수 정수(double)를 반환하는 `Math.rint()`의 반올림 기준 차이를 비교하는 예제입니다.

```java
double d1 = Math.round(d); // 1.5 -> 2, 2.5 -> 3 (정수형 변환 반올림)
double d2 = Math.rint(d);  // 1.5 -> 2.0, 2.5 -> 2.0 (가장 가까운 짝수 실수)
```

---

### 6. [Ex9_06.java](./src/Ex9_06.java) - 다양한 진법 문자열의 정수 변환

- `Integer.parseInt(String s, int radix)` 메서드를 활용하여 2진법, 16진법 등 10진법이 아닌 다른 진법 형태로 표현된 문자열 숫자를 10진수 정수로 정확하게 변환해주는 예제입니다.

```java
int i2 = Integer.parseInt("100", 2);   // "100"을 2진수로 파싱 -> 10진수 4
int i16 = Integer.parseInt("FF", 16);  // "FF"를 16진수로 파싱 -> 10진수 255
```

---

### 7. [Ex9_07.java](./src/Ex9_07.java) - 오토박싱(Autoboxing)과 언박싱(Unboxing)

- `ArrayList<Integer>`를 사용하면서 기본형 데이터(`100`)가 자동으로 `Integer` 객체로 포장되어 추가되는 오토박싱 현상과, 리스트 내부 객체가 명시적 메서드 호출(`intValue()`) 없이 자동으로 기본형 변수에 대입되는 언박싱 현상을 학습합니다.

```java
ArrayList<Integer> list = new ArrayList<Integer>();
list.add(100);       // 오토박싱: list.add(new Integer(100))으로 컴파일러가 자동 변환
Integer i = list.get(0); // 언박싱 지원 대입
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
| **StringBuffer** | 내부 버퍼 변경 가능(Mutable). 동기화 지원(Thread-Safe)으로 멀티스레드 적합 | `StringBuffer sb = new StringBuffer();` |
| **StringBuilder** | 내부 버퍼 변경 가능(Mutable). 동기화 미지원으로 단일스레드 고성능 제공 | `StringBuilder sb = new StringBuilder();` |
| **Wrapper 클래스** | 8가지 기본형을 객체로 다루기 위해 포장하는 클래스군 | `Integer`, `Double`, `Character` 등 |
| **Number 클래스** | 숫자형 래퍼 클래스 및 대형 수치 연산 클래스들의 공통 추상 조상 | `Byte`, `Integer`, `BigInteger` 등의 조상 |
| **오토박싱/언박싱** | 기본형 값과 래퍼 클래스 객체 간의 자동 형변환 지원 | `list.add(100)` (Autoboxing) |


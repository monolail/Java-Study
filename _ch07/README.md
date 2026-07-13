# 07. 객체지향 프로그래밍 II (OOP II - 상속, 포함, 오버라이딩, 제어자, 캡슐화)

상속(Inheritance)의 개념과 활용, 클래스 간 관계(is-a / has-a), 메서드 오버라이딩(Overriding), 패키지(Package), 접근 제어자(Access Modifier), 그리고 캡슐화(Encapsulation)에 대해 실습한 내용을 정리한 공간입니다.

---

## 💡 주요 개념 정리

### 1. 상속 (Inheritance)
- **정의**: 기존 클래스를 재사용하여 새로운 클래스를 작성하는 방법입니다. `extends` 키워드를 사용합니다.
- **특징**:
  - 자식 클래스(SubClass)는 부모 클래스(SuperClass)의 모든 멤버(변수와 메서드)를 상속받습니다.
  - 자식 클래스는 부모 클래스보다 항상 같거나 많은 멤버를 가집니다.
  - Java에서는 **단일 상속(Single Inheritance)** 만 허용합니다. (하나의 부모 클래스만 상속 가능)

### 2. 클래스 간의 관계 - 상속 vs 포함
- **상속 관계 (is-a)**: "A는 B이다" 관계. 예) SmartTv **is a** Tv
  - `class SmartTv extends Tv`
- **포함 관계 (has-a)**: "A는 B를 가지고 있다" 관계. 예) Circle **has a** Point
  - `class Circle { Point p = new Point(); }`
- 일반적으로 포함 관계가 더 자주 쓰이며, 관계가 애매할 때는 **is-a**이면 상속, **has-a**이면 포함을 사용합니다.

### 3. 메서드 오버라이딩 (Method Overriding)
- **정의**: 부모 클래스로부터 상속받은 메서드를 자식 클래스에서 재정의하는 것입니다.
- **조건**:
  1. 메서드 이름이 같아야 합니다.
  2. 매개변수가 같아야 합니다.
  3. 반환 타입이 같아야 합니다.
- 오버라이딩하면 자식 클래스에서 정의한 메서드가 호출됩니다.
- **오버라이딩 vs 오버로딩**: 오버라이딩은 메서드를 **재정의**(부모 메서드를 덮어씀)하는 것이고, 오버로딩은 메서드를 **중복 정의**(같은 이름, 다른 매개변수)하는 것입니다.

### 4. 패키지 (Package)
- **정의**: 서로 관련 있는 클래스들과 인터페이스의 묶음입니다.
- **특징**:
  - 클래스의 물리적인 파일 구분을 나타내는 기본 단위(폴더/디렉토리)입니다.
  - 클래스의 실제 이름(FQN, Fully Qualified Name)은 패키지명을 포함합니다. (예: `java.lang.String`)

### 5. 접근 제어자 (Access Modifier)
- **정의**: 멤버 또는 클래스에 외부로부터의 접근을 제한하는 제어자입니다.
- **종류와 범위**:
  - `private`: **같은 클래스** 내에서만 접근 가능.
  - `(default)`: **같은 패키지** 내에서만 접근 가능 (제어자를 붙이지 않은 경우).
  - `protected`: **같은 패키지** 내, 그리고 **다른 패키지의 자손 클래스**에서 접근 가능.
  - `public`: **접근 제한 없음**.
- **클래스 정의 규칙**: 하나의 소스파일(`.java`)에는 `public class`가 단 하나만 존재할 수 있으며, 그 클래스 이름은 파일명과 일치해야 합니다.

### 6. 캡슐화 (Encapsulation)
- **정의**: 데이터와 데이터를 처리하는 행위(메서드)를 하나로 묶고, 실제 구현 내용 일부를 외부에 감추어 보호하는 기법입니다.
- **목적**:
  - 외부로부터 데이터를 보호 (데이터 오염 방지).
  - 외부에는 불필요한, 내부적으로만 사용되는 부분을 감추어 복잡성을 감소시킴.
- **구현 방법**:
  - 멤버 변수를 `private`으로 선언하여 외부 직접 접근을 제한합니다.
  - `public`으로 선언된 Getter와 Setter 메서드를 제공하여 데이터를 간접적으로 다루도록 설정합니다. (값 유효성 검사 등 적용 가능)

### 7. 제어자 static, final, abstract
- **`static` (클래스의, 공통적인)**:
  - 멤버 변수: 모든 인스턴스가 공통적으로 공유하는 클래스 변수가 됩니다. 인스턴스 생성 없이 사용할 수 있습니다.
  - 메서드: 인스턴스 생성 없이 `클래스이름.메서드이름()`으로 호출 가능합니다. 단, 메서드 내에서 인스턴스 멤버(iv, im)는 사용할 수 없습니다.
- **`final` (마지막의, 변경할 수 없는)**:
  - 클래스: 다른 클래스의 조상이 될 수 없습니다 (상속 불가능, 예: `String`).
  - 메서드: 오버라이딩을 통해 재정의할 수 없습니다.
  - 변수: 값을 변경할 수 없는 상수(Constant)가 됩니다.
- **`abstract` (추상적인, 미완성의)**:
  - 클래스: 클래스 내에 추상 메서드가 존재함을 의미하며, 설계도 자체가 미완성이므로 인스턴스를 생성할 수 없습니다.
  - 메서드: 선언부만 작성하고 구현부는 작성하지 않은 추상 메서드입니다. 자손 클래스가 반드시 이를 상속받아 구현(오버라이딩)해야 합니다.

### 8. import문과 static import
- **import문**:
  - 소스코드 내에서 다른 패키지의 클래스를 사용할 때 패키지명을 생략할 수 있게 해줍니다.
  - 컴파일러에게 클래스가 속한 패키지를 알려주는 역할을 하며, 성능에 미치는 영향은 전혀 없습니다.
  - `import 패키지명.클래스명;` 또는 `import 패키지명.*;` 형식으로 작성합니다.
- **static import문**:
  - `static` 멤버를 호출할 때 클래스 이름을 생략할 수 있도록 지원합니다.
  - 예: `import static java.lang.Math.random;` 선언 후 `Math.random()` 대신 `random()`만으로 사용 가능.

### 9. 다형성 (Polymorphism)
- **정의**: 하나의 참조변수로 여러 타입의 객체를 참조할 수 있는 성질입니다. 자바에서는 **조상 타입의 참조변수로 자손 타입의 인스턴스를 참조**할 수 있도록 구현되어 있습니다.
- **참조변수의 형변환 (Casting)**:
  - 서로 상속관계에 있는 클래스 사이에서만 참조변수의 형변환이 가능합니다.
  - **업캐스팅 (자손 -> 조상)**: 형변환 생략이 가능합니다.
  - **다운캐스팅 (조상 -> 자손)**: 형변환을 생략할 수 없으며 반드시 `(자손타입)`으로 명시해야 합니다.
  - 형변환 시 실제 참조하고 있는 인스턴스의 멤버 개수를 넘어서는 접근은 허용되지 않으므로, 실행 시 에러(`ClassCastException`)를 방지하기 위해 `instanceof` 연산자로 호환성을 먼저 확인해야 합니다.
- **매개변수의 다형성**:
  - 메서드의 매개변수 타입을 조상 타입으로 선언하면, 메서드 호출 시 조상의 모든 자손 타입 객체를 인자로 전달할 수 있어 코드의 중복을 획기적으로 줄여줍니다.
- **다형성 배열**:
  - 조상 타입의 참조변수 배열을 생성하면, 공통 조상을 가진 서로 다른 종류의 자손 객체들을 하나의 배열에 묶어서 효율적으로 관리할 수 있습니다.

---

## 파일 구성 및 학습 내용

### 1. [Ex7_01.java](./src/Ex7_01.java) - 상속의 기본

- `Tv` 클래스를 상속받아 `SmartTv` 클래스를 정의하는 예제입니다.
- 자식 클래스의 인스턴스를 생성하면 부모 클래스의 멤버도 함께 사용 가능합니다.

```java
class Tv {
    boolean power;
    int channel;

    void power() { power = !power; }
    void channelUp() { channel++; }
    void channelDown() { channel--; }
}

class SmartTv extends Tv {
    boolean caption;
    void displayCaption(String text) {
        if (caption) {
            System.out.println(text);
        }
    }
}
```

---

### 2. [Ex7_02.java](./src/Ex7_02.java) - 상속 vs 포함 (is-a / has-a)

- 같은 결과를 내는 두 가지 방법(상속, 포함)을 비교하는 예제입니다.
- `Circle extends Point`(상속) vs `Circle2 { Point p; }`(포함)

```java
// 상속 (is-a): Circle은 Point이다.
class Circle extends Point {
    int r;
}

// 포함 (has-a): Circle은 Point를 가지고 있다.
class Circle2 {
    Point p = new Point();
    int r;
}
```

---

### 3. [Ex7_03.java](./src/Ex7_03.java) - 메서드 오버라이딩

- 부모 클래스 `parent`의 `print()` 메서드를 자식 클래스 `child`에서 재정의하는 예제입니다.
- 주석을 해제하면 자식 클래스에서 오버라이딩된 메서드가 호출됩니다.

```java
class parent {
    void print() {
        System.out.println("parent");
    }
}

class child extends parent {
    // 아래 주석 해제 시 오버라이딩 적용
    // void print() {
    //     System.out.println("child");
    // }
}
```

---

### 4. [Ex7_04.java](./src/Ex7_04.java) - 패키지 선언과 사용

- 클래스를 특정 패키지에 묶는 패키지 선언 방식을 다룹니다.
- 패키지는 클래스의 묶음이며 실제 기본 단위는 디렉토리 폴더입니다.

```java
// 패키지 선언 예시
// package com.codechobo.book;
```

---

### 5. [Ex7_05.java](./src/Ex7_05.java) - 접근 제어자(Access Modifier)의 활용

- `private`, `default`, `protected`, `public`의 제어 범위를 실습하는 예제입니다.
- `private` 멤버 변수인 `prv`는 외부 클래스인 `Ex7_05`에서 직접 접근할 수 없으므로 에러가 발생함을 이해합니다.

```java
class Myparent {
    private int prv;     // 같은 클래스 내에서만
    int dft;             // 같은 패키지 내에서만
    protected int prt;   // 같은 패키지 + 다른 패키지의 자손 클래스
    public int pub;      // 접근 제한 없음
}
```

---

### 6. [Ex7_06.java](./src/Ex7_06.java) - 캡슐화(Encapsulation)와 데이터 보호

- `private` 제어자를 사용해 멤버 변수를 보호하고, Getter/Setter 메서드를 통해 데이터의 유효성을 검증하며 간접 접근하는 예제입니다.
- `setHour()`를 사용해 올바르지 않은 값(예: 100)이 주입될 때 값의 변경을 방지합니다.

```java
class Time {
    private int hour;

    public void setHour(int hour) {
        if (hour < 0 || hour > 23) { return; } // 범위 제한
        this.hour = hour;
    }
    public int getHour() { return hour; }
}
```

---

### 7. [Ex7_07.java](./src/Ex7_07.java) - 참조변수의 형변환 (Casting)

- 상속관계에 있는 조상과 자손 클래스 간에 일어나는 형변환 실습 예제입니다.
- 조상 타입으로의 업캐스팅은 생략 가능하며, 자손 타입으로의 다운캐스팅은 반드시 형변환 연산자를 명시해야 합니다.

```java
Car car = null;
FireEngine fe = new FireEngine();
car = fe;              // 업캐스팅 (형변환 생략 가능)
fe2 = (FireEngine)car; // 다운캐스팅 (형변환 생략 불가)
```

---

### 8. [Ex7_08.java](./src/Ex7_08.java) - 매개변수의 다형성

- 메서드의 매개변수 타입을 공통 부모 타입(`Product`)으로 정의함으로써, 개별 제품 클래스마다 `buy()` 메서드를 중복해서 오버로딩할 필요 없이 하나의 메서드로 모든 자손 객체를 처리하는 실습 예제입니다.

```java
class Buyer {
    void buy(Product p) { // Product의 자손 객체(Tv1, Computer 등)를 모두 매개변수로 수용 가능
        money -= p.price;
        bonusPoint += p.bonusPoint;
    }
}
```

---

### 9. [Ex7_09.java](./src/Ex7_09.java) - 여러 종류의 객체를 배열로 다루기

- 조상 타입의 배열(`Product2[]`)을 활용해 서로 다른 자손 객체(`Tv2`, `Computer2`, `Audio2`)들을 하나의 장바구니 배열로 묶어 일괄 관리하고 합산하는 실습 예제입니다.

```java
class Buyer2 {
    Product2[] cart = new Product2[10]; // 다형성 배열
    int i = 0;
    void buy(Product2 p) {
        cart[i++] = p; // 배열에 서로 다른 자손 객체 저장
    }
}
```

---

### 10. [Ex7_10.java](./src/Ex7_10.java) - 추상 클래스(Abstract Class)와 추상 메서드

- `abstract` 제어자가 지정된 미완성 설계도로서의 추상 클래스와 추상 메서드 정의 실습 예제입니다.
- 자손 클래스(`AudioPlayer`)에서 부모인 추상 클래스(`Player`)의 모든 추상 메서드를 강제적으로 오버라이딩하여 구현하도록 함을 실습합니다.

```java
abstract class Player {
    abstract void play(int pos); // 선언부만 있는 추상 메서드
    abstract void stop();
}

class AudioPlayer extends Player {
    void play(int pos) { /* 구현부 작성 */ }
    void stop() { /* 구현부 작성 */ }
}
```

---

## 핵심 비교 요약

| 개념 | 주요 특징 및 주의사항 | 예시 / 범위 |
| :--- | :--- | :--- |
| **상속 (Inheritance)** | `extends` 키워드 사용. 자식은 부모의 모든 멤버를 물려받음. Java는 단일 상속만 지원 | `class SmartTv extends Tv` |
| **is-a 관계** | "A는 B이다" → 상속이 적합 | `SmartTv is a Tv` |
| **has-a 관계** | "A는 B를 가지고 있다" → 포함이 적합 | `Circle has a Point` |
| **오버라이딩 (Overriding)** | 부모의 메서드를 자식이 재정의. 이름·매개변수·반환타입 모두 동일해야 함 | `void print()` 재정의 |
| **오버라이딩 vs 오버로딩** | 오버라이딩: 메서드 재정의 / 오버로딩: 같은 이름 + 다른 매개변수로 중복 정의 | Overriding vs Overloading |
| **private** | 같은 클래스 내에서만 접근 가능 | 클래스 내부 변수 보호 (캡슐화) |
| **default** | 같은 패키지 내에서만 접근 가능 | 제어자 미지정 시 기본 설정 |
| **protected** | 같은 패키지 + 다른 패키지의 자손 클래스에서 접근 가능 | 상속 관계의 클래스 지원 |
| **public** | 제한 없이 어디서나 접근 가능 | 전체 공개 API 및 메인 클래스 |
| **static** | 클래스의, 공통적인. 객체 생성 없이 사용 가능 | 클래스 변수, 클래스 메서드 |
| **final** | 변경 불가능. 상속 불가(클래스), 오버라이딩 불가(메서드), 상수화(변수) | `final class String` |
| **abstract** | 추상적인, 미완성의. 인스턴스 생성 불가, 반드시 자손에서 상속 구현 | `abstract class Player` |
| **import / static import** | 다른 패키지의 클래스 사용 시 패키지명 생략 / static 멤버 호출 시 클래스명 생략 | `import static java.lang.Math.*` |
| **다형성 (Polymorphism)** | 하나의 참조변수로 여러 타입의 객체를 참조하는 성질 | `Car c = new FireEngine();` |
| **형변환 (Casting)** | 상속 관계의 참조변수 간 변환. 업캐스팅(생략 가능) / 다운캐스팅(생략 불가) | `fe = (FireEngine)car;` |
| **instanceof** | 참조변수가 가리키는 인스턴스의 실제 타입을 체크하는 연산자 | `if (car instanceof FireEngine)` |


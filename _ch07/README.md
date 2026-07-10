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

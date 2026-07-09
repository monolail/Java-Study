# 07. 객체지향 프로그래밍 II (OOP II - 상속, 포함, 오버라이딩)

상속(Inheritance)의 개념과 활용, 클래스 간 관계(is-a / has-a), 그리고 메서드 오버라이딩(Overriding)에 대해 실습한 내용을 정리한 공간입니다.

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
// 상속 (is-a): Circle는 Point이다.
class Circle extends Point {
    int r;
}

// 포함 (has-a): Circle는 Point를 가지고 있다.
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

## 핵심 비교 요약

| 개념 | 주요 특징 및 주의사항 | 예시 |
| :--- | :--- | :--- |
| **상속 (Inheritance)** | `extends` 키워드 사용. 자식은 부모의 모든 멤버를 물려받음. Java는 단일 상속만 지원 | `class SmartTv extends Tv` |
| **is-a 관계** | "A는 B이다" → 상속이 적합 | `SmartTv is a Tv` |
| **has-a 관계** | "A는 B를 가지고 있다" → 포함이 적합 | `Circle has a Point` |
| **오버라이딩 (Overriding)** | 부모의 메서드를 자식이 재정의. 이름·매개변수·반환타입 모두 동일해야 함 | `void print()` 재정의 |
| **오버라이딩 vs 오버로딩** | 오버라이딩: 메서드 재정의 / 오버로딩: 같은 이름 + 다른 매개변수로 중복 정의 | Overriding vs Overloading |

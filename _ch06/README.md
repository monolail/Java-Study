# 06. 객체지향 프로그래밍 I (OOP I - 클래스, 객체, 변수, 메서드)

클래스와 객체의 개념, 소스파일 작성 규칙, 인스턴스 변수와 클래스 변수의 차이, 그리고 메서드의 정의와 호출 방법을 실습한 내용을 정리한 공간입니다.

---

## 파일 구성 및 학습 내용

### 1. [Ex06_1.java](./src/Ex06_1.java) - 소스파일 작성 규칙

- **소스파일 명과 클래스**: 소스파일의 이름은 파일 내의 `public class`의 이름과 일치해야 합니다.
- **클래스 선언 제한**: 하나의 소스파일에는 하나의 `public class`만 존재할 수 있으며, `public`이 없는 일반 클래스는 여러 개 정의할 수 있습니다.

```java
public class Ex06_1 { // 파일명과 동일한 public class

}

class Hello2 { }
class Hello3 { }
```

---

### 2. [Ex06_2.java](./src/Ex06_2.java) - 클래스와 객체 (인스턴스)

- **클래스(Class)**: 객체를 정의해 놓은 설계도이며, 객체를 생성하는 데 사용됩니다.
- **객체(Object) / 인스턴스(Instance)**: 클래스로부터 생성된 실제 메모리상의 실체입니다.
- **인스턴스 생성**: `new` 연산자를 사용하여 객체를 생성하고 참조 변수에 저장합니다.
- **멤버 변수와 메서드 사용**: 생성된 객체의 속성(멤버 변수)과 기능(메서드)은 참조 변수를 통해 접근합니다.

```java
class Tv {
    String color;
    boolean power;
    int channel;

    void power() {
        power = !power;
    }

    void channelUp() {
        channel++;
    }

    void channelDown() {
        channel--;
    }
}

public class Ex06_2 {
    public static void main(String[] args) {
        Tv myTv = new Tv();

        myTv.color = "black";
        myTv.channel = 7;

        myTv.power();
        myTv.channelUp();

        System.out.println("The current channel is " + myTv.channel);
    }
}
```

---

### 3. [Ex06_3.java](./src/Ex06_3.java) - 인스턴스 변수와 클래스 변수 (`static`)

- **인스턴스 변수(Instance Variable)**: 인스턴스가 생성될 때마다 생성되므로 객체마다 독립적인 값을 가집니다.
- **클래스 변수(Class Variable)**: `static` 키워드를 사용하며 클래스에 하나만 존재합니다.
- 모든 인스턴스가 동일한 값을 공유하므로, 어떤 객체에서 값을 변경하더라도 모든 객체에 동일하게 반영됩니다.
- 객체 생성 없이 `클래스이름.변수명`으로 접근하는 것이 권장됩니다.

```java
class Card {
    String kind;
    int number;

    static int width = 100;
    static int height = 250;
}

public class Ex06_3 {
    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card();

        c1.kind = "Heart";
        c1.number = 7;

        Card.width = 50;
        Card.height = 125;

        System.out.println("c1 크기 : (" + Card.width + ", " + Card.height + ")");
        System.out.println("c2 크기 : (" + Card.width + ", " + Card.height + ")");
    }
}
```

---

### 4. [Ex06_4.java](./src/Ex06_4.java) - 메서드의 정의와 호출

- **메서드(Method)**: 특정 작업을 수행하는 코드의 묶음입니다.
- **인자(Argument)**: 메서드를 호출할 때 전달하는 실제 값입니다.
- **매개변수(Parameter)**: 메서드 선언부에서 전달받은 값을 저장하는 변수입니다.
- 호출 시 전달하는 인자의 개수와 타입은 매개변수와 일치해야 합니다.

```java
class MyMath {

    long add(long a, long b) {
        return a + b;
    }

    long subtract(long a, long b) {
        return a - b;
    }

    long multiply(long a, long b) {
        return a * b;
    }

    double divide(double a, double b) {
        return Math.round((a / b) * 100.0) / 100.0;
    }

    long max(long a, long b) {
        return a > b ? a : b;
    }
}

public class Ex06_4 {
    public static void main(String[] args) {
        MyMath mm = new MyMath();

        long result = mm.add(5L, 3L);

        System.out.println(result);
    }
}
```

> **Math.round() 활용**
>
> `Math.round()`는 가장 가까운 정수로 반올림하여 `long` 값을 반환합니다.
> 원하는 소수점 자리까지 반올림하려면 10의 거듭제곱을 곱한 뒤 반올림하고 다시 같은 값으로 나누면 됩니다.

```java
double value = 10.1267;
double result = Math.round(value * 100.0) / 100.0;

System.out.println(result); // 10.13
```

---

## 주요 개념 정리

### 1. 반환값 (`return`)

- **`return`문**은 현재 실행 중인 메서드를 종료하고 호출한 메서드로 되돌아갑니다.
- **반환형이 `void`인 경우** 컴파일러가 메서드 마지막에 `return;`을 자동으로 추가해주므로 생략할 수 있습니다.
- **반환형이 `void`가 아닌 경우** 반드시 반환형과 일치하거나 자동 형변환 가능한 값을 반환해야 합니다.

---

### 2. 호출스택 (Call Stack)

- 메서드가 실행되는 동안 필요한 메모리 공간을 제공하는 **스택(Stack)** 구조의 메모리 영역입니다.

**동작 과정**

1. 메서드가 호출되면 호출스택에 메모리가 할당됩니다. (Push)
2. 메서드 수행이 끝나면 메모리가 제거됩니다. (Pop)
3. 호출스택의 맨 위 메서드가 현재 실행 중인 메서드이며, 아래의 메서드는 실행이 끝날 때까지 대기합니다.

예시

```
main()
 ↓
method1()
 ↓
method2()
```

실행 순서

```
main()
 ↓
method1()
 ↓
method2()
 ↑
method1()
 ↑
main()
```

---

### 3. 기본형 매개변수 vs 참조형 매개변수

#### 기본형 매개변수 (Primitive Parameter)

- 값이 복사되어 전달됩니다.
- 메서드 내부에서는 매개변수 값을 변경할 수 있지만 원본 변수는 변경되지 않습니다.

```java
void change(int x) {
    x = 100;
}
```

#### 참조형 매개변수 (Reference Parameter)

- 객체의 참조(주소)가 복사되어 전달됩니다.
- 객체의 멤버 값을 변경하면 원본 객체에도 그대로 반영됩니다.

```java
void change(Data d) {
    d.x = 100;
}
```

---

### 4. static 메서드 vs 인스턴스 메서드

#### 인스턴스 메서드 (Instance Method)

- 인스턴스 변수(iv)를 사용할 수 있습니다.
- 객체를 생성한 후 호출할 수 있습니다.

```java
Tv tv = new Tv();
tv.power();
```

#### static 메서드 (클래스 메서드)

- 객체 생성 없이 호출할 수 있습니다.
- static 변수(cv)는 사용할 수 있지만 인스턴스 변수(iv)와 인스턴스 메서드는 직접 사용할 수 없습니다.
- static 메서드가 메모리에 로드될 때 인스턴스의 존재를 보장할 수 없기 때문입니다.

```java
Math.abs(-10);

MyClass.add(3, 5);
```

---

## 핵심 비교 요약

| 개념 | 주요 특징 및 주의사항 | 예시 |
| :--- | :--- | :--- |
| **클래스(Class)** | 객체를 생성하기 위한 설계도 | `class Tv { }` |
| **객체(Object) / 인스턴스(Instance)** | 클래스로부터 생성된 실제 메모리상의 실체 | `Tv tv = new Tv();` |
| **소스파일 명명 규칙** | `public class` 이름과 파일명이 반드시 일치 | `public class Ex06_1` |
| **인스턴스 변수(iv)** | 객체마다 독립적으로 생성되는 변수 | `tv.channel = 7;` |
| **클래스 변수(cv)** | `static` 사용, 모든 객체가 하나의 값을 공유 | `Card.width = 50;` |
| **메서드 호출** | 객체 또는 클래스 이름을 통해 호출 | `mm.add(5L, 3L)` |
| **`return`** | 메서드 실행을 종료하고 호출한 곳으로 값을 반환 | `return value;` |
| **호출스택(Call Stack)** | 메서드 실행에 필요한 메모리를 스택(LIFO) 구조로 관리 | `main() → method1()` |
| **기본형 매개변수** | 값이 복사되므로 원본 변수는 변경되지 않음 | `void method(int x)` |
| **참조형 매개변수** | 객체의 참조가 복사되며 객체의 멤버를 변경할 수 있음 | `void method(Data d)` |
| **인스턴스 메서드** | 객체 생성 후 호출 가능, 인스턴스 변수 사용 가능 | `tv.power();` |
| **static 메서드** | 객체 생성 없이 호출 가능, static 멤버만 직접 사용 가능 | `Math.abs(-10)` |
| **Math.round() 활용** | 원하는 소수점 자리까지 반올림하려면 10의 거듭제곱을 곱하고 다시 나눔 | `Math.round(val * 100.0) / 100.0` |
| **삼항 연산자** | 간결한 조건식으로 값을 반환할 때 사용 | `a > b ? a : b` |

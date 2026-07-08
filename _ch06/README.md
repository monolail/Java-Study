# 06. 객체지향 프로그래밍 I (OOP I - 클래스, 객체, 변수, 메서드)

클래스와 객체의 개념, 소스파일 작성 규칙, 인스턴스 변수와 클래스 변수의 차이, 메서드의 정의와 호출, 메서드 오버로딩, 생성자를 실습한 내용을 정리한 공간입니다.

---

# 파일 구성 및 학습 내용

## 1. [Ex06_1.java](./src/Ex06_1.java) - 소스파일 작성 규칙

- **소스파일 명과 클래스**: 소스파일의 이름은 파일 내의 `public class`의 이름과 일치해야 합니다.
- **클래스 선언 제한**: 하나의 소스파일에는 하나의 `public class`만 존재할 수 있으며, `public`이 없는 일반 클래스는 여러 개 정의할 수 있습니다.

```java
public class Ex06_1 { }

class Hello2 { }
class Hello3 { }
```

---

## 2. [Ex06_2.java](./src/Ex06_2.java) - 클래스와 객체 (인스턴스)

- **클래스(Class)**: 객체를 정의해 놓은 설계도이며 객체를 생성하는 데 사용됩니다.
- **객체(Object) / 인스턴스(Instance)**: 클래스로부터 생성된 실제 메모리상의 실체입니다.
- **인스턴스 생성**: `new` 연산자를 사용하여 객체를 생성하고 참조 변수에 저장합니다.
- **멤버 변수와 메서드 사용**: 생성된 객체의 속성과 기능은 참조 변수를 통해 접근합니다.

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

## 3. [Ex06_3.java](./src/Ex06_3.java) - 인스턴스 변수와 클래스 변수 (`static`)

- **인스턴스 변수(iv)**: 객체마다 독립적으로 생성되는 변수입니다.
- **클래스 변수(cv)**: `static` 키워드를 사용하며 클래스에 하나만 존재합니다.
- 모든 객체가 동일한 값을 공유합니다.
- 객체 생성 없이 `클래스명.변수명`으로 접근하는 것이 권장됩니다.

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

        System.out.println(Card.width);
        System.out.println(Card.height);
    }
}
```

---

## 4. [Ex06_4.java](./src/Ex06_4.java) - 메서드의 정의와 호출

- **메서드(Method)**: 특정 작업을 수행하는 코드의 묶음입니다.
- **인자(Argument)**: 메서드 호출 시 전달하는 실제 값입니다.
- **매개변수(Parameter)**: 전달받은 값을 저장하는 변수입니다.
- 인자의 개수와 자료형은 매개변수와 일치해야 합니다.

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

---

## 5. [Ex06_5.java](./src/Ex06_5.java) - 메서드 오버로딩 (Method Overloading)

- **메서드 오버로딩**이란 **하나의 클래스 안에서 같은 이름의 메서드를 여러 개 정의하는 것**입니다.
- 메서드 이름은 같지만 **매개변수의 개수 또는 타입이 달라야 합니다.**
- **반환형만 다른 것은 오버로딩이 아닙니다.**
- 전달되는 인자의 타입에 따라 컴파일러가 적절한 메서드를 자동으로 선택합니다.

```java
class MyMath3 {

    int add(int a, int b){
        return a + b;
    }

    long add(int a, long b){
        return a + b;
    }

    float add(float a, float b){
        return a + b;
    }

    int add(int[] a){
        int result = 0;

        for(int i=0; i<a.length; i++){
            result += a[i];
        }

        return result;
    }
}
```

사용 예시

```java
MyMath3 mm = new MyMath3();

mm.add(3,4);
mm.add(3,4L);
mm.add(3.0f,4.0f);
mm.add(new int[]{1,2,3,4,5});
```

---

## 6. [Ex06_6.java](./src/Ex06_6.java) - 생성자 (Constructor)

- **생성자(Constructor)**는 객체가 생성될 때 자동으로 호출되는 특별한 메서드입니다.
- 생성자의 이름은 **클래스 이름과 반드시 동일**해야 합니다.
- **반환형을 가지지 않습니다.**
- 객체 생성 시 필요한 초기값을 설정하는 데 사용됩니다.
- 생성자도 **오버로딩이 가능**합니다.

```java
class Data2 {

    int value;

    Data2(){ }

    Data2(int x){
        value = x;
    }
}
```

사용 예시

```java
Data1 d1 = new Data1();
d1.value = 10;

Data2 d2 = new Data2(20);

System.out.println(d1.value);
System.out.println(d2.value);
```

---

# 주요 개념 정리

## 1. 반환값 (`return`)

- `return`은 메서드를 종료하고 호출한 곳으로 값을 반환합니다.
- `void` 메서드는 `return;`이 생략 가능합니다.
- 반환형이 있는 메서드는 반드시 값을 반환해야 합니다.

---

## 2. 호출스택(Call Stack)

메서드가 실행될 때 사용하는 메모리 공간입니다.

동작 과정

1. 메서드 호출(Push)
2. 메서드 실행
3. 실행 종료(Pop)

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

## 3. 기본형 매개변수 vs 참조형 매개변수

### 기본형 매개변수

- 값이 복사되어 전달됩니다.
- 원본 값은 변경되지 않습니다.

```java
void change(int x){
    x = 100;
}
```

### 참조형 매개변수

- 객체의 주소가 전달됩니다.
- 객체 내부의 값은 변경할 수 있습니다.

```java
void change(Data d){
    d.x = 100;
}
```

---

## 4. static 메서드 vs 인스턴스 메서드

### 인스턴스 메서드

- 객체 생성 후 호출
- 인스턴스 변수 사용 가능

```java
Tv tv = new Tv();
tv.power();
```

### static 메서드

- 객체 생성 없이 호출 가능
- static 멤버만 직접 사용 가능

```java
Math.abs(-10);

MyClass.add(3,5);
```

---

## 5. 메서드 오버로딩

- 같은 이름의 메서드를 여러 개 정의하는 기능입니다.
- 매개변수의 타입이나 개수가 달라야 합니다.
- 코드의 재사용성과 가독성을 높일 수 있습니다.

```java
add(int a, int b)
add(int a, long b)
add(float a, float b)
add(int[] arr)
```

---

## 6. 생성자(Constructor)

- 객체 생성 시 자동으로 호출됩니다.
- 객체의 초기화를 담당합니다.
- 생성자를 하나도 작성하지 않으면 **컴파일러가 기본 생성자(Default Constructor)를 자동 생성**합니다.
- 생성자를 하나라도 직접 작성하면 기본 생성자는 자동 생성되지 않습니다.

```java
Data2 d1 = new Data2();

Data2 d2 = new Data2(20);
```
---

## 7. 생성자에서 `this()`

- `this()`는 **같은 클래스의 다른 생성자를 호출**하는 생성자입니다.
- 생성자 간의 **중복 코드를 줄이기 위해** 사용합니다.
- 반드시 **생성자의 첫 번째 문장**에서만 사용할 수 있습니다.

```java
class Car {
    String color;
    String gearType;
    int door;

    Car() {
        this("white", "auto", 4);
    }

    Car(String color) {
        this(color, "auto", 4);
    }

    Car(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}
```

### 장점

- 생성자마다 같은 초기화 코드를 반복하지 않아도 됩니다.
- 유지보수가 쉬워집니다.

---

## 8. 참조변수 `this`

- `this`는 **현재 객체 자신을 가리키는 참조변수**입니다.
- 인스턴스 메서드와 생성자 내부에서 사용할 수 있습니다.
- **멤버 변수와 지역 변수의 이름이 같을 때** 멤버 변수를 구분하기 위해 자주 사용합니다.

```java
class Car {

    String color;

    Car(String color){
        this.color = color;
    }
}
```

위 코드에서

```java
this.color = color;
```

- `this.color` → 인스턴스 변수
- `color` → 매개변수(지역 변수)

를 의미합니다.

### `this`와 `this()`의 차이

| 구분 | 의미 |
|:---|:---|
| `this` | 현재 객체 자신을 가리키는 참조변수 |
| `this()` | 같은 클래스의 다른 생성자를 호출 |

---

## 9. 변수의 초기화

### 초기화(Initialization)

변수를 사용하기 전에 **처음으로 값을 저장하는 것**을 초기화라고 합니다.

```java
int x = 10;
```

---

### 변수의 종류별 초기화

| 변수 종류 | 자동 초기화 여부 |
|:---|:---|
| 지역 변수(Local Variable) | ❌ 자동 초기화되지 않음 |
| 인스턴스 변수(iv) | ⭕ 기본값으로 자동 초기화 |
| 클래스 변수(cv) | ⭕ 기본값으로 자동 초기화 |

예시

```java
class Test {

    int iv;           // 0
    static int cv;    // 0

    void method(){
        int lv;
        // System.out.println(lv); // 컴파일 오류
    }
}
```

지역 변수는 반드시 직접 초기화해야 합니다.

```java
int lv = 0;
```

---

### 기본값(Default Value)

| 자료형 | 기본값 |
|:---|:---|
| boolean | false |
| char | '\u0000' |
| byte, short, int | 0 |
| long | 0L |
| float | 0.0f |
| double | 0.0 |
| 참조형 | null |

---

### 명시적 초기화(Explicit Initialization)

변수를 선언하면서 직접 값을 저장하는 방법입니다.

```java
class Car{
    String color = "White";
    int door = 4;
}
```

가장 많이 사용하는 초기화 방법입니다.

---

### 초기화 블록(Initialization Block)

객체가 생성될 때마다 공통으로 수행되는 초기화 코드입니다.

#### 인스턴스 초기화 블록

```java
class Car{

    int serial;

    {
        serial = 100;
    }
}
```

객체가 생성될 때마다 실행됩니다.

#### 클래스 초기화 블록

```java
class Car{

    static int width;

    static{
        width = 100;
    }
}
```

클래스가 메모리에 로드될 때 **한 번만 실행**됩니다.

---

### 생성자를 이용한 초기화

객체마다 서로 다른 값을 초기화할 때 가장 많이 사용하는 방법입니다.

```java
class Car{

    String color;
    int door;

    Car(String color, int door){
        this.color = color;
        this.door = door;
    }
}
```

사용 예시

```java
Car c1 = new Car("White", 4);
Car c2 = new Car("Black", 2);
```

---

### 변수 초기화 순서

#### 클래스 변수(cv)

```
기본값
    ↓
명시적 초기화
    ↓
클래스 초기화 블록(static {})
```

#### 인스턴스 변수(iv)

```
기본값
    ↓
명시적 초기화
    ↓
인스턴스 초기화 블록({})
    ↓
생성자
```

생성자가 **가장 마지막에 실행**되므로 최종 초기값을 결정하는 경우가 많습니다.

예시

```java
class Test{

    int x = 10;

    {
        x = 20;
    }

    Test(){
        x = 30;
    }
}
```

최종 결과

```
x = 30
```

# 핵심 비교 요약

| 개념 | 주요 특징 | 예시 |
|:---|:---|:---|
| 클래스(Class) | 객체를 생성하기 위한 설계도 | `class Tv {}` |
| 객체(Object) | 클래스로부터 생성된 실체 | `new Tv()` |
| 인스턴스 변수(iv) | 객체마다 별도로 존재 | `tv.channel` |
| 클래스 변수(cv) | static, 모든 객체가 공유 | `Card.width` |
| 메서드(Method) | 기능을 수행하는 코드 | `add()` |
| 메서드 오버로딩 | 같은 이름, 다른 매개변수 | `add(int,int)` |
| 생성자(Constructor) | 객체 생성 시 자동 호출 | `new Data2(20)` |
| return | 메서드 종료 및 값 반환 | `return value;` |
| 호출스택 | 메서드 실행 순서를 관리 | LIFO 구조 |
| 기본형 매개변수 | 값 복사 | `int x` |
| 참조형 매개변수 | 주소 복사 | `Data d` |
| 인스턴스 메서드 | 객체 생성 후 호출 | `tv.power()` |
| static 메서드 | 객체 생성 없이 호출 | `Math.abs()` |
| Math.round() | 원하는 자리까지 반올림 | `Math.round(x*100)/100` |
| 삼항 연산자 | 간결한 조건식 | `a>b ? a:b` |
| `this` | 현재 객체를 가리키는 참조변수 | `this.color` |
| `this()` | 같은 클래스의 다른 생성자 호출 | `this("white", "auto", 4);` |
| 기본 초기화 | 인스턴스/클래스 변수는 기본값으로 자동 초기화 | `int iv;` |
| 명시적 초기화 | 선언과 동시에 값 저장 | `int x = 10;` |
| 초기화 블록 | 객체 생성 시 공통 초기화 | `{ x = 100; }` |
| 클래스 초기화 블록 | 클래스 로딩 시 한 번 실행 | `static {}` |
| 생성자 초기화 | 객체마다 다른 값으로 초기화 | `new Car("Black",2)` |
| 변수 초기화 순서 | 기본값 → 명시적 초기화 → 초기화 블록 → 생성자 | 생성자가 마지막 실행 |

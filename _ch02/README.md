# 변수와 타입 (Variables & Types)

이 디렉토리는 Java의 기초인 **변수(Variable)**, **상수(Constant)**, **화면 입출력**, 그리고 **다양한 리터럴(Literal) 타입**의 활용을 학습한 내용을 정리한 공간입니다.

---

## 파일 구성 및 핵심 요약

### 1. [VarEx1.java](./src/VarEx1.java) - 변수의 선언과 초기화

* **변수(Variable)**: 단 하나의 값을 저장할 수 있는 메모리 공간입니다.
* **선언과 초기화**: 변수를 사용하기 전에 반드시 선언하여 메모리 공간을 확보하고, 처음으로 값을 저장하는 초기화 과정을 거쳐야 합니다.

```java
int age;      // 변수 선언
age = 15;     // 변수 초기화
int age = 15; // 선언과 초기화를 동시에 진행
```

---

### 2. [VarEx2.java](./src/VarEx2.java) - 상수와 리터럴

#### 상수(Constant)

* **상수(Constant)**는 변수와 달리 **한 번만 값을 저장할 수 있는 메모리 공간**입니다.
* 선언 시 자료형 앞에 `final` 키워드를 사용합니다.
* 상수명은 관례상 **모두 대문자**로 작성하며, 여러 단어는 `_`로 구분합니다.

```java
final int SCORE = 100;
```

#### 리터럴(Literal)

* **리터럴(Literal)**은 코드에 직접 작성된 **값 그 자체**를 의미합니다.
* 기존에 일반적으로 "상수"라고 부르던 `100`, `3.14`, `"Hello"`와 같은 값들을 Java에서는 **리터럴**이라고 부릅니다.

```java
int score = 100;      // 100은 정수 리터럴
double pi = 3.14;     // 3.14는 실수 리터럴
char grade = 'A';     // 'A'는 문자 리터럴
String name = "Java"; // "Java"는 문자열 리터럴
```

#### 리터럴 접미사

* `long` 타입 리터럴 뒤에는 `L` 또는 `l`을 붙여야 합니다.

```java
long population = 10_000_000_000L;
```

* `float` 타입 리터럴 뒤에는 `f` 또는 `F`를 붙여야 합니다.

```java
float temperature = 36.5f;
```

* 접미사가 없는 실수 리터럴은 기본적으로 `double` 타입으로 처리됩니다.

```java
double value = 3.14;
```

#### 진법 표현

* `0`으로 시작하면 **8진수**
* `0x` 또는 `0X`로 시작하면 **16진수**

```java
int octal = 010;    // 10진수 8
int hex = 0x10;     // 10진수 16
```

### 3. [ScanEx1.java](./src/ScanEx1.java) - 화면에서 입력받기

* **Scanner 클래스**를 사용하면 콘솔 환경에서 사용자로부터 데이터를 입력받을 수 있습니다.
* `Scanner`를 사용하기 위해서는 `java.util.Scanner` 패키지를 import 해야 합니다.
* 입력받는 데이터의 타입에 따라 `nextInt()`, `nextDouble()`, `nextLine()` 등의 메서드를 사용합니다.

```java
import java.util.Scanner; // Scanner 사용을 위해 필수 import

Scanner scan = new Scanner(System.in);

int num1 = scan.nextInt(); // 사용자로부터 정수를 입력받아 변수에 저장
```

#### 자주 사용하는 입력 메서드

| 메서드            | 입력 데이터 타입     |
| -------------- | ------------- |
| `nextInt()`    | 정수 (`int`)    |
| `nextDouble()` | 실수 (`double`) |
| `next()`       | 공백 전까지의 문자열   |
| `nextLine()`   | 한 줄 전체 문자열    |

---

### 4. [App.java](./src/App.java) - 화면 출력과 사칙연산

#### 정수 나눗셈과 실수 나눗셈

* **정수와 정수의 연산 결과는 항상 정수**입니다.
* 나눗셈의 경우 **소수점 이하는 버려집니다.**

```java
System.out.println(10 / 3); // 결과: 3
```

* 피연산자 중 하나라도 **실수 타입**이라면 연산 결과는 **실수**가 됩니다.

```java
System.out.println(10.0 / 3); // 결과: 3.3333333333333335
System.out.println(10 / 3.0); // 결과: 3.3333333333333335
```

#### 형식화된 출력 (`printf`)

* `printf()` 메서드를 사용하면 원하는 형식으로 데이터를 출력할 수 있습니다.
* `%d`, `%f`, `%s` 등의 서식 지정자를 사용합니다.

```java
int age = 20;
double score = 95.5;
String name = "Java";

System.out.printf("이름: %s\n", name);
System.out.printf("나이: %d세\n", age);
System.out.printf("점수: %.2f점\n", score);
```

#### 자주 사용하는 서식 지정자

| 서식 지정자 | 의미             |
| ------ | -------------- |
| `%d`   | 정수 출력          |
| `%f`   | 실수 출력          |
| `%.2f` | 소수점 둘째 자리까지 출력 |
| `%c`   | 문자 출력          |
| `%s`   | 문자열 출력         |
| `%n`   | 줄바꿈            |

#### 출력 메서드 비교

```java
System.out.print("Hello");
System.out.println(" Java");
System.out.printf("점수: %d점", 100);
```

| 메서드         | 특징          |
| ----------- | ----------- |
| `print()`   | 줄바꿈 없이 출력   |
| `println()` | 출력 후 자동 줄바꿈 |
| `printf()`  | 형식을 지정하여 출력 |

```
```

## 추가 공부 : 입출력 기능의 차이점

### 1. 입력 (Scanner 클래스)

`java.util.Scanner`는 화면, 파일 등 다양한 입력 소스로부터 문자나 숫자 데이터를 읽어오고 파싱하기 위해 제공되는 클래스입니다.

#### 객체 생성

```java
Scanner scan = new Scanner(System.in);
```

* `System.in`은 **콘솔 입력 스트림(Standard Input Stream)** 을 의미합니다.
* 사용자가 키보드로 입력한 데이터를 읽어올 수 있습니다.

#### 주요 메서드

| 메서드            | 설명                             | 예시 입력         | 반환값             |
| -------------- | ------------------------------ | ------------- | --------------- |
| `nextInt()`    | 다음 토큰을 `int` 타입으로 읽음           | `100`         | `100`           |
| `nextDouble()` | 다음 토큰을 `double` 타입으로 읽음        | `3.14`        | `3.14`          |
| `next()`       | 공백(스페이스, 탭, 엔터) 전까지 문자열 하나를 읽음 | `Hello World` | `"Hello"`       |
| `nextLine()`   | 엔터 입력 전까지 한 줄 전체를 읽음           | `Hello World` | `"Hello World"` |

#### 예제

```java
import java.util.Scanner;

Scanner scan = new Scanner(System.in);

int age = scan.nextInt();
double score = scan.nextDouble();
String name = scan.next();
String sentence = scan.nextLine();
```

---

### 2. 출력 (`print`, `println`, `printf`)

Java에서는 표준 출력 스트림인 `System.out`을 이용하여 콘솔에 데이터를 출력합니다.

| 메서드                    | 줄바꿈 여부 | 서식 지정(포맷팅) | 설명                         |
| ---------------------- | ------ | ---------- | -------------------------- |
| `System.out.print()`   | ❌      | ❌          | 출력 후 줄바꿈 없이 다음 출력문과 이어서 출력 |
| `System.out.println()` | ✅      | ❌          | 출력 후 자동으로 줄바꿈 수행           |
| `System.out.printf()`  | ❌      | ✅          | 원하는 형식으로 데이터를 출력           |

#### `print()` 예제

```java
System.out.print("Hello ");
System.out.print("Java");
```

출력 결과

```text
Hello Java
```

---

#### `println()` 예제

```java
System.out.println("Hello");
System.out.println("Java");
```

출력 결과

```text
Hello
Java
```

---

#### `printf()` 예제

```java
int age = 15;
double score = 95.5;

System.out.printf("나이: %d세, 성적: %.1f%n", age, score);
```

출력 결과

```text
나이: 15세, 성적: 95.5
```

* `printf()`는 자동 줄바꿈을 수행하지 않습니다.
* 줄바꿈이 필요하다면 `%n` 또는 `\n`을 직접 추가해야 합니다.

---

## printf 주요 지시자 (Format Specifier)

| 지시자    | 의미                                 | 예시         |
| ------ | ---------------------------------- | ---------- |
| `%d`   | 10진수 정수 (Decimal)                  | `100`      |
| `%o`   | 8진수 정수 (Octal)                     | `010`      |
| `%x`   | 16진수 정수 (Hexadecimal, 소문자)         | `0xff`     |
| `%X`   | 16진수 정수 (Hexadecimal, 대문자)         | `0xFF`     |
| `%f`   | 실수 (Floating-point)                | `3.141592` |
| `%.2f` | 소수점 둘째 자리까지 출력                     | `3.14`     |
| `%s`   | 문자열 (String)                       | `"Java"`   |
| `%c`   | 문자 (Character)                     | `'A'`      |
| `%n`   | 줄바꿈 (Platform-independent Newline) | 개행         |
| `%%`   | `%` 문자 자체 출력                       | `%`        |

### 예제

```java
int num = 255;
double pi = 3.141592;
char grade = 'A';
String language = "Java";

System.out.printf("%d%n", num);          // 255
System.out.printf("%o%n", num);          // 377
System.out.printf("%x%n", num);          // ff
System.out.printf("%.2f%n", pi);         // 3.14
System.out.printf("%c%n", grade);        // A
System.out.printf("%s%n", language);     // Java
System.out.printf("정답률: %.1f%%%n", 95.5); // 95.5%
```

# 06. 객체지향 프로그래밍 I (OOP I - 클래스, 객체, 변수, 메서드)

클래스와 객체의 개념, 소스파일 작성 규칙, 인스턴스 변수와 클래스 변수의 차이, 그리고 메서드의 정의와 호출 방법을 실습한 내용을 정리한 공간입니다.

---

## 파일 구성 및 학습 내용

### 1. [Ex06_1.java](./src/Ex06_1.java) - 소스파일 작성 규칙

- **소스파일 명과 클래스**: 소스파일의 이름은 파일 내의 `public class`의 이름과 일치해야 합니다.
- **클래스 선언 제한**: 하나의 소스파일 내에는 단 하나의 `public class`만 존재할 수 있으며, `public`이 없는 일반 클래스는 여러 개 정의할 수 있습니다.
  ```java
  public class Ex06_1 { // 파일명과 동일한 public class

  }

  class hello2{} // public이 없으므로 작성 가능
  class hello3{} 
  ```

---

### 2. [Ex06_2.java](./src/Ex06_2.java) - 클래스와 객체 (인스턴스)

- **클래스(Class)**: 객체를 정의해 놓은 설계도이며, 객체를 생성하는 데 사용됩니다.
- **인스턴스(Instance) 생성**: `new` 연산자를 사용하여 메모리에 객체를 생성하고 참조 변수에 대입합니다.
- **멤버 변수와 메서드 사용**: 생성된 객체의 속성(멤버 변수)과 기능(메서드)은 참조 변수를 통해 접근합니다.
  ```java
  class Tv {
      String color;
      boolean power;
      int channel;

      void power() { power = !power; }
      void channelup() { channel += 1; }
      void channeldown() { channel -= 1; }
  }

  public class Ex06_2 {
      public static void main(String[] args) {
          Tv myTv = new Tv(); // 인스턴스 생성
          myTv.color = "black";
          myTv.channel = 7;
          myTv.power();
          myTv.channelup(); // 채널 8로 변경

          System.out.println("The current channel is " + myTv.channel); // 8 출력
      }
  }
  ```

---

### 3. [Ex06_3.java](./src/Ex06_3.java) - 인스턴스 변수와 클래스 변수 (static)

- **인스턴스 변수(Instance Variable)**: 인스턴스가 생성될 때마다 생성되므로 인스턴스마다 독립적인 저장공간을 가집니다.
- **클래스 변수(Class Variable / `static`)**: 모든 인스턴스가 공통된 저장공간을 공유하므로, 한 인스턴스에서 값을 변경하면 모든 인스턴스가 영향을 받습니다. 객체 생성 없이 `클래스이름.변수명`으로 접근 가능합니다.
  ```java
  class Card {
      String kind;       // 인스턴스 변수 (개별 속성)
      int number;        // 인스턴스 변수
      static int width = 100;  // 클래스 변수 (공통 속성)
      static int height = 250; // 클래스 변수
  }

  public class Ex06_3 {
      public static void main(String[] args) {
          Card c1 = new Card();
          Card c2 = new Card();

          c1.kind = "Heart";
          c1.number = 7;

          // 클래스 변수 값 변경 (공통 적용)
          Card.width = 50;
          Card.height = 125;

          System.out.println("c1 크기: (" + c1.width + ", " + c1.height + ")"); // (50, 125)
          System.out.println("c2 크기: (" + c2.width + ", " + c2.height + ")"); // (50, 125)
      }
  }
  ```

---

### 4. [Ex06_4.java](./src/Ex06_4.java) - 메서드의 정의와 호출

- **메서드(Method)**: 특정 작업을 수행하는 일련의 코드 블록으로, 선언부와 구현부로 구성됩니다.
- **인자(Argument)와 매개변수(Parameter)**: 메서드를 호출할 때 전달하는 인수와 메서드에서 받아들이는 매개변수의 타입 및 개수가 일치해야 합니다.
- **`Math.round()`를 이용한 실수의 특정 자릿수 반올림**: 소수점 첫째 자리에서 반올림해 정수를 반환하므로, 원하는 자릿수 표기를 위해 `10^n`을 곱한 뒤 반올림하고 다시 `10^n`의 실수형(`double`)으로 나눕니다.
  ```java
  class MyMath {
      long add(long a, long b) { return a + b; }
      long subtract(long a, long b) { return a - b; }
      long multiply(long a, long b) { return a * b; }
      
      // 소수점 둘째 자리까지 반올림 표현
      double divide(double a, double b) {
          return Math.round((a / b) * 100.0) / 100.0;
      }
      
      long maxgap(long a, long b) {
          return a > b ? a : b; // 삼항 연산자를 이용한 최댓값 반환
      }
  }
  ```

---

## 핵심 비교 요약

| 개념 | 주요 특징 및 주의사항 | 예시 |
| :--- | :--- | :--- |
| **소스파일 명명 규칙** | `public class` 명과 반드시 일치해야 함. 하나의 파일에 하나의 `public class`만 가능 | `public class Ex06_1` |
| **인스턴스 변수 (iv)** | 인스턴스 생성 시마다 개별 생성, 인스턴스 고유 속성 저장 | `c1.kind = "Heart"` |
| **클래스 변수 (cv)** | `static` 키워드 사용. 모든 인스턴스가 공통 값을 공유 | `Card.width = 50` |
| **메서드 호출** | 참조변수를 통해 메서드 명에 맞춰 알맞은 인자를 전달 | `mm.add(5L, 3L)` |
| **Math.round() 응용** | 특정 소수점 아래 자릿수를 얻기 위해 10의 거듭제곱 곱셈/나눗셈 활용 | `Math.round(val * 100.0) / 100.0` |
| **삼항 연산자** | 간결한 조건 분기로 최댓값/최소값 반환 시 유용 | `a > b ? a : b` |

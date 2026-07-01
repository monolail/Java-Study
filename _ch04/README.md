# 04. 조건문과 반복문 (Conditions & Loops)

조건문(if, switch)과 반복문(for, while, do-while)의 구조와 흐름 제어 방법, 그리고 break / continue를 활용한 반복 제어를 학습한 내용을 정리한 공간입니다.

---

## 파일 구성 및 학습 내용

### 1. [Ex4_1.java](./src/Ex4_1.java) - 조건문 if / else if / else

- **`if`문**: 조건식이 `true`일 때만 블록을 실행합니다.
- **`if-else if-else`**: 여러 조건을 순서대로 검사하여 처음으로 `true`인 블록을 실행합니다.
  ```java
  int score = 85;

  if (score >= 90) {
      System.out.println("A");
  } else if (score >= 80) {
      System.out.println("B");   // 출력
  } else {
      System.out.println("C");
  }
  ```

---

### 2. [Ex4_2.java](./src/Ex4_2.java) - 조건문 switch

- **`switch`문**: 하나의 변수 값에 따라 여러 `case`로 분기하며, `if-else if`보다 가독성이 높습니다.
- **fall-through**: `break`를 생략하면 다음 `case`까지 연속 실행됩니다.
  ```java
  int month = 4;

  switch (month) {
      case 3: case 4: case 5:
          System.out.println("봄");   // 출력
          break;
      case 6: case 7: case 8:
          System.out.println("여름");
          break;
      default:
          System.out.println("가을/겨울");
          break;
  }
  ```

---

### 3. [Ex4_3.java](./src/Ex4_3.java) - 반복문 for

- **`for`문**: 초기화식·조건식·증감식의 세 부분으로 구성되며, 반복 횟수가 명확할 때 사용합니다.
- **중첩 `for`문**: 이중 반복으로 다차원 패턴(구구단 등)을 처리합니다.
  ```java
  // 중첩 for문 - 구구단
  for (int i = 2; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
          System.out.printf("%d × %d = %2d%n", i, j, i * j);
      }
  }
  ```

---

### 4. [Ex4_4.java](./src/Ex4_4.java) - 반복문 while / do-while

- **`while`문 (선검사)**: 조건식을 먼저 확인하여 `false`이면 한 번도 실행하지 않습니다.
- **`do-while`문 (후검사)**: 블록을 먼저 실행한 뒤 조건을 확인하므로 **최소 1회 실행이 보장**됩니다.
  ```java
  // while - 선검사
  int i = 0;
  while (i < 5) {
      System.out.println(i++);
  }

  // do-while - 후검사 (최소 1회 보장)
  int j = 10;
  do {
      System.out.println("최소 1회 실행");
  } while (j < 5);
  ```

---

### 5. [Ex4_5.java](./src/Ex4_5.java) - 분기문 break / continue

- **`break`**: 현재 반복문을 즉시 탈출합니다. **이름 붙은 반복문(labeled loop)** 과 함께 사용하면 중첩 루프를 한 번에 탈출할 수 있습니다.
- **`continue`**: 이후 코드를 건너뛰고 다음 반복으로 넘어갑니다.
  ```java
  // continue - 홀수만 출력
  for (int i = 1; i <= 10; i++) {
      if (i % 2 == 0) continue;
      System.out.println(i);
  }

  // labeled break - 중첩 루프 전체 탈출
  outer:
  for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
          if (j == 1) break outer;
          System.out.println(i + ", " + j);
      }
  }
  ```

---

## 핵심 비교 요약

| 개념 | 주요 특징 및 주의사항 | 예시 |
| :--- | :--- | :--- |
| **`if-else if`** | 조건을 순서대로 검사, 처음 `true`인 블록만 실행 | `if (a > 0) {...}` |
| **`switch`** | 단일 변수 값 기반 다중 분기, `break` 누락 시 fall-through | `switch (x) { case 1: ... }` |
| **`for`** | 초기화·조건·증감을 한 줄에 명시, 횟수 기반 반복 | `for (int i=0; i<5; i++)` |
| **`while`** | 선검사, 조건이 처음부터 `false`이면 0회 실행 | `while (x > 0) {...}` |
| **`do-while`** | 후검사, 최소 1회 실행 보장 | `do {...} while (x > 0);` |
| **`break`** | 반복문 즉시 탈출, label과 조합 시 중첩 루프 탈출 가능 | `break outer;` |
| **`continue`** | 현재 반복의 나머지를 건너뛰고 다음 반복으로 이동 | `if (i%2==0) continue;` |


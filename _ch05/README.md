# 05. 배열 (Array)

배열(Array)의 선언과 생성, 초기화 방법, 그리고 배열을 활용한 데이터 처리(합계, 평균, 최대/최솟값)와 String 배열을 이용한 간단한 실습 프로그램을 학습한 내용을 정리한 공간입니다.

---

## 파일 구성 및 학습 내용

### 1. [Ex5_1.java](./src/Ex5_1.java) - 배열의 선언과 생성

- **배열 선언**: `int[] score;` — 배열을 가리키는 참조 변수를 선언합니다.
- **배열 생성**: `score = new int[5];` — 실제 메모리에 배열 공간을 할당합니다.
- **기본값 초기화**: 배열 생성 시 각 요소는 해당 타입의 기본값(`int`는 `0`)으로 자동 초기화됩니다.
- **인덱스 접근**: 배열 요소는 `score[0]`처럼 0부터 시작하는 인덱스로 접근합니다.
  ```java
  int[] score;          // 배열 참조 변수 선언
  score = new int[5];   // int 타입 5칸짜리 배열 생성 (기본값 0으로 초기화)

  score[0] = 100;       // 첫 번째 요소에 값 저장
  System.out.println("score[0] : " + score[0]); // 100
  System.out.println("score[1] : " + score[1]); // 0 (기본값)
  ```

---

### 2. [Ex5_2.java](./src/Ex5_2.java) - 배열 초기화와 Arrays.toString()

- **배열 초기화**: `new int[]{100, 90, 80, 70, 60}` 형태로 생성과 동시에 값을 지정할 수 있습니다.
- **`score.length`**: 배열의 길이(요소 개수)를 반환하는 속성입니다.
- **`Arrays.toString()`**: 배열의 내용을 `[100, 90, 80, ...]` 형태의 문자열로 변환하여 출력합니다.
- **`char` 배열의 특성**: `char[]`는 `System.out.println()`으로 출력하면 주소가 아닌 **배열의 내용(문자열)** 이 그대로 출력됩니다.
  ```java
  int[] score = new int[]{100, 90, 80, 70, 60};

  System.out.println(score.length);           // 5
  System.out.println(score);                  // 주소값 출력 (예: [I@15db9742)
  System.out.println(Arrays.toString(score)); // [100, 90, 80, 70, 60]

  char[] chArr = {'a', 'b', 'c', 'd', 'e'};
  System.out.println(chArr);                  // abcde  (char 배열은 내용 직접 출력)
  System.out.println(Arrays.toString(chArr)); // [a, b, c, d, e]
  ```

---

### 3. [Ex5_3.java](./src/Ex5_3.java) - 배열 활용 (합계, 평균, 최대/최솟값)

- **총합과 평균**: `for`문으로 배열을 순회하며 누적 합산 후, `(double)sum / score.length`로 평균을 구합니다.
- **최대/최솟값**: 첫 번째 요소를 기준값으로 설정한 뒤, 순회하며 조건 비교로 갱신합니다.
  ```java
  int[] score = {100, 90, 80, 70, 60};

  // 총합과 평균
  int sum = 0;
  for (int i = 0; i < score.length; i++) {
      sum += score[i];
  }
  System.out.println("총합 : " + sum);                          // 400
  System.out.println("평균 : " + (double) sum / score.length); // 80.0

  // 최대/최솟값
  int max = score[0];
  int min = score[0];
  for (int i = 0; i < score.length; i++) {
      if (max < score[i]) max = score[i];
      if (min > score[i]) min = score[i];
  }
  System.out.println("최대값 : " + max); // 100
  System.out.println("최소값 : " + min); // 60
  ```

---

### 4. [Ex5_4.java](./src/Ex5_4.java) - String 배열과 실습 (가위바위보 게임)

- **`String` 배열**: 문자열도 배열로 관리할 수 있으며, `Arrays.toString()`으로 내용을 확인합니다.
- **배열 인덱스 활용**: 사용자 입력값(1~3)에서 1을 빼 배열 인덱스(0~2)로 변환하는 방식을 이해합니다.
- **`.equals()` 문자열 비교**: `String`의 값 비교는 `==` 대신 **`.equals()`** 를 사용해야 합니다.
- **실전 프로그램**: `Math.random()`으로 컴퓨터 패를 랜덤 선택하고, 10회 반복 가위바위보 게임에서 승리 횟수를 집계합니다.
  ```java
  String[] strArr = {"가위", "바위", "보"};
  int wincount = 0;

  for (int i = 0; i < 10; i++) {
      int userInput = sc.nextInt();
      int userIndex = userInput - 1;  // 입력값(1~3) → 인덱스(0~2) 변환

      int tmp = (int)(Math.random() * 3); // 컴퓨터 랜덤 선택

      if (strArr[userIndex].equals(strArr[tmp])) {
          System.out.println("비겼습니다.");
      } else if (...) {
          System.out.println("졌습니다.");
      } else {
          wincount++;
          System.out.println("이겼습니다.");
      }
  }
  System.out.println("승리 횟수 : " + wincount);
  ```

---

## 핵심 비교 요약

| 개념 | 주요 특징 및 주의사항 | 예시 |
| :--- | :--- | :--- |
| **배열 선언** | 참조 변수만 선언, 실제 메모리 미할당 | `int[] score;` |
| **배열 생성** | `new` 키워드로 실제 메모리 할당, 기본값 초기화 | `score = new int[5];` |
| **배열 초기화** | 선언과 동시에 값 지정 가능 | `int[] score = {100, 90, 80};` |
| **`length`** | 배열의 요소 개수 반환 (속성, 메서드 아님) | `score.length` → `5` |
| **`Arrays.toString()`** | 배열 내용을 문자열로 변환하여 출력 | `[100, 90, 80, 70, 60]` |
| **`char[]` 출력** | `println()` 시 주소가 아닌 내용이 직접 출력 | `abcde` |
| **`.equals()`** | `String` 값 비교 시 `==` 대신 사용 필수 | `"가위".equals(strArr[tmp])` |

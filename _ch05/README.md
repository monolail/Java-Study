# 05. 배열 (Array)

배열(Array)의 선언과 생성, 초기화 방법, 배열을 활용한 데이터 처리(합계, 평균, 최대/최솟값), 2차원 배열, String 주요 메서드, 그리고 Arrays 유틸리티 메서드까지 학습한 내용을 정리한 공간입니다.

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

### 5. [Ex5_5.java](./src/Ex5_5.java) - 2차원 배열 (선언, 생성, 순회)

- **2차원 배열 선언**: `int[][] score` — 행(row)과 열(column)로 구성된 배열입니다.
- **`score.length`**: 행의 수(바깥 배열의 크기)를 반환합니다.
- **`score[i].length`**: i번째 행의 열의 수를 반환합니다.
- **중첩 `for`문**으로 각 요소를 `score[i][j]` 형태로 접근하여 전체 합계와 평균을 구합니다.
  ```java
  int[][] score = {
      {100, 90, 80, 70, 60},
      { 90, 80, 70, 60, 50},
      { 80, 70, 60, 50, 40}
  };

  int sum = 0, num = 0;
  for (int i = 0; i < score.length; i++) {        // 행 순회
      for (int j = 0; j < score[i].length; j++) { // 열 순회
          sum += score[i][j];
          num++;
      }
  }
  System.out.println("sum is " + sum);        // 750
  System.out.println("total mean is " + sum/num); // 50
  ```

---

### 6. [Ex5_6.java](./src/Ex5_6.java) - 2차원 String 배열 활용 (영단어 퀴즈)

- **2차원 `String` 배열**: `words[i][0]`에 영단어, `words[i][1]`에 한글 뜻을 저장하는 구조입니다.
- **실전 프로그램**: 한글 뜻을 보여주고 영단어를 맞추는 퀴즈 게임으로, `.equals()`로 정답을 비교합니다.
  ```java
  String[][] words = {
      {"chair",   "의자"},
      {"computer", "컴퓨터"},
      {"integer",  "정수"}
  };

  for (int i = 0; i < words.length; i++) {
      System.out.printf("Q%d. %s의 영어는 무엇인가?\n", i+1, words[i][1]);
      String tmp = sc.nextLine();
      if (tmp.equals(words[i][0])) {
          System.out.printf("정답입니다.%n");
      } else {
          System.out.printf("틀렸습니다. 정답은 %s입니다.%n", words[i][0]);
      }
  }
  ```

---

### 7. [Ex5_7.java](./src/Ex5_7.java) - String 주요 메서드

- **`charAt(index)`**: 문자열에서 특정 인덱스에 있는 문자 하나를 `char` 타입으로 반환합니다.
- **`substring(start, end)`**: 문자열의 `start` 인덱스부터 `end-1` 인덱스까지의 부분 문자열을 반환합니다 (끝 인덱스 미포함).
  ```java
  // 인덱스:  0 1 2 3 4
  String str = "ABCDE";

  char ch = str.charAt(4);       // 'E' (인덱스 4번 문자)
  System.out.println(ch);        // E

  String str2 = str.substring(1, 4); // 인덱스 1 ~ 3 → "BCD"
  System.out.println(str2);          // BCD
  ```

---

### 8. [Ex5_8.java](./src/Ex5_8.java) - Arrays 유틸리티 메서드

- **`Arrays.sort(arr)`**: 배열을 오름차순으로 정렬합니다.
- **`Arrays.deepToString(arr)`**: 2차원 이상의 다차원 배열 내용을 문자열로 출력합니다.
- **`Arrays.deepEquals(a, b)`**: 다차원 배열의 실제 값을 재귀적으로 비교합니다. (`Arrays.equals()`는 참조 주소 비교라 2차원 배열에 부적합)
- **`Arrays.copyOf(arr, len)`**: 배열의 앞에서부터 `len`개만큼 복사한 새 배열을 반환합니다.
- **`Arrays.copyOfRange(arr, from, to)`**: `from` 인덱스부터 `to-1` 인덱스까지 복사한 새 배열을 반환합니다.
  ```java
  int[] arr = {1, 4, 5, 2, 3};

  Arrays.sort(arr);
  System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5]

  String[][] str2DD  = {{"aaa","bbb"},{"AAA","BBB"}};
  String[][] str2DD2 = {{"aaa","bbb"},{"AAA","BBB"}};
  System.out.println(Arrays.deepToString(str2DD));        // [[aaa, bbb], [AAA, BBB]]
  System.out.println(Arrays.deepEquals(str2DD, str2DD2)); // true
  // Arrays.equals(str2DD, str2DD2) → false (참조 주소 비교이므로)

  int[] arr2 = Arrays.copyOf(arr, 3);          // [1, 2, 3]
  int[] arr3 = Arrays.copyOfRange(arr, 1, 4);  // [2, 3, 4]
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
| **2차원 배열** | `arr[i][j]`로 접근, `arr.length`=행, `arr[i].length`=열 | `int[][] arr = {{1,2},{3,4}};` |
| **`charAt()`** | 특정 인덱스의 문자 하나를 `char`로 반환 | `"ABCDE".charAt(4)` → `'E'` |
| **`substring()`** | 시작 인덱스 ~ 끝 인덱스-1 까지 부분 문자열 반환 | `"ABCDE".substring(1,4)` → `"BCD"` |
| **`Arrays.sort()`** | 배열 오름차순 정렬 (원본 배열 직접 변경) | `Arrays.sort(arr)` |
| **`Arrays.deepEquals()`** | 다차원 배열 값 재귀 비교 (`equals()`는 참조 비교라 부적합) | `Arrays.deepEquals(a, b)` |
| **`Arrays.copyOf()`** | 앞에서부터 지정 길이만큼 복사한 새 배열 반환 | `Arrays.copyOf(arr, 3)` |
| **`Arrays.copyOfRange()`** | 지정 범위(from~to-1)만큼 복사한 새 배열 반환 | `Arrays.copyOfRange(arr, 1, 4)` |

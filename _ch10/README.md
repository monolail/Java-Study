# 10. 날짜와 시간, 형식화 (Date, Time, & Formatting)

자바에서 날짜와 시간을 다루기 위한 **Calendar 클래스**와 데이터를 원하는 형식의 문자열로 변환/역변환해주는 **형식화 클래스(SimpleDateFormat, DecimalFormat)** 개념을 정리한 공간입니다.

---

## 💡 주요 개념 정리

### 1. Calendar 클래스
- **정의**: 자바에서 날짜와 시간 정보를 관리하고 조작하는 데 사용되는 대표적인 추상 클래스입니다.
- **특징**:
  - 추상 클래스이므로 `new Calendar()` 형태로 인스턴스를 생성할 수 없으며, `Calendar.getInstance()`를 통해 현재 시스템의 국가/지역 정보를 반영한 자손 클래스의 인스턴스를 얻어와 사용합니다.
- **주요 필드와 주의사항**:
  - `Calendar.YEAR`: 연도
  - `Calendar.MONTH`: 월. **중요: 월은 0부터 시작**하므로, 출력하거나 값을 다룰 때는 반드시 `+ 1` 처리를 해야 올바른 월(1~12월)을 얻을 수 있습니다 (0 = 1월, 11 = 12월).
  - `Calendar.DATE` 또는 `Calendar.DAY_OF_MONTH`: 일
  - `Calendar.DAY_OF_WEEK`: 요일. **일요일(1)부터 토요일(7)**까지 정수 형태로 반환됩니다.
- **날짜 설정 및 추출**:
  - `get(int field)`: 특정 필드(연도, 월, 일 등)의 값을 정수로 추출합니다.
  - `set(int year, int month, int date)`: 특정 날짜로 Calendar 인스턴스의 값을 강제 재설정합니다.
  - `getActualMaximum(int field)`: 특정 필드가 가질 수 있는 최댓값을 구합니다 (예: 해당 월의 마지막 날짜인 28, 30, 31일 등).

### 2. SimpleDateFormat 클래스
- **정의**: 날짜 객체(`Date`)를 원하는 형식 문자열로 가시화하여 출력하거나, 반대로 형식 문자열을 `Date` 객체로 분석(파싱)해내는 데 사용되는 형식화 클래스입니다.
- **사용 예시**:
  - `new SimpleDateFormat("yyyy-MM-dd E")` : `2026-07-23 목` 형태로 포맷팅 패턴을 적용합니다.
  - `df.format(cal.getTime())`: Calendar 인스턴스의 Date 객체를 넘겨받아 문자열 형태로 변환합니다.

### 3. DecimalFormat 클래스
- **정의**: 숫자 데이터를 원하는 형식(콤마 분리, 소수점 표기, 퍼센트 등)으로 포맷팅하여 문자열로 변환하거나, 포맷팅된 문자열을 다시 `Number` 타입의 숫자로 역파싱할 때 사용하는 형식화 클래스입니다.
- **주요 패턴**:
  - `#`: 10진수 숫자 한 자리를 표현 (값이 없으면 표시 안 함)
  - `0`: 10진수 숫자 한 자리를 표현 (값이 없으면 0으로 채움)
  - `,`: 그룹 구분 기호 (예: `#,###`)
  - `.`: 소수점 표현 기호 (예: `#.##`)
- **문자열 -> 숫자 변환**:
  - `df.parse(String source)`: 콤마가 들어간 포맷의 문자열을 전달하면 내부적으로 `Number` 객체로 파싱하며, 이후 `doubleValue()`, `intValue()` 등을 호출해 기본형 자료로 변환할 수 있습니다.

---

## 파일 구성 및 학습 내용

### 1. [Ex10_01.java](./src/Ex10_01.java) - Calendar의 기초와 사용법
- `Calendar.getInstance()`를 호출해 현재 시스템 날짜 정보를 획득하고, 연도(`YEAR`), 월(`MONTH`), 일(`DATE`), 주(`WEEK`) 등의 상수를 다루는 실습을 진행합니다.
- `set()` 메서드를 통해 `2019-04-20` (월 매개변수 값은 `3` 지정) 날짜를 커스텀 지정하는 동작을 이해합니다.

```java
Calendar today = Calendar.getInstance();
System.out.println("현재 연도: " + today.get(Calendar.YEAR));
System.out.println("현재 월: " + (today.get(Calendar.MONTH) + 1)); // 0부터 시작하므로 +1 처리

Calendar date1 = Calendar.getInstance();
date1.set(2019, 3, 20); // 2019년 4월 20일 설정 (3은 4월을 의미)
```

---

### 2. [Ex10_02.java](./src/Ex10_02.java) - 콘솔 달력(Calendar) 출력기 제작
- `getActualMaximum(Calendar.DAY_OF_MONTH)` 메서드를 활용해 현재 월의 마지막 날짜(마지막 날이 30일인지 31일인지)를 동적으로 연산합니다.
- 매월 1일의 요일(`DAY_OF_WEEK`)을 구해 콘솔 달력 출력을 위한 공백 자릿수를 맞춘 뒤, 루프와 조건문을 이용해 한 달치 달력을 포맷팅하여 콘솔에 띄우는 복합 실습 예제입니다.

```java
int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 월의 마지막 날짜
cal.set(Calendar.DATE, 1);
int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1일의 요일 구하기

// 달력 그리기용 공백 출력
for (int i = 1; i < dayOfWeek; i++) {
    System.out.print("   ");
}
```

---

### 3. [Ex10_03.java](./src/Ex10_03.java) - DecimalFormat을 이용한 서식 문자열 숫자 변환
- 지정 서식 문자열 패턴(예: `#,###.##`)을 갖춘 문자열 숫자(`"1,234,567.89"`)를 `DecimalFormat.parse()` 메서드를 사용해 분석한 후, `Number.doubleValue()`를 통해 순수 `double` 수치 자료형으로 매끄럽게 변환 및 파싱해내는 예제입니다.

```java
DecimalFormat df = new DecimalFormat("#,###.##");
Number num = df.parse("1,234,567.89"); // 문자열 -> Number 객체 파싱
double d = num.doubleValue();          // Number -> double 기본형 추출
```

---

## 핵심 비교 요약

| 개념 | 주요 특징 및 주의사항 | 예시 / 기본 리턴 형태 |
| :--- | :--- | :--- |
| **`Calendar.getInstance()`** | 현재 국가 및 타임존 정보를 적용한 자손 인스턴스 획득 | `GregorianCalendar` 객체 등 반환 |
| **`Calendar.MONTH`** | 0부터 시작하여 11까지의 값을 가짐 | 0 = 1월, 11 = 12월 |
| **`Calendar.DAY_OF_WEEK`** | 요일을 정수 형태로 반환 (일요일: 1 ~ 토요일: 7) | `1` = 일요일, `7` = 토요일 |
| **`getActualMaximum()`** | 지정된 날짜 필드가 가질 수 있는 최댓값을 동적으로 추출 | 2월은 28 또는 29, 7월은 31 등 |
| **`SimpleDateFormat`** | 날짜 객체(`Date`)를 지정 서식 패턴의 문자열로 가공 | `df.format(cal.getTime())` |
| **`DecimalFormat.format()`**| 숫자 자료를 쉼표나 소수점이 포함된 문자열 서식으로 변환 | `1234567` -> `"1,234,567"` |
| **`DecimalFormat.parse()`** | 서식이 들어간 문자열 숫자를 `Number` 객체로 분석/역변환 | `"1,234,567.89"` -> `Number` |

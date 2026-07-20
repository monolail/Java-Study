# 08. 예외 처리 (Exception Handling)

자바 프로그램 실행 중 발생할 수 있는 비정상적 오류에 대처하는 **예외 처리(Exception Handling)** 개념과 구현 방식을 정리한 공간입니다.

---

## 💡 주요 개념 정리

### 1. 프로그램 오류의 종류
- **컴파일 에러 (Compile-time Error)**: 컴파일 시에 발생하는 에러로, 자바 컴파일러가 문법 검사, 번역, 최적화 과정에서 구문 오류를 발견해 냅니다. (예: 오타, 자료형 불일치)
- **런타임 에러 (Runtime Error)**: 프로그램 실행 중에 발생하는 에러로, 컴파일은 성공했으나 실행 시점에 프로그램이 비정상적으로 종료되는 오류입니다.
- **논리적 에러 (Logical Error)**: 컴파일도 잘 되고 실행도 잘 되지만, 의도했던 것과 다르게 동작하는 에러입니다. (예: 잔고가 마이너스가 되거나 연산이 틀리는 경우)

### 2. 런타임 에러의 분류: 에러(Error) vs 예외(Exception)
- **에러 (Error)**: 아웃 오브 메모리(OOM)나 스택 오버플로우(StackOverflow)처럼 프로그램 코드에 의해서 수습될 수 없는 심각한 오류입니다.
- **예외 (Exception)**: 프로그램 코드에 의해서 수습될 수 있는 비교적 미미한 오류로, 발생하더라도 적절한 코드를 작성해 두면 비정상 종료를 막을 수 있습니다.

### 3. 예외 클래스의 계층 구조
모든 예외와 에러의 최상위 조상은 `Throwable` 클래스이며, 그 아래로 `Exception`과 `Error` 계층 구조가 나뉩니다.
- **Exception 클래스군 (Checked Exception)**:
  - 사용자의 실수 등 외적인 요인에 의해 발생하는 예외입니다.
  - **예외 처리가 필수적**이며, 하지 않으면 컴파일이 되지 않습니다.
  - 예: `IOException` (입출력 예외), `ClassNotFoundException` (클래스 없음).
- **RuntimeException 클래스군 (Unchecked Exception)**:
  - 프로그래머의 실수로 발생하는 예외들입니다.
  - **예외 처리가 선택적**이며, 컴파일러가 강제하지 않습니다.
  - 예: `ArithmeticException` (0으로 나누기), `NullPointerException` (null 객체 호출), `ArrayIndexOutOfBoundsException` (배열 범위 초과).

### 4. try-catch문을 통한 예외 처리
- **정의**: 예외가 발생할 경우 프로그램의 비정상 종료를 막고 실행 상태를 정상적으로 유지하기 위해 처리하는 기법입니다.
- **동작 방식**:
  - `try` 블록 내의 문장을 수행하다가 예외가 발생하면, 발생한 예외 클래스의 인스턴스가 생성되고 이에 부합하는 `catch` 블록을 차례대로 매칭합니다.
  - 일치하는 `catch` 블록을 찾으면 그 블록 내의 문장을 실행하고, 전체 `try-catch` 구조를 벗어나 다음 코드를 계속 수행합니다.
  - **예외가 발생한 이후의 try문(예외 발생 지점 아래 코드)은 실행되지 않습니다.**
- **예외의 다형성**:
  - `catch` 블록의 매개변수는 해당 예외뿐만 아니라 그 예외의 부모 클래스 타입도 선언할 수 있습니다.
  - 모든 catch 블록의 마지막에 `Exception e`를 두면 앞의 catch 블록에서 처리되지 못한 모든 예외를 일괄 수집하여 비정상 종료를 안전하게 방어할 수 있습니다.

### 5. 예외 고의 발생시키기 (`throw`)
- `throw` 키워드를 사용하여 프로그래머가 고의로 예외를 발생시킬 수 있습니다.
  - 구문: `throw new Exception("예외 메시지");`
  - 이를 통해 비즈니스 로직 상 허용되지 않는 조건에서 강제로 예외 흐름을 발생시킬 수 있습니다.

### 6. 메서드에 예외 선언하기 (`throws`)
- 메서드 선언부에 `throws` 키워드를 사용해 메서드 내에서 발생할 수 있는 예외를 호출하는 메서드에 선언할 수 있습니다.
  - 구문: `void method() throws Exception1, Exception2 { ... }`
  - 이는 예외를 직접 처리하지 않고, 메서드를 **호출하는 쪽에 예외 처리를 위임**하여 처리를 분담시키는 유용한 수단입니다.
  - 예외 선언 시 조상 타입의 예외 클래스를 적으면 자손 타입의 모든 예외도 같이 선언된 것과 다름없습니다 (다형성).

### 7. 사용자 정의 예외 (Custom Exception)
- 기존의 정의된 예외 클래스 외에 사용자의 비즈니스 필요에 의해 새로운 예외 클래스를 직접 선언하여 사용할 수 있습니다.
- 보통 Checked 예외가 필요할 때는 `Exception` 클래스를 상속받고, Unchecked 예외가 필요할 때는 `RuntimeException` 클래스를 상속받아 구현합니다.
- 최근에는 예외 처리를 강제하지 않고 유연성을 주기 위해 **`RuntimeException`을 상속받아 Unchecked 예외로 설계하는 흐름**이 주류를 이룹니다.
```java
class MyException extends RuntimeException {
    MyException(String msg) {
        super(msg); // 조상 클래스(RuntimeException)의 생성자 호출
    }
}
```

### 8. 연결된 예외 (Chained Exception)
- 한 예외가 다른 예외를 발생시키는 원인이 되도록 인과관계 체인을 구성하는 기법입니다.
- **구현 방식**:
  - `Throwable` 클래스에 내장된 `initCause(Throwable cause)`를 사용하여 발생한 예외에 원인 예외를 등록합니다.
  - 예외 처리 catch 블록 등에서 `getCause()`를 통해 실제 발생 원인이 되었던 예외를 조회할 수 있습니다.
- **필요성 / 사용하는 목적**:
  1. **여러 예외를 하나의 큰 분류의 예외로 묶어서 처리할 때**: 많은 미시적인 예외를 하나의 대표 예외(예: `InstallException`) 안에 원인 예외로 담아 상위 메서드로 던짐으로써 상위 클래스의 예외 선언부를 깔끔하게 유지할 수 있습니다.
  2. **Checked 예외를 Unchecked 예외로 변환할 때**: 강제적으로 예외 처리를 해야 하는 Checked 예외를 Unchecked 예외(`RuntimeException`)로 감싸서(원인 예외로 등록하여) 던지면 불필요한 예외 선언(`throws`)을 제거하고 프로그래밍 유연성을 크게 높일 수 있습니다.

---

## 파일 구성 및 학습 내용

### 1. [Ex8_01.java](./src/Ex8_01.java) - 컴파일 에러 (Compile-time Error)
- 자바 컴파일러의 역할(구문 체크, 번역, 최적화)을 이해하고, 대소문자 오타(소문자 `system`)로 인해 컴파일 에러가 발생함을 실습하는 예제입니다.

```java
public class Ex8_01 {
    public static void main(String[] args) {
        // compile error 발생 (system -> System)
        system.out.println("Hello, World!");
    }
}
```

---

### 2. [Ex8_02.java](./src/Ex8_02.java) - try-catch 예외 처리 흐름과 다중 catch
- `0/0` 나눗셈으로 인해 `ArithmeticException`이 발생하는 상황을 다루며, 발생 지점 이후의 코드가 실행되지 않고 알맞은 `catch` 블록으로 점프하는 흐름을 학습합니다.
- `ArithmeticException`, `ArrayIndexOutOfBoundsException` 등 예외 종류별 다중 catch 처리와 조상 클래스인 `Exception`을 통한 다형적 처리를 실습합니다.

```java
try {
    System.out.println(0/0);       // ArithmeticException 발생
    System.out.println(args[0]);   // 실행되지 않음
} catch (ArithmeticException ae) {
    System.out.println("숫자 계산 불가");
} catch (ArrayIndexOutOfBoundsException ie) {
    System.out.println("인덱스 에러");
} catch (Exception e) {
    System.out.println("기타 예외 발생");
}
```

---

### 3. [Ex8_03.java](./src/Ex8_03.java) - Checked vs Unchecked 예외와 throw
- `throw new Exception()`을 통해 고의로 Checked Exception을 발생시키며, 이 경우 반드시 `try-catch` 등으로 예외 처리를 해야 컴파일이 성공함을 확인합니다.
- `throw new RuntimeException()`과 같은 Unchecked Exception은 예외 처리를 하지 않아도 컴파일은 통과하지만 실행 시 프로그램이 중단됨을 학습합니다.

```java
try {
    throw new Exception(); // Checked Exception (예외 처리 필수)
} catch (Exception e) {
    // 예외 처리 완료
}

throw new RuntimeException(); // Unchecked Exception (예외 처리 선택, 실행 시 에러)
```

---

### 4. [Ex8_04.java](./src/Ex8_04.java) - 메서드에 예외 선언하기 (throws)

- 메서드 선언부에 `throws Exception`을 지정해 발생한 예외를 직접 처리하지 않고 자신을 호출한 상위 메서드(`main`)로 넘겨서 처리하도록 책임을 위임하는 예제입니다.
- 호출부인 `main` 메서드 내에서 `try-catch`문으로 위임받은 예외를 직접 수습하고 실행 흐름을 이어가도록 처리합니다.

```java
class Ex8_04 {
    public static void main(String[] args) {
        try {
            File f = createFile("Test2.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "재입력해 주세요.");
        }
    }

    static File createFile(String fileName) throws Exception {
        if (fileName == null || fileName.equals(""))
            throw new Exception("파일이름 유효하지 않습니다.");
        File f = new File(fileName);
        f.createNewFile();
        return f;
    }
}
```

---

## 핵심 비교 요약

| 개념 | 주요 특징 및 주의사항 | 예시 / 예외 종류 |
| :--- | :--- | :--- |
| **컴파일 에러** | 문법적인 오류로 인해 컴파일 시점에 검출됨 | `system.out.println()` (소문자 오류) |
| **런타임 에러** | 문법은 맞으나 실행 도중 예외 상황으로 발생함 | `0/0` 나눗셈 연산 |
| **에러(Error)** | 프로그램 코드에 의해 수습될 수 없는 심각한 오류 | `OutOfMemoryError`, `StackOverflowError` |
| **예외(Exception)** | 프로그램 코드에 의해 수습 가능하며 비정상 종료 방지 가능 | `Exception` 및 그 자손 클래스들 |
| **Checked 예외** | `Exception` 계층군(RuntimeException 제외). 예외 처리 필수 | `IOException`, `FileNotFoundException` |
| **Unchecked 예외** | `RuntimeException` 계층군. 예외 처리 선택 (컴파일러 미검사) | `NullPointerException`, `ArithmeticException` |
| **`throw`** | 프로그래머가 고의로 예외를 발생시킬 때 사용 | `throw new RuntimeException();` |
| **다중 catch** | 첫 번째 catch부터 차례대로 맞는지 검사하여 하나의 catch만 실행 | `catch(AE ae)` -> `catch(Exception e)` |
| **`throws`** | 메서드 선언부에 작성하여 발생할 수 있는 예외를 호출부로 위임 | `void method() throws Exception` |
| **사용자 정의 예외** | `Exception` 또는 `RuntimeException`을 상속받아 직접 정의하는 예외 | `class MyException extends RuntimeException` |
| **연결된 예외** | 한 예외가 다른 예외를 발생시키도록 원인 예외를 등록(인과관계 체인) | `initCause(e)` / Checked를 Unchecked로 변환 시 유용 |


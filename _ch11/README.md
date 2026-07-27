# 11. 컬렉션 프레임워크 (Collection Framework)

자바에서 다수의 데이터를 쉽고 효과적으로 처리하기 위해 제공하는 **컬렉션 프레임워크(Collection Framework)**의 주요 구조와 핵심 인터페이스 및 표준 컬렉션 클래스들의 특징을 정리한 공간입니다.

---

## 💡 주요 개념 정리

### 1. 컬렉션, 프레임워크, 컬렉션 프레임워크
- **컬렉션 (Collection)**: 다수의 데이터(객체)를 하나로 묶어서 관리하는 그룹을 뜻합니다.
- **프레임워크 (Framework)**: 표준화된 체계적인 프로그래밍 방식을 의미합니다. 단순히 라이브러리를 가져다 쓰는 것과 달리 애플리케이션의 뼈대와 규격을 결정하므로 구조적이고 일관된 개발이 가능합니다.
- **컬렉션 프레임워크 (Collection Framework)**: 다수의 데이터를 다루기 위한 표준화된 프로그래밍 방식을 의미하며, 데이터 그룹을 조작하기 위한 **핵심 인터페이스와 구현 클래스들의 체계적인 집합**입니다.

### 2. 컬렉션 클래스 (Collection Class)
- 컬렉션 프레임워크를 구성하는 핵심 인터페이스들을 구현하여 실제 데이터를 메모리에 적재하고 처리하는 구체적인 실체 클래스들을 말합니다 (예: `ArrayList`, `LinkedList`, `HashSet`, `HashMap` 등).

### 3. Collection 핵심 인터페이스 종류 (List, Set, Map)
자바 컬렉션 프레임워크의 근간이 되는 3대 핵심 인터페이스와 각 특징은 다음과 같습니다.

| 인터페이스 | 특징 | 구현 클래스 예시 |
| :--- | :--- | :--- |
| **`List`** | - **순서가 유지**되는 데이터의 집합.<br>- **데이터의 중복을 허용**함. | `ArrayList`, `LinkedList`, `Vector`, `Stack` |
| **`Set`** | - **순서가 유지되지 않는** 데이터의 집합.<br>- **데이터의 중복을 허용하지 않음**. | `HashSet`, `TreeSet` |
| **`Map`** | - **키(Key)와 값(Value)의 쌍**으로 이루어진 데이터 집합.<br>- 순서는 없으며, **키(Key)는 중복 불가**, 값(Value)은 중복 허용. | `HashMap`, `TreeMap`, `Hashtable`, `Properties` |

> [!NOTE]
> `List`와 `Set`은 공통된 조상인 `Collection` 인터페이스를 상속받아 유기적인 처리가 가능하지만, `Map`은 키와 값을 쌍으로 관리하는 독자적인 구조이므로 `Collection` 인터페이스를 상속받지 않고 독립적으로 정의되어 있습니다.

### 4. 스택과 큐 (Stack & Queue)
- **스택 (Stack)**:
  - **LIFO (Last-In First-Out) 구조**: 마지막에 삽입된 데이터가 가장 먼저 제거되는 구조입니다.
  - 한쪽 끝에서만 데이터를 넣고 뺄 수 있습니다.
  - **활용 예시**: 수식 계산, 수식 괄호 검사, 워드프로세서의 undo/redo, 웹브라우저의 뒤로가기/앞으로가기.
  - **자바 구현**: `Stack` 클래스를 직접 생성해 사용합니다 (`push()`, `pop()`, `peek()`).
- **큐 (Queue)**:
  - **FIFO (First-In First-Out) 구조**: 가장 처음에 삽입된 데이터가 가장 먼저 제거되는 구조입니다.
  - 한쪽 끝에서는 삽입만, 다른 쪽 끝에서는 추출만 일어납니다.
  - **활용 예시**: 인쇄 대기열(스풀), 최근 사용 문서 이력(History), 프로세스 처리 버퍼.
  - **자바 구현**: `Queue` 인터페이스만 존재하므로, 주로 **`LinkedList` 클래스를 인터페이스 구현체로 생성**하여 사용합니다 (`offer()`, `poll()`, `peek()`).

### 5. 이터레이터 (Iterator)
- **정의**: 컬렉션 프레임워크에 저장된 요소를 읽어오는 방법을 표준화한 인터페이스입니다.
- **필요성**: `List` 계열은 인덱스가 있어 일반 `for`문 접근이 수월하지만, `Set` 계열은 순서가 없으므로 인덱스 접근이 불가능합니다. 이를 해결하고자 컬렉션의 구조와 상관없이 일관성 있는 순회를 보장하기 위해 도입되었습니다.
- **주요 메서드**:
  - `hasNext()`: 다음 요소가 존재하면 `true`, 없으면 `false` 반환.
  - `next()`: 다음 요소를 반환하고 포인터를 다음 위치로 이동.

### 6. Arrays 클래스
- **정의**: 배열을 다루기 위한 유용한 정적(static) 메서드들을 제공하는 유틸리티 클래스입니다.
- **주요 기능**:
  - **배열 출력**: `toString()` (1차원 배열), `deepToString()` (다차원 배열).
  - **배열 복사**: `copyOf(arr, length)` (배열의 처음부터 지정된 길이만큼 복사), `copyOfRange(arr, from, to)` (지정된 범위의 배열을 복사).
  - **배열 채우기**: `fill(arr, val)` (배열의 모든 요소를 특정 값으로 채움), `setAll(arr, generator)` (람다식이나 함수형 인터페이스를 활용해 임의의 규칙으로 배열을 채움).
  - **배열 정렬 및 검색**: `sort(arr)` (배열 요소를 정렬), `binarySearch(arr, key)` (이진 검색을 수행하여 값의 위치를 반환. 단, 사용 전 **반드시 배열이 정렬**되어 있어야 함).

### 7. Comparator와 Comparable
객체 정렬(Sorting) 시 어떤 기준으로 데이터를 배치할 것인지 그 정렬 기준을 정의하는 인터페이스들입니다.
- **Comparable**:
  - 패키지: `java.lang`
  - 특징: 클래스 내부에 정의하여 객체의 **기본 정렬 기준(Natural Order)**을 정의하는 데 사용됩니다.
  - 구현 메서드: `compareTo(Object o)`를 오버라이딩하여 자신(`this`)과 매개변수 객체(`o`)를 비교해 음수, 0, 양수를 반환합니다.
  - 예시: `String` 클래스는 사전 순으로, `Integer` 클래스는 오름차순으로 이미 `Comparable`이 기본 구현되어 있습니다.
- **Comparator**:
  - 패키지: `java.util`
  - 특징: 기본 정렬 기준 외에 **전혀 다른 기준(예: 내림차순, 문자열 길이순 등)으로 정렬**하고 싶을 때 정의하는 비교기 객체입니다.
  - 구현 메서드: `compare(Object o1, Object o2)`를 오버라이딩하여 두 매개변수를 비교하여 결과를 반환합니다.

---

## 🚀 ArrayList vs LinkedList 성능 비교 및 분석

대표적인 `List` 구현체인 `ArrayList`와 `LinkedList`는 데이터를 저장하는 물리/논리적 아키텍처 구조 차이로 인해 뚜렷한 장단점을 보입니다.

### 1. ArrayList (배열 기반 구조)
- **구조**: 데이터 요소를 메모리 상의 **연속적인 물리 배열 공간**에 배치합니다.
- **장점**: 
  - 인덱스 번호를 이용해 즉시 접근하는 **임의 접근(Random Access)**이 가능하므로, **데이터 조회(Read) 성능이 최적화**되어 있습니다.
  - 시간 복잡도: \(O(1)\) (빠른 탐색 시간).
- **단점**:
  - 크기를 한 번 지정하면 동적 변경이 불가능하여, 메모리가 부족할 경우 더 큰 새로운 배열을 할당한 후 기존 요소들을 전부 복사해야 하므로 리소스 오버헤드가 큽니다.
  - 배열의 중간에 새로운 요소를 삽입하거나 삭제할 때, 해당 인덱스 이후의 모든 요소들을 물리적으로 한 칸씩 앞/뒤로 이동(Shift)시켜야 하므로 **중간 데이터 수정 성능이 크게 저하**됩니다.

### 2. LinkedList (연결 노드 구조)
- **구조**: 비연속적으로 흩어진 메모리 공간에 데이터 노드를 배치하고, 각 노드가 **이전 노드와 다음 노드의 주소(링크 참조)를 보관**하는 이중 연결 리스트 구조를 띱니다.
- **장점**:
  - 데이터의 추가나 삭제 시 앞뒤 노드의 링크 정보만 변경하면 되므로, **중간 데이터의 삽입/삭제 속도가 매우 우수**합니다.
  - 데이터가 유연하게 추가되므로 크기 재할당과 전체 복사 이슈가 발생하지 않습니다.
- **단점**:
  - 특정 인덱스의 데이터에 접근하려면 시작 노드부터 링크를 순차적으로 타고 이동해야 하므로(Sequential Access), **조회(Read) 성능이 매우 나쁩니다**.
  - 시간 복잡도: \(O(N)\) (요소 개수만큼 탐색 시간 비례).
  - 다음 노드로 가기 위한 추가 주소값을 가지므로 메모리 소모가 상대적으로 큽니다.

### ⚡ 시간 복잡도(Big-O) 작업 성능 비교 요약

| 작업 유형 | ArrayList | LinkedList | 비고 |
| :--- | :---: | :---: | :--- |
| **인덱스 임의 조회 (Get)** | **\(O(1)\)** | \(O(N)\) | ArrayList 압승 |
| **순차적 추가/삭제 (끝에 추가)** | **\(O(1)\)** | **\(O(1)\)** | 둘 다 준수한 속도 |
| **중간 위치 삽입/삭제 (Insert/Remove)** | \(O(N)\) | **\(O(1)\)** | LinkedList 압승 (참조 링크 변경만 필요) |
| **데이터 순차 탐색 (Search)** | \(O(N)\) | \(O(N)\) | 둘 다 동일 (전체 순회 기준) |

---

## 파일 구성 및 학습 내용

### 1. [Ex11_01.java](./src/Ex11_01.java) - ArrayList의 기본 제어와 다루기
- `ArrayList`를 생성하여 정수 데이터를 삽입하고, 유틸 클래스인 `Collections.sort()`를 호출해 내림차순/오름차순 정렬을 실습합니다.
- `indexOf()` 메서드로 특정 값 요소의 탐색 위치를 구하며, `remove()` 메서드를 활용해 데이터를 인덱스 기반 혹은 인스턴스 참조 기반으로 지우는 흐름을 연습합니다.

```java
ArrayList list1 = new ArrayList(10);
list1.add(5); // 오토박싱 지원
list1.add(2);

Collections.sort(list1); // 컬렉션 정렬 유틸
System.out.println(list1.indexOf(3)); // 인덱스 탐색 (없으면 -1)
list1.remove(4); // 인덱스 4에 해당하는 요소 삭제
```

---

### 2. [Ex11_02.java](./src/Ex11_02.java) - Stack과 Queue의 기본 동작 비교
- Stack과 Queue의 데이터 입출력 방식을 비교 실습합니다. Stack은 LIFO 구조(`push()`, `pop()`), Queue는 FIFO 구조(`offer()`, `poll()`)로 데이터를 처리함을 눈으로 확인합니다.

```java
Stack st = new Stack();
Queue qe = new LinkedList(); // Queue는 인터페이스이므로 LinkedList 구현체 활용

st.push("0");
qe.offer("0");

st.pop();
qe.poll();
```

---

### 3. [Ex11_03.java](./src/Ex11_03.java) - Stack 활용: 수식 괄호 쌍 검사
- 수식 문자열 `((3+5*8-2))` 내의 괄호 짝이 정확히 부합하는지 Stack을 이용해 파싱 및 검사하는 실습입니다.
- 여는 괄호 `(`를 만나면 Stack에 push하고, 닫는 괄호 `)`를 만나면 pop하여 짝을 맞추며, 최종적으로 Stack이 비어있는지 확인해 괄호 일치 여부를 판별합니다.

```java
Stack st = new Stack();
if (ch == '(') {
    st.push(ch + "");
} else if (ch == ')') {
    st.pop();
}
```

---

### 4. [Ex11_04.java](./src/Ex11_04.java) - Queue 활용: 최근 명령어 내역 저장 (History)
- 고정 크기(`MAX_SIZE = 5`)의 큐 구조를 이용해 사용자 입력 커맨드 이력을 최대 5개까지 보관하는 History 큐를 구현합니다.
- 새로운 명령어가 추가될 때 기존 버퍼 크기를 초과하면 가장 오래된 요소를 큐에서 삭제(`qe.remove()`)하여 최근 5개의 기록만 유지하는 FIFO 구조를 적용합니다.

```java
static Queue qe = new LinkedList();
static final int MAX_SIZE = 5;

// 새 명령어 저장 로직
qe.offer(input);
if (qe.size() > MAX_SIZE) {
    qe.remove(); // 가장 오래된 맨 앞의 요소 삭제
}
```

---

### 5. [Ex11_05.java](./src/Ex11_05.java) - Iterator 반복자를 통한 컬렉션 요소 표준 조회
- 컬렉션에 저장된 요소를 조회하기 위해 `iterator()`를 호출하여 반복자(`Iterator`) 객체를 획득하고 순회하는 실습을 진행합니다.
- 인덱스 기반의 `get(i)` 루프 방식과 비교하며, Set 등 인덱스가 없는 컬렉션에서도 일관된 순회 코드를 제공하는 표준 이터레이터 기법의 장점을 학습합니다.

```java
Iterator it = list.iterator();
while(it.hasNext()) {
    Object obj = it.next();
    System.out.println(obj);
}
```

---

### 6. [Ex11_06.java](./src/Ex11_06.java) - Arrays 클래스 활용법
- `Arrays.toString()` 및 `Arrays.deepToString()`을 사용해 1차원/2차원 배열 요소를 출력하고, `copyOf()`, `copyOfRange()`를 이용해 배열을 슬라이싱 및 복사하는 실습을 진행합니다.
- `Arrays.fill()` 및 `Arrays.setAll()`을 사용해 정해진 값이나 무작위 난수(람다 활용)로 배열을 채우는 기법을 배웁니다.

```java
int[] arr = {0, 1, 2, 3, 4};
int[] arr2 = Arrays.copyOf(arr, arr.length);
int[] arr5 = Arrays.copyOfRange(arr, 2, 4); // index 2~3 복사
Arrays.fill(arr7, 9); // 9로 채우기
Arrays.setAll(arr7, i -> (int)(Math.random() * 6) + 1); // 람다식 난수 채우기
```

---

### 7. [Ex11_07.java](./src/Ex11_07.java) - Comparable 정렬 구현과 Arrays.sort()
- `Arrays.sort(strArr)` 메서드를 이용해 문자열 배열을 정렬하는 예제입니다. `String` 클래스가 내부적으로 `Comparable` 인터페이스를 구현하고 있어 별도의 정렬 조건을 주지 않아도 알파벳 사전순(오름차순)으로 자동 정렬되는 원리를 학습합니다.

```java
String[] strArr = {"cat", "dog", "lion", "monkey"};
Arrays.sort(strArr); // String 객체 내부의 Comparable(compareTo()) 기준 오름차순 정렬
```

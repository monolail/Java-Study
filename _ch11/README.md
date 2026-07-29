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

### 8. HashSet
- **정의**: `Set` 인터페이스를 구현한 가장 대표적인 컬렉션 클래스입니다.
- **특징**:
  - **중복 요소를 허용하지 않습니다**: 동일한 값을 여러 번 넣어도 최종적으로 단 하나만 유지됩니다.
  - **순서를 유지하지 않습니다**: 저장 순서가 보장되지 않으며, 해시 함수 알고리즘에 의해 내부 정렬이 수행됩니다. 만일 순서 유지가 필요하다면 `LinkedHashSet` 클래스를 활용해야 합니다.
- **동작 원리**: 데이터를 삽입할 때 `add(Object o)`는 새로 추가할 요소의 해시값과 내부 값을 조회하여 중복 여부를 판단하고, 중복이 없을 때만 요소를 추가하여 컬렉션 무결성을 보호합니다.

### 9. equals()와 hashCode() 오버라이딩의 중요성
- **중복 판단 메커니즘**:
  - `HashSet`이 요소를 추가할 때 객체의 동등성 검사는 두 단계로 나뉩니다:
    1. 추가하려는 객체의 **`hashCode()`**를 호출하여 기존에 저장된 객체들의 해시코드와 일치하는 것이 있는지 비교합니다. (성능 최적화를 위한 1차 필터링)
    2. 해시코드가 일치하는 객체가 발견되면, 2차로 **`equals()`** 메서드를 실행해 실제 필드 데이터 값을 정밀 대조합니다.
  - 이 두 검사를 모두 통과해 서로 다르다고 판정되어야 비로소 중복이 아닌 새로운 객체로 관리됩니다.
- **오버라이딩 규칙**:
  - 사용자 정의 클래스(예: `Person`) 인스턴스를 HashSet에 중복 없이 담으려면 **`equals()`와 `hashCode()`를 반드시 목적에 맞게 재정의**해주어야 합니다.
  - 재정의하지 않으면 Object 클래스의 기본 equals(주소값 비교)와 hashCode(객체 고유 메모리 주소 기반 해싱)가 적용되어, 인스턴스 멤버 내용이 완벽하게 일치해도 서로 다른 객체로 판정되어 중복 삽입되는 논리 오류를 야기합니다.

### 10. TreeSet
- **정의**: `Set` 인터페이스를 구현한 컬렉션 클래스로, 내부적으로 **이진 탐색 트리(Binary Search Tree)** 구조를 사용하여 데이터를 관리합니다.
- **특징**:
  - **오름차순 정렬 저장**: 데이터가 저장될 때 크기를 비교하며 트리 구조로 정렬되므로, 항상 요소들이 정렬된 상태를 유지합니다.
  - **정렬 기준 필수성**: `TreeSet`은 추가할 객체들의 대소관계를 비교해가며 트리를 빌드합니다. 따라서 저장하려는 객체의 클래스가 **`Comparable` 인터페이스(compareTo 메서드)를 상속 구현**하고 있거나, `TreeSet` 생성자에 **비교 기준이 명시된 `Comparator` 구현체**를 넘겨주어야 합니다. 만약 정렬 기준이 존재하지 않는 객체를 대입하면 `ClassCastException` 예외가 발생합니다.

### 11. TreeSet의 범위 검색 기능 (Range Search)
- 이진 탐색 트리는 왼쪽 노드에 자신보다 작은 값, 오른쪽 노드에 큰 값을 연결하는 구조를 띠고 있어 특정 데이터 범위의 검색 속도가 매우 빠릅니다.
- **주요 범위 검색 API**:
  - **`subSet(from, to)`**: 지정된 범위 `from` (포함)에서 `to` (불포함) 사이의 데이터 집합을 뷰 형태로 반환합니다.
  - **`headSet(to)`**: 지정된 경계값 `to`보다 작은(strictly less) 모든 데이터 집합을 반환합니다.
  - **`tailSet(from)`**: 지정된 경계값 `from`보다 크거나 같은(greater than or equal) 모든 데이터 집합을 반환합니다.

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

---

### 8. [Ex11_08.java](./src/Ex11_08.java) - HashSet의 중복 배제 실습
- 중복된 값들이 섞여 있는 배열 객체들을 `HashSet`에 추가하며, 이미 등록된 인스턴스가 존재할 경우 `add()` 메서드가 `false`를 리턴하며 중복 저장을 차단하는 메커니즘을 테스트합니다.
- `String` 타입 `"1"`과 `Integer` 타입 `1`은 해시코드 및 동등성 기준이 완전히 다른 서로 다른 객체이므로 둘 다 성공적으로 저장되는 타입 구분 특성도 확인합니다.

```java
Object[] objARR = {"1", new Integer(1), "2", "2", "3", "3"};
Set set = new HashSet();
for(int i=0; i<objARR.length; i++) {
    set.add(objARR[i]); // "2", "3"의 중복 추가 시도 시 false 리턴 및 추가 안 됨
}
```

---

### 9. [Ex11_09.java](./src/Ex11_09.java) - 커스텀 객체의 equals()와 hashCode() 오버라이딩
- `HashSet`에 커스텀한 객체(`Person` 클래스 인스턴스)를 담아 중복을 정확히 제어하기 위해, `Person` 클래스 내에 멤버 필드(`name`, `age`)의 내용을 대조하는 `equals()`와 멤버들을 해싱하는 `hashCode()` 메서드를 직접 오버라이딩하는 실습 예제입니다.

```java
class Person {
    String name;
    int age;
    
    // name과 age가 같으면 같은 객체로 비교되도록 구현
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return age == p.age && Objects.equals(name, p.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
```

---

### 10. [Ex11_10.java](./src/Ex11_10.java) - TreeSet의 비교기(Comparator) 지정
- 정렬 기준이 없는 클래스(`Test`)의 인스턴스를 `TreeSet`에 직접 추가하면 크기 비교 기준이 없어 런타임 에러(`ClassCastException`)가 유발됩니다.
- 이를 차단하기 위해 `TreeSet` 생성 시 인자로 커스텀한 비교기 구현체(`new TestComp()`)를 주입하여 정렬 요건을 충족시키는 방법을 실습합니다.

```java
// Test 클래스는 Comparable 정렬 기준이 없지만, TestComp 비교기를 넘겨 정렬을 처리함
Set set = new TreeSet(new TestComp());
set.add(new Test());
```

---

### 11. [Ex11_11.java](./src/Ex11_11.java) - TreeSet의 범위 검색 메서드 활용
- 이진 탐색 트리 구조를 지닌 `TreeSet`을 활용하여 특정 값 범위를 초고속으로 조회하는 기능들을 실습합니다.
- `headSet(50)` (50보다 작은 값들), `tailSet(50)` (50보다 크거나 같은 값들), `subSet(40, 80)` (40 이상 80 미만인 값들) 메서드를 테스트합니다.

```java
TreeSet set = new TreeSet();
// [10, 35, 45, 50, 65, 80, 95, 100] 정렬 자동 저장

System.out.println(set.headSet(50)); // [10, 35, 45]
System.out.println(set.tailSet(50)); // [50, 65, 80, 95, 100]
System.out.println(set.subSet(40, 80)); // [45, 50, 65]
```

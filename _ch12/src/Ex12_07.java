// 애터네이션

class Parent {
    void parentMethod() {}
}

class Child extends Parent {
    @Override // @Override 어노테이션은 부모 클래스의 메서드를 오버라이딩할 때 사용됩니다. 이 어노테이션을 사용하면 컴파일러가 부모 클래스에 동일한 시그니처를 가진 메서드가 존재하는지 확인하고, 존재하지 않으면 컴파일 오류를 발생. 따라서 오버라이딩을 올바르게 수행했는지 확인.
    @Deprecated // @Deprecated 어노테이션은 해당 메서드가 더 이상 사용되지 않음을 나타내며, 향후 버전에서 제거될 수 있음을 경고. 이 어노테이션을 사용하면 개발자에게 해당 메서드를 사용하지 말고 대체 메서드를 사용하도록 안내.
    void parentMethod() {}
}

@FunctionalInterface // 함수형 인터페이스는 하나의 추상메서드만 가능.
interface Test {
    // void testMethod(); // 추상메서드
    void checkMethod(); // 추상메서드

    // 2개의 추상 메서드가 있으면 실행 X
}

class Ex12_07 {
    @SuppressWarnings("deprecation") // @SuppressWarnings 어노테이션은 컴파일러 경고를 억제하는 데 사용. "deprecation" 옵션은 더 이상 사용되지 않는 메서드에 대한 경고를 억제.
    public static void main(String[] args) {
        Child c = new Child();
        c.parentMethod(); // deprecated된 메서드 사용.
    }
}
import java.util.List;
import java.util.function.*;

class Ex14_03 {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int)(Math.random() * 100) + 1;
        Consumer<Integer> c = i -> System.out.println(i);
        Predicate<Integer> p = i -> i % 2 == 0;
        Function<Integer, Integer> f = i -> i / 10 * 10;

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        System.out.println(list);
        printEvenNum(p, c, list);
        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);
}

static <T> void makeRandomList(Supplier<T> s, List<T> list) {
    List<T> newList = new ArrayList<T>(list.size());

    for (T i : list) {
        newList.add(s.get());
    }

    return newList;
}

static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
    for (T i : list) {
        if (p.test(i)) {
            c.accept(i);
        }
    }
}

static <T, R> List<R> doSomething(Function<T, R> f, List<T> list) {
    List<R> newList = new ArrayList<R>(list.size());

    for (T i : list) {
        newList.add(f.apply(i));
    }

    return newList;
}
}


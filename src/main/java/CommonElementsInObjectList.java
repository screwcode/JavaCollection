import java.util.*;

public class CommonElementsInObjectList {
    public static Set<Person> commonElementsIn(List<Person> a, List<Person> b) {
        Set<Person> setA = new HashSet<>(a);
        Set<Person> setB = new HashSet<>(b);
        setA.retainAll(setB);
        return setA;
    }
    public static void main(String[] args) {
        System.out.println(
        commonElementsIn(Arrays.asList(new Person("a"),new Person("b"),new Person("c")),
                Arrays.asList(new Person("b"),new Person("c"))));
    }
}

import java.util.*;

public class CommonElementsInObjectList {

    public static Set<Person> commonElementsIn(List<Person> a, List<Person> b) {
        Set<Person> setA = new HashSet<>(a);
        Set<Person> setB = new HashSet<>(b);
        setA.retainAll(setB);
        return setA;
    }
}

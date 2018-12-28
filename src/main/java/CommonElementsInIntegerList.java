import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonElementsInIntegerList {
    public static Set<Integer> commonElementsIn(List<Integer> a, List<Integer> b) {
        Set<Integer> s1 = new HashSet<>(a);
        Set<Integer> s2 = new HashSet<>(b);
        s1.retainAll(s2);
        return s1;
    }
}

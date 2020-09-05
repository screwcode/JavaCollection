import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonElementsInIntegerList {
    public static Set<Integer> commonElementsIn(List<Integer> a, List<Integer> b) {
        // 在这里写你自己的实现
        HashSet<Integer> s1 = new HashSet<>(a);
        HashSet<Integer> s2 = new HashSet<>(b);
        s1.retainAll(s2);
        return s1;
    }
}

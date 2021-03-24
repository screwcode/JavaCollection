import java.util.List;
import java.util.*;
import java.util.Set;

public class CommonElementsInIntegerList {
    public static Set<Integer> commonElementsIn(List<Integer> a, List<Integer> b) {
        // 在这里写你自己的实现
        Set<Integer> s1 = new HashSet<>(a);
        Set<Integer> s2 = new HashSet<>(b);
        s1.retainAll(s2);
        return s1;

    }
}

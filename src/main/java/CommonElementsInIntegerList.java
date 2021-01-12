import java.util.List;
import java.util.Set;

public class CommonElementsInIntegerList {
    public static Set<Integer> commonElementsIn(List<Integer> a, List<Integer> b) {
        // 在这里写你自己的实现
        Set<Integer> set1 = new HashSet<>(a);
        Set<Integer> set2 = new HashSet<>(b);
        set1.retainAll(set2);
        return set1;
    }
}

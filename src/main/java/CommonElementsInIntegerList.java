import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonElementsInIntegerList {
    public static Set<Integer> commonElementsIn(List<Integer> a, List<Integer> b) {
        // 在这里写你自己的实现
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (Integer i : a) {
            set1.add(i);
        }
        for (Integer j : b) {
            set2.add(j);
        }
        set1.retainAll(set2);
        return set1;
    }
}

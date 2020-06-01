import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonElementsInIntegerList {
    public static Set<Integer> commonElementsIn(List<Integer> a, List<Integer> b) {
        // 在这里写你自己的实现
        Set<Integer> aSet = new HashSet<>(a);
        Set<Integer> bSet = new HashSet<>(b);
        aSet.retainAll(bSet);
        return aSet;
    }
}

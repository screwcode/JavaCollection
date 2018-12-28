import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonElementsInIntegerList {
    public static Set<Integer> commonElementsIn(List<Integer> a, List<Integer> b) {
        Set result = new HashSet(a);
        result.retainAll(b);
        return result;
    }
}

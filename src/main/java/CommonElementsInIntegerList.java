import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonElementsInIntegerList {
    public static Set<Integer> commonElementsIn(List<Integer> a, List<Integer> b) {
        // 在这里写你自己的实现
       Set<Integer> elements = new HashSet<>();
        for (Integer aList : a) {
            for (Integer bList : b) {
                if(aList.equals(bList)) {
                    elements.add(aList);
                }
            }
        }

      return elements;
    }
}

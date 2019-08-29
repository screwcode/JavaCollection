import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonElementsInIntegerList {
    public static Set<Integer> commonElementsIn(List<Integer> a, List<Integer> b) {
        // 在这里写你自己的实现
        Set<Integer> set = new HashSet<>(a);
        Set<Integer> result = new HashSet<>();
        for(int i = 0;i<b.size();i++){
            int tmp=b.get(i);
            if(!set.add(tmp)){
                result.add(tmp);
            };
        }
        return result;
    }
}

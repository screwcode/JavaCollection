import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonElementsInIntegerList {
    public static Set<Integer> commonElementsIn(List<Integer> a, List<Integer> b) {
        // 在这里写你自己的实现
        Set<Integer> resuleSet = new HashSet<>();

        for(Integer c: a){
            if(b.contains(c)){
               resuleSet.add(c);
            }

        }

        return resuleSet;
    }
}

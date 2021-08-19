import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * 一个在多线程环境下也能安全的添加元素的TreeSet
 */
public class ConcurrentTreeSet {
    private Set<Integer> elements = new ConcurrentSkipListSet<>();

    public void add(Integer i) {
        elements.add(i);
    }

    public int size() {
        return elements.size();
    }

    public List<Integer> asList() {
        return new ArrayList<>(elements);
    }
}

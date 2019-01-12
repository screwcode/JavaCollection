import java.util.ArrayList;
import java.util.List;

/**
 * 一个只能存放递增数字的列表
 */
public class IncrementalList {
    private List<Integer> list = new ArrayList<>();
    // 想一想，这里改成以下方式可以么？
    //Collections.synchronizedList(new ArrayList<>());

    public void addElementOnlyWhenIncremental(int i) {
        if (list.isEmpty() || isLargerThanLastElement(i)) {
            list.add(i);
        }
    }

    private boolean isLargerThanLastElement(int i) {
        return i > list.get(list.size() - 1);
    }

    public List<Integer> getList() {
        return list;
    }
}

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CommonElementsInObjectListTest {
    @Test
    public void test() {
        Person zxy = new Person("张学友");
        Person ldh = new Person("刘德华");
        Person lm = new Person("黎明");
        Person zxy2 = new Person("张学友");

        assertEquals("张学友 == 张学友", zxy, zxy);
        assertNotEquals("张学友 != 刘德华", zxy, ldh);
        assertEquals("张学友 == 另一个张学友", zxy, zxy2);

        assertEquals("set [张学友] 和 set [刘德华] 没有相同元素",
                CommonElementsInObjectList.commonElementsIn(Arrays.asList(zxy), Arrays.asList(ldh)),
                setOf());

        assertEquals("set [张学友,刘德华] 和 set [刘德华,黎明] 的相同元素们是 [刘德华]",
                CommonElementsInObjectList.commonElementsIn(Arrays.asList(zxy, ldh), Arrays.asList(ldh, lm)),
                setOf(ldh));

        assertEquals("set [张学友,张学友2] 和 set [张学友,张学友2] 的相同元素们是 [张学友]",
                CommonElementsInObjectList.commonElementsIn(Arrays.asList(zxy, zxy2), Arrays.asList(zxy, zxy2)),
                setOf(zxy));

        assertEquals("set [张学友,张学友2] 和 set [张学友,张学友2] 的相同元素们是 [张学友2]",
                CommonElementsInObjectList.commonElementsIn(Arrays.asList(zxy, zxy2), Arrays.asList(zxy, zxy2)),
                setOf(zxy2));
    }

    private Set<Person> setOf(Person... persons) {
        return Stream.of(persons).collect(Collectors.toSet());
    }
}
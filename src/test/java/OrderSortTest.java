import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class OrderSortTest {

    private List<Order> orders = Arrays.asList(
            new Order(999, dateOf("2018-05-01"), "牙刷", 900),
            new Order(2000, dateOf("2018-01-01"), "牙膏", 900),
            new Order(1, dateOf("2018-08-01"), "零食", 100),
            new Order(888, dateOf("2018-04-01"), "杯子", 1200),
            new Order(125, dateOf("2018-08-01"), "圆珠笔", 200),
            new Order(45, dateOf("2018-02-01"), "书", 6900),
            new Order(369, dateOf("2018-08-01"), "纸巾", 500),
            new Order(370, dateOf("2018-08-01"), "纸巾", 500)
    );

    @Test
    public void testSortByTimeDesc() {
        List<Order> sorted = OrderSort.sortByTimeDesc(orders);

        List<Date> sortedDate = sorted.stream().map(Order::getPayTime).collect(Collectors.toList());

        Assert.assertEquals("排序结果应该如下所示",
                Arrays.asList(
                        dateOf("2018-08-01"),
                        dateOf("2018-08-01"),
                        dateOf("2018-08-01"),
                        dateOf("2018-08-01"),
                        dateOf("2018-05-01"),
                        dateOf("2018-04-01"),
                        dateOf("2018-02-01"),
                        dateOf("2018-01-01")
                ),
                sortedDate);
    }

    @Test
    public void testSortByAmountTimeId() {
        List<Order> sorted = OrderSort.sortByAmountTimeId(orders);

        List<Integer> sortedIds = sorted.stream().map(Order::getId).collect(Collectors.toList());

        Assert.assertEquals("排序后的订单应该如下所示",
                Arrays.asList(
                        45,
                        888,
                        999,
                        2000,
                        369,
                        370,
                        125,
                        1),
                sortedIds
        );
    }

    private static Date dateOf(String dateString) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
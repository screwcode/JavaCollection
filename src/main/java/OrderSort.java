import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderSort {
    /**
     * 按照付款时间降序排序，越晚付款的订单越靠前。
     *
     * @param orders 一个订单列表。注意不要修改它，而是新建一个！
     * @return 排序后的订单列表
     */
    public static List<Order> sortByTimeDesc(List<Order> orders) {
        return orders.stream().sorted(Comparator.comparing(Order :: getPayTime).reversed()).collect(Collectors.toList());
    }

    /**
     * 按照"先订单金额（越大越靠前），然后付款时间（越晚的越靠前），最后订单id（从小到大）"的方式排序
     *
     * @param orders 一个订单列表。注意不要修改它，而是新建一个！
     * @return 排序后的订单列表
     */
    public static List<Order> sortByAmountTimeId(List<Order> orders) {
        return orders.stream()
                .sorted(Comparator.comparing(Order::getOrderAmount)
                .thenComparing(Order::getPayTime).reversed()
                .thenComparing(Order::getId)).collect(Collectors.toList());
    }
}

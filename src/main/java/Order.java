import java.util.Date;

/**
 * 代表一个订单
 */
public class Order {
    /**
     * 订单id
     */
    private final int id;

    /**
     * 付款时间
     */
    private final Date payTime;
    /**
     * 下单的产品名
     */
    private final String productName;
    /**
     * 订单金额，单位分。例如，1元的商品orderAmount=100
     */
    private final int orderAmount;

    public Order(int id, Date payTime, String productName, int orderAmount) {
        this.id = id;
        this.payTime = payTime;
        this.productName = productName;
        this.orderAmount = orderAmount;
    }

    public int getId() {
        return id;
    }

    public Date getPayTime() {
        return payTime;
    }

    public String getProductName() {
        return productName;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Order order = (Order) o;

        return id == order.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}


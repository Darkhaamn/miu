package C;

import java.time.LocalDate;

public class Order {
    private String orderNo;
    private LocalDate orderDate;
    private double orderAmount;

    public Order(String orderNo, LocalDate orderDate, double orderAmount) {
        this.orderAmount = orderAmount;
        this.orderDate = orderDate;
        this.orderNo = orderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getOrderAmount() {
        return orderAmount;
    }
}

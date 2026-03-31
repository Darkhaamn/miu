package prob2B;

import java.util.LinkedList;

public class OrderLine {
    private Order order;
    private String item;

    public OrderLine(String item) {
        this.item = item;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public String getItem() {
        return item;
    }
}

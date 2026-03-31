package prob2B;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public String orderNum;
    private List<OrderLine> orderLines;

    public Order(String orderNum) {
        this.orderNum = orderNum;
        this.orderLines = new ArrayList<>();
    }

    public void addOrderLine(OrderLine line) {
        if (line == null) return;

        orderLines.add(line);
        line.setOrder(this); // link both sides
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public String getOrderNum() {
        return orderNum;
    }
}

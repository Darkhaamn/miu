package prob2B;

public class TestOrderLine {
    void main() {
        Order o1 = new Order("Order #1");

        OrderLine line1 = new OrderLine("Mouse");
        OrderLine line2 = new OrderLine("Laptop");

        o1.addOrderLine(line1);
        o1.addOrderLine(line2);

        o1.getOrderLines().forEach(line -> {
            System.out.println("Item: " + line.getItem() +
                    ", belongs to order: " + line.getOrder().getOrderNum());
        });
    }
}

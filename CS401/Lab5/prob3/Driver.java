package prob3;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    void main() {
        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Rectangle(4, 5)); // 20
        shapes.add(new Triangle(3, 6));
        shapes.add(new Circle(2));

        double sum = 0;

        for (Shape s : shapes) {
            sum += s.computeArea();
        }

        System.out.printf("Sum of Areas = %.2f\n", sum);
    }
}

package prob5;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Examples {
    void main(String[] args) {
        Examples ex = new Examples();
        ex.evaluator();
    }

    void evaluator() {
        // A
        Function<Employee, String> fA = Employee::getName;

        System.out.println(fA.apply(new Employee("John", 5000)));

        // B
        BiConsumer<Employee, String> fB = Employee::setName;
        Employee e = new Employee("Old", 1000);
        fB.accept(e, "New");
        System.out.println(e.getName());

        // C
        BiFunction<String, String, Integer> fC = String::compareTo;
        System.out.println(fC.apply("a", "b"));

        // D
        BiFunction<Integer, Integer, Double> fD = Math::pow;
        System.out.println(fD.apply(2, 3));

        // E
        Function<Apple, Double> fE = Apple::getWeight;
        System.out.println(fE.apply(new Apple(2.5)));

        // F
        Function<String, Integer> fF = Integer::parseInt;
        System.out.println(fF.apply("123"));

        // G
        EmployeeNameComparator comp = new EmployeeNameComparator();
        BiFunction<Employee, Employee, Integer> fG = comp::compare;
        System.out.println(
                fG.apply(new Employee("A", 100), new Employee("B", 200))
        );
    }
}

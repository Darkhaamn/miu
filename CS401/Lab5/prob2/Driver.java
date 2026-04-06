package prob2;

public class Driver {
    void main() {
        Duck[] ducks = {
                new MallardDuck(),
                new DecoyDuck(),
                new RedheadDuck(),
                new RubberDuck()
        };

        for (Duck d : ducks) {
            System.out.println(d.getClass().getSimpleName() + ":");
            d.display();
            d.fly();
            d.quack();
            d.swim();
        }
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ForEachMethodInIterableInterface {
    public static void main(String[] args) {

        // Create sample collection
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 10; i++) myList.add(i);

        // Traversing using Iterator
        for (Integer i : myList) {
            System.out.println("Iterator Value::" + i);
        }

        // Traversing through forEach method of Iterable with anonymous class
        myList.forEach(t -> System.out.println("forEach anonymous class Value::" + t));

        // Traversing with Consumer interface implementation
        MyConsumer action = new MyConsumer();
        myList.forEach(action);
    }
}

// Consumer implementation that can be reused (business logic at a separate location that we can reuse)
class MyConsumer implements Consumer<Integer> {

    public void accept(Integer t) {
        System.out.println("Consumer impl Value::" + t);
    }
}


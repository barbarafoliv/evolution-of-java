import java.util.ArrayList;
import java.util.List;

public class SequencedCollectionExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        // Fetch the first element (element at index 0)
        int firstElement = list.getFirst();
        // Fetch the last element
        int lastElement = list.getLast();
    }
}

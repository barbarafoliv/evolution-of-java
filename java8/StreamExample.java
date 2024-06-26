import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 100; i++) myList.add(i);

        // Sequential stream
        Stream<Integer> sequentialStream = myList.stream();

        // Parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();

        // Using lambda with Stream API, filter example
        Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
        // Using lambda in forEach
        highNums.forEach(p -> System.out.println("High Nums parallel=" + p));

        Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
        highNumsSeq.forEach(p -> System.out.println("High Nums sequential=" + p));

        /*
        Notice that parallel processing values are not in order, so parallel processing will be very helpful while
        working with huge collections.
        */

        long count = myList.stream().distinct().count();
        /*
        The distinct() method represents an intermediate operation, which creates a new stream of unique elements of the
        previous stream. And the count() method is a terminal operation, which returns stream’s size.
        */

        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");
        list.add("");
        list.add("");

        boolean contains = list.stream().anyMatch(element -> element.contains("a"));
        /*
        Stream API helps to substitute for, for-each, and while loops. It allows concentrating on operation’s logic, but
        not on the iteration over the sequence of elements.
        */

        Stream<String> stream = list.stream().filter(element -> element.contains("d"));
        /*
        The following code creates a Stream<String> of the List<String>, finds all elements of this stream which contain
        char “d”, and creates a new stream containing only the filtered elements.
        */

        List<String> uris = new ArrayList<>();
        uris.add("C:\\My.txt");
        Stream<Path> myStream = uris.stream().map(Paths::get);
        /*
        The code above converts Stream<String> to the Stream<Path> by applying a specific lambda expression to every
        element of the initial Stream.
        */

        boolean isValid = list.stream().anyMatch(element -> element.contains("h")); // true
        boolean isValidOne = list.stream().allMatch(element -> element.contains("h")); // false
        boolean isValidTwo = list.stream().noneMatch(element -> element.contains("h")); // false

        List<Integer> integers = Arrays.asList(1, 1, 1);
        Integer reduced = integers.stream().reduce(23, Integer::sum); // Result = 26
        /*
        Stream API allows reducing a sequence of elements to some value according to a specified function with the help
        of the reduce() method of the type Stream. This method takes two parameters: first – start value, second – an
        accumulator function.
        */
    }
}

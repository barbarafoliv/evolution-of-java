import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CollectionToArrayExample {
    public static void main(String[] args) {
        List<String> sampleList = Arrays.asList("Java", "Kotlin");
        String[] sampleArray = sampleList.toArray(new String[0]);
        IntStream.range(0, sampleArray.length).mapToObj(i -> i + ": " + sampleArray[i]).forEach(System.out::println);
    }
}

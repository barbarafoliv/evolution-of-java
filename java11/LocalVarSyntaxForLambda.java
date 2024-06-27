import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LocalVarSyntaxForLambda {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(System.out::println);

        /*
        In Java 8 or earlier, we would have to declare the type of the lambda parameter explicitly.

        numbers.forEach((var number) -> {
            System.out.println(number);
        });
        */

        List<String> sampleList = Arrays.asList("Java", "Kotlin");
        String resultString = sampleList.stream()
                .map((var x) -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.println(resultString);
    }
}

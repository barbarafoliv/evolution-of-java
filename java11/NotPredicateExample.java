import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class NotPredicateExample {
    public static void main(String[] args) {
        List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
        List<String> withoutBlanks = sampleList.stream()
                .filter(Predicate.not(String::isBlank))
                .toList();

        System.out.println(sampleList);
        System.out.println(withoutBlanks);

        /*
        While not(isBlank) reads more naturally than isBlank.negate(), the big advantage is that we can also use not
        with method references, like not(String:isBlank).
        */
    }
}

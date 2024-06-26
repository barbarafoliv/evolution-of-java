import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        Optional<String> optional1 = Optional.empty(); // empty Optional

        String str = "value";
        Optional<String> optional2 = Optional.of(str); // Optional that contains a non-null value

        User user = new User("Babi");
        Optional<String> optional3 = Optional.ofNullable(user.getName());
        // Optional with a specific value or an empty Optional if the parameter is null
    }
}

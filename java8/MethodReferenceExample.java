import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MethodReferenceExample {

    public static void main(String[] args) {

        List<User> list = new ArrayList<>();
        User user = new User("Babi");
        list.add(user);

        boolean isReal = list.stream().anyMatch(User::isRealUser); // Reference to a Static Method

        boolean isLegalName = list.stream().anyMatch(user::isLegalName); // Reference to an Instance Method

        List<String> otherList = new ArrayList<>();
        otherList.add("");
        otherList.add("hello");
        otherList.add("world");
        otherList.add("");

        // Reference to an Instance Method of an Object of a Particular Type
        long count = otherList.stream().filter(String::isEmpty).count();

        Stream<User> stream = list.stream().map((User name) -> new User("Babi")); // Reference to a Constructor
    }
}

class User {

    String name;

    public String getName() {
        return name;
    }

    public User(String name) {
        this.name = name;
    }

    static boolean isRealUser(User user) {
        return true;
    }

    boolean isLegalName(User user) {
        return name.contains("a");
    }
}

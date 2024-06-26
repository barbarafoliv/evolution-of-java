import java.util.function.Function;

public class UseFoo {

    public String add(String string, Foo foo) {
        return foo.method(string);
    }

    public String secondAdd(String string, Function<String, String> fn) {
        return fn.apply(string);
    }

    public static void main(String[] args) {
        UseFoo useFoo = new UseFoo();

        // Foo is nothing more than a function that accepts one argument and produces a result.
        Foo foo = parameter -> parameter + " from lambda";
        String result = useFoo.add("Message ", foo);

        // Java 8 already provides such an interface in Function<T,R> from the java.util.function package.
        Function<String, String> fn = parameter -> parameter + " from lambda";
        String secondResult = useFoo.secondAdd("Message ", fn);
    }
}

public class WhenClauseExample {
    static String processInputNew(String input) {
        String output = null;
        switch(input) {
            case null -> output = "Oops, null";
            case String s when "Yes".equalsIgnoreCase(s) -> output = "It's Yes";
            case String s when "No".equalsIgnoreCase(s) -> output = "It's No";
            case String s -> output = "Try Again";
        }
        return output;
    }
}

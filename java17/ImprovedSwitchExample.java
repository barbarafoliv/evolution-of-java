public class ImprovedSwitchExample {
    public static void main(String[] args) {
        improvedSwitch("APPLE");
        improvedSwitch("BANANA");
        improvedSwitch("ORANGE");

        checkNumber(null);
        checkNumber(1);
        checkNumber(2);
        checkNumber(3);
    }

    private static void improvedSwitch(String fruit) {
        String text = switch (fruit) {
            case "APPLE", "PEAR" -> {
                System.out.println("the given fruit was: " + fruit);
                yield "Common fruit";
            }
            case "ORANGE", "AVOCADO" -> "Exotic fruit";
            default -> "Undefined fruit";
        };
        System.out.println(text);
    }

    /*
    In Java, the yield keyword is used within a switch expression to return a value from a case block. It effectively
    specifies the value to be produced by the switch expression when the case is matched.
    */

    private static void checkNumber(Integer number) {
        switch (number) {
            case 1, 7 -> System.out.println("odd number");
            case 2, 8 -> System.out.println("even number");
            case null -> System.out.println("not a number");
            default -> System.out.println("not defined");
        }
    }

    /*
    Here, checkNumber variable gets a number as an input. If null is passed as an input, “Not defined” is displayed as
    an output. Note that, for case 1,7 and case 2,8, other odd and even numbers are to be taken in selector expression
    as well for the proper functioning of the code. Only a few are taken to maintain the simplicity of the example.
    */
}

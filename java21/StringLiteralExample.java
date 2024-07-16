import static java.lang.StringTemplate.STR;

public class StringLiteralExample {
    public static void main(String[] args) {
        String name = "Baeldung";
        String welcomeText = STR."Welcome to \{name}";
        System.out.println(welcomeText);

        // Java (using String.format)
        String person = "Sachin P";
        String message = String.format("Welcome %s", person);
        System.out.println(message);


        /*
        We use string templates to embed the variables productName, productPrice, and productAvailable directly within
        the string literal. The expressions are enclosed within ${} and can include additional formatting, such as
        adding a dollar sign before the productPrice. The resulting string is more concise, easier to read, and
        eliminates the need for explicit concatenation and formatting operations.
        */

        String productName = "Widget";
        double productPrice = 29.99;
        boolean productAvailable = true;

        String productInfo = STR.   """
                                    Product: \{productName}
                                    Price: $\{String.format("%.2f", productPrice)}
                                    Availability: \{productAvailable ? "In Stock" : "Out of Stock"}
                                    """;

        System.out.println(productInfo);

    }
}

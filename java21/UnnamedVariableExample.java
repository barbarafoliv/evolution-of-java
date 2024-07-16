public class UnnamedVariableExample {
    public static void main(String[] args) {
        String userInput = "User Input";
        try {
            int number = Integer.parseInt(userInput);
        // Use 'number'
        } catch (NumberFormatException _) {
            System.out.println(STR."Invalid input: \{userInput}");
        }
    }

    /*
    In this updated version, we no longer use the ‘ex’ variable; instead, we’ve replaced it with an underscore (_).
    This simple change helps streamline the code and makes it more concise.
    */
}

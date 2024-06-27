import java.util.stream.Collectors;

public class NewStringMethods {
    public static void main(String[] args) {
        String str1 = "";
        String str2 = "  ";
        String str3 = "Hello World";
        System.out.println(str1.isBlank()); // Output: true
        System.out.println(str2.isBlank()); // Output: true
        System.out.println(str3.isBlank()); // Output: false

        String str4 = "  Hello World  ";
        String str5 = "\u2005Hello World\u2005";
        System.out.println(str4.strip()); // Output: "Hello World"
        System.out.println(str5.strip()); // Output: "Hello World"

        String str6 = "JD\nJD\nJD";
        System.out.println(str6);
        System.out.println(str6.lines().collect(Collectors.toList()));

        String str7 = " JD ";
        System.out.print("Start");
        System.out.print(str7.strip());
        System.out.println("End");

        System.out.print("Start");
        System.out.print(str7.stripLeading());
        System.out.println("End");

        System.out.print("Start");
        System.out.print(str7.stripTrailing());
        System.out.println("End");

        String str8 = "=".repeat(2);
        System.out.println(str8); //prints ==
    }
}

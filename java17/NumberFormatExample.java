import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatExample {
    public static void main(String[] args) {
        NumberFormat shortFormat = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.SHORT);
        System.out.println(shortFormat.format(1000));

        NumberFormat longFormat = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.LONG);
        System.out.println(longFormat.format(1000));
    }
}

import java.awt.*;

public class PatternMatchingExample {
    public static void main(String[] args) {
        patternMatchingInJava17();
        patternMatchingScopeException();
    }

    private static void patternMatchingInJava17() {
        record Grape(Color color, int pits) {
        }

        Object o = new Grape(Color.BLUE, 2);
        if (o instanceof Grape grape) {
            System.out.println("This grape has " + grape.pits + " pits.");
        } else {
            System.out.println("Not a grape object!");
        }
    }

    /*
    We can pair the instance of check with an &&(and) condition but not ||(or) as in case of an “or” condition the
    statement can reach the other condition even if instance of check return false.
    */

    private static void patternMatchingScopeException() {
        Object o = new Grape(Color.BLUE, 2);
        if (!(o instanceof Grape grape)) {
            throw new RuntimeException();
        }
        System.out.println("This grape has " + grape.pits + " pits.");
    }

    /*
    The scope of the variable grape can even extend beyond the if block is the instance of check return true. In the
    example above, Runtime Exception will be thrown if the object is not of Grape type, hence the compiler will know for
    sure that the grape object should exist when it reaches the print statement.
    */

    record Grape(Color color, int pits) {
    }
}

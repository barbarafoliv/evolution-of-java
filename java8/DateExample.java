import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateExample {

    public static void LocalDateTimeApi() {

        // Current date
        LocalDate date = LocalDate.now();
        System.out.println("the current date is " + date);

        // Current time
        LocalTime time = LocalTime.now();
        System.out.println("the current time is " + time);

        // Current time and date
        LocalDateTime current = LocalDateTime.now();
        System.out.println("current date and time : " + current);

        // Print in a particular format
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formatedDateTime = current.format(format);

        System.out.println("in formatted manner " + formatedDateTime);

        // Printing months, days and seconds
        Month month = current.getMonth();
        int day = current.getDayOfMonth();
        int seconds = current.getSecond();
        System.out.println("Month : " + month + " day : " + day + " seconds : " + seconds);

        // Printing some specified date
        LocalDate date2 = LocalDate.of(1950, 1, 26);
        System.out.println("the republic day :" + date2);

        // Printing date with current time
        LocalDateTime specificDate = current.withDayOfMonth(24).withYear(2016);

        System.out.println("specific date with " + "current time : " + specificDate);
    }

    public static void main(String[] args) {
        LocalDateTimeApi();
    }
}


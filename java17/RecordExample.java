public class RecordExample {
    public static void main(String[] args) {
        BodyMassIndex bmi1 = new BodyMassIndex(5.3, 141.45, 43);
        // Records provide an implementation of equals(), hashCode() and toString()
        BodyMassIndex bmi2 = new BodyMassIndex(5.3, 141.45, 43);
        System.out.println("BMIs are equal: " + bmi1.equals(bmi2));
        System.out.println("BMI details: " + bmi1);
    }
}

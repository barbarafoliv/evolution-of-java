public interface DefaultStaticMethodInterface1 {

    static void print(String str) {
        System.out.println("Printing " + str);
    }

    void method1(String str);

    default void log(String str) {
        System.out.println("I1 logging::" + str);
    }

    /*
    Trying to override Object method gives compile-time error as "A default method cannot override a method from
    java.lang.Object"

    default String toString(){
        return "i1";
    }
    */
}

public class MyClass implements DefaultStaticMethodInterface1, DefaultStaticMethodInterface2 {

    Runnable r = new Runnable() {
        public void run() {
            System.out.println("MyClass runnable::" + Thread.currentThread().getName());
        }
    };

    /*
    Since functional interfaces have only one method, lambda expressions can easily provide the method implementation.
    We just need to provide method arguments and business logic.
    For example, we can write above implementation using lambda expression as:
    */
    Runnable r1 = () -> {
        System.out.println("MyClass runnable::" + Thread.currentThread().getName());
    };

    @Override
    public void method1(String str) {

    }

    @Override
    public void method2() {

    }

    // MyClass won't compile without having it's own log() implementation
    @Override
    public void log(String str) {
        /*
        For example above DefaultStaticMethodInterface1 anonymous class can be instantiated using lambda as follows:
        */
        DefaultStaticMethodInterface1 i1 = System.out::println;
        i1.method1("abc"); // Static method implementation of DefaultStaticMethodInterface1
    }
}

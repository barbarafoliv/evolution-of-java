public class Main {
    private static void problemSpace() {
        Apple apple = new Apple();
        Pear pear = new Pear();
        Fruit fruit = apple;

        class Avocado extends Fruit {
        }

        /*
        We cannot stop Avocado to extend the Fruit class. If we make the Fruit class default, then the assignment of
        apple to fruit object would not compile. Hence, now we can use sealed classes to allow only specific classes to
        extend our superclass.
        */

        AppleSealed appleSealed = new AppleSealed();
        PearSealed pearSealed = new PearSealed();
        FruitSealed fruitSealed = appleSealed;
    }
}

public class NestBasedAccessControlExample {
    private int x;

    class InnerClass {
        void setX(int x) {
            NestBasedAccessControlExample.this.x = x;
        }
    }

    /*
    The Inner class can access the private member x of the NestBasedAccessControlExample class, even though it is not
    defined in the Inner class itself.
    */
}

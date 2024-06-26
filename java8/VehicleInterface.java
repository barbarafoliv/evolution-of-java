public interface VehicleInterface {

    /*
    The static producer() method is available only through and inside an interface.
    It can’t be overridden by an implementing class.
    */
    static String producer() {
        return "N&F Vehicles";
    }

    /*
    Default methods are declared using the new default keyword.
    These are accessible through the instance of the implementing class and can be overridden.
    */
    default String getOverview() {
        return "ATV made by " + producer();
    }
}

public class VehicleImpl implements VehicleInterface {

    String producer = VehicleInterface.producer(); // Standard approach for static method

    VehicleInterface myVehicle = new VehicleImpl();
    String overview = myVehicle.getOverview(); // For executing the default method, an instance should be created
}

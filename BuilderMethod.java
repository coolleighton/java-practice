import java.util.HashMap;
import java.util.Map;

// Main application class
public class BuilderMethod {
    public static void main(String[] args) {
        VehicleBuilder builder;

        // Create shop with vehicle builders
        Shop shop = new Shop();

        // Construct and display vehicles

        builder = new ScooterBuilder();
        shop.construct(builder);
        builder.getVehicle().show();

        builder = new CarBuilder();
        shop.construct(builder);
        builder.getVehicle().show();

        builder = new MotorCycleBuilder();
        shop.construct(builder);
        builder.getVehicle().show();
    }
}

// Director
class Shop {
    public void construct(VehicleBuilder builder) {
        builder.buildFrame();
        builder.buildEngine();
        builder.buildWheels();
        builder.buildDoors();
    }
}

// Abstract Builder
abstract class VehicleBuilder {
    protected Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public abstract void buildFrame();
    public abstract void buildEngine();
    public abstract void buildWheels();
    public abstract void buildDoors();
}

// Concrete Builder - Scooter
class ScooterBuilder extends VehicleBuilder {
    public ScooterBuilder() {
        vehicle = new Vehicle("Scooter");
    }

    public void buildFrame() {
        vehicle.setPart("frame", "Scooter Frame");
    }

    public void buildEngine() {
        vehicle.setPart("engine", "none");
    }

    public void buildWheels() {
        vehicle.setPart("wheels", "2");
    }

    public void buildDoors() {
        vehicle.setPart("doors", "0");
    }
}

// Concrete Builder - Car
class CarBuilder extends VehicleBuilder {
    public CarBuilder() {
        vehicle = new Vehicle("Car");
    }

    public void buildFrame() {
        vehicle.setPart("frame", "Car Frame");
    }

    public void buildEngine() {
        vehicle.setPart("engine", "2500 cc");
    }

    public void buildWheels() {
        vehicle.setPart("wheels", "4");
    }

    public void buildDoors() {
        vehicle.setPart("doors", "4");
    }
}

// Concrete Builder - MotorCycle
class MotorCycleBuilder extends VehicleBuilder {
    public MotorCycleBuilder() {
        vehicle = new Vehicle("MotorCycle");
    }

    public void buildFrame() {
        vehicle.setPart("frame", "MotorCycle Frame");
    }

    public void buildEngine() {
        vehicle.setPart("engine", "500 cc");
    }

    public void buildWheels() {
        vehicle.setPart("wheels", "2");
    }

    public void buildDoors() {
        vehicle.setPart("doors", "0");
    }
}

// Product
class Vehicle {
    private String vehicleType;
    private Map<String, String> parts = new HashMap<>();

    public Vehicle(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setPart(String key, String value) {
        parts.put(key, value);
    }

    public String getPart(String key) {
        return parts.get(key);
    }

    public void show() {
        System.out.println("\n---------------------------");
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println(" Frame  : " + parts.get("frame"));
        System.out.println(" Engine : " + parts.get("engine"));
        System.out.println(" #Wheels: " + parts.get("wheels"));
        System.out.println(" #Doors : " + parts.get("doors"));
    }
}

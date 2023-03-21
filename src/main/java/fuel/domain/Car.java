package fuel.domain;

public abstract class Car {

    private final String carName;
    private final int fuelEfficiency;
    private final int travelDistance;

    public Car(String carName, int fuelEfficiency, int travelDistance) {
        this.carName = carName;
        this.fuelEfficiency = fuelEfficiency;
        this.travelDistance = travelDistance;
    }

    public double getChargeFuel() {
        return travelDistance / fuelEfficiency;
    }

    public String getCarName() {
        return carName;
    }
}

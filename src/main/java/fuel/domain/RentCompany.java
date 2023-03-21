package fuel.domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private final List<Car> cars;

    public static RentCompany create() {
        return new RentCompany();
    }

    private RentCompany() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("보유한 자동차가 없습니다");
        }

        StringBuilder report = new StringBuilder();
        for (Car car : cars) {
            report.append(car.getCarName()).append(" : ")
                    .append((int) car.getChargeFuel()).append("리터").append('\n');
        }
        return report.toString();
    }

}

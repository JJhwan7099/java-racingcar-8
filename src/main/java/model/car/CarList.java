package model.car;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private final List<Car> cars = new ArrayList<>();

    public void registerCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}

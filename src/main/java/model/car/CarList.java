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

    public List<Car> findWinners() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        List<Car> winners = new ArrayList<>();
        for(Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}

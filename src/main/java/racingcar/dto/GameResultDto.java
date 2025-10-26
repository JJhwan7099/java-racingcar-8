package racingcar.dto;

import racingcar.model.car.Car;

import java.util.ArrayList;
import java.util.List;

public class GameResultDto {

    private final List<RoundResult> roundResults = new ArrayList<>();
    private final List<String> winners = new ArrayList<>();

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

    public void addRoundResult(RoundResult roundResult) {
        roundResults.add(roundResult);
    }

    public List<String> getWinners() {
        return winners;
    }

    public void addWinners(List<Car> winners) {
        for (Car car : winners) {
            this.winners.add(car.getName());
        }
    }

    public static class RoundResult {
        private final List<CarNameAndPosition> carNameAndPositions = new ArrayList<>();

        public RoundResult(List<Car> cars) {
            for (Car car : cars) {
                carNameAndPositions.add(new CarNameAndPosition(car.getName(), car.getPosition()));
            }
        }

        public List<CarNameAndPosition> getCarNameAndPositions() {
            return carNameAndPositions;
        }
    }

    public static class CarNameAndPosition {
        private final String name;
        private final int position;
        public CarNameAndPosition(String name, int position) {
            this.name = name;
            this.position = position;
        }
        public String getName() {
            return name;
        }
        public int getPosition() {
            return position;
        }
    }
}

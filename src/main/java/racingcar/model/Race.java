package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.GameInitDto;
import racingcar.dto.GameResultDto;
import racingcar.model.car.Car;
import racingcar.model.car.CarList;

import java.util.List;

public class Race {

    private static final int WIN_THRESHOLD = 4;
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    private final CarList carList;
    private final int gameCount;

    public Race(CarList carList, GameInitDto gameInitDto) {
        this.carList = carList;
        this.gameCount = gameInitDto.getGameCount();
        registerCars(gameInitDto.getCarNames());
    }

    private void registerCars(List<String> cars) {
        for (String carName : cars) {
            Car car = new Car(carName);
            carList.registerCar(car);
        }
    }

    public GameResultDto startGame() {
        GameResultDto gameResultDto = new GameResultDto();

        for (int i = 0; i < gameCount; i++) {
            gameResultDto.addRoundResult(playRound());
        }
        gameResultDto.addWinners(carList.findCarsWithMaxPosition());

        return gameResultDto;
    }

    private GameResultDto.RoundResult playRound() {
        List<Car> cars = carList.getCars();
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (randomNumber >= WIN_THRESHOLD) car.moveForward();
        }
        return new GameResultDto.RoundResult(cars);
    }
}

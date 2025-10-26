package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.GameInitDto;
import racingcar.dto.GameResultDto;
import racingcar.model.car.Car;
import racingcar.model.car.CarList;

import java.util.List;

public class Race {
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
        for(Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0,9);
            if(randomNumber >=4) car.moveForward();
        }
        return new GameResultDto.RoundResult(cars);
    }
}

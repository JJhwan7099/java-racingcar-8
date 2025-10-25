package model;

import camp.nextstep.edu.missionutils.Randoms;
import dto.GameInitDto;
import model.car.Car;
import model.car.CarList;
import view.OutputView;

import java.util.List;

public class Race {
    private final CarList carList;
    private final OutputView outputView;
    private final int gameCount;

    public Race(CarList carList, GameInitDto gameInitDto, OutputView outputView) {
        this.carList = carList;
        this.outputView = outputView;
        this.gameCount = gameInitDto.getGameCount();
        registerCars(gameInitDto.getCarNames());
    }

    private void registerCars(List<String> cars) {
        for (String carName : cars) {
            Car car = new Car(carName);
            carList.registerCar(car);
        }
    }

    public void startGame() {
        outputView.printRacingResult();
        for (int i = 0; i < gameCount; i++) {
            playRound();
        }
        List<Car> winners = carList.findWinners();
        outputView.printWinners(winners);
    }

    private void playRound() {
        List<Car> cars = carList.getCars();
        for(Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0,9);
            if(randomNumber >=4) car.moveForward();
        }
        outputView.printRoundStatus(cars);
    }
}

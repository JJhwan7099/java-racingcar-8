package controller;

import dto.GameInitDto;
import model.InputParser;
import model.Race;
import model.car.CarList;
import view.InputView;
import view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;
    private final CarList carList;

    public RacingCarController(InputView inputView, OutputView outputView,InputParser inputParser, CarList carList) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
        this.carList = carList;
    }

    public void run() {
        outputView.printRequestCarNames();
        String carNames = inputView.inputCarNames();
        outputView.printRequestGameCount();
        String gameCount = inputView.inputGameCount();

        GameInitDto gameInitDto = inputParser.parseInput(carNames, gameCount);

        Race race = new Race(carList, gameInitDto, outputView);
        race.startGame();
    }
}

package racingcar.controller;

import racingcar.dto.GameInitDto;
import racingcar.dto.GameResultDto;
import racingcar.model.parser.InputParser;
import racingcar.model.Race;
import racingcar.model.car.CarList;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;
    private final CarList carList;

    public RacingCarController(InputView inputView, OutputView outputView, InputParser inputParser, CarList carList) {
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

        Race race = new Race(carList, gameInitDto);
        GameResultDto gameResultDto = race.startGame();

        outputView.printResult(gameResultDto);
    }
}

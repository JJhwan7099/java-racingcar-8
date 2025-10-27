package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.model.car.CarList;
import racingcar.model.parser.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController(
                new InputView(),
                new OutputView(),
                new InputParser(),
                new CarList()
        );
        racingCarController.run();
    }
}

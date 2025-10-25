package racingcar;

import controller.RacingCarController;
import model.InputParser;
import model.car.CarList;
import view.InputView;
import view.OutputView;

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

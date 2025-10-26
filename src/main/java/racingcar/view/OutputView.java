package racingcar.view;

import racingcar.model.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printRequestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRequestGameCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRacingResult() {
        System.out.println("실행 결과");
    }

    public void printRoundStatus(List<Car> carList) {
        for(Car car : carList) {
            System.out.print(car.getName() + " : ");
            for(int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printWinners(List<Car> carList) {
        String winners = carList.stream()
                    .map(Car::getName)
                    .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winners);
    }
}

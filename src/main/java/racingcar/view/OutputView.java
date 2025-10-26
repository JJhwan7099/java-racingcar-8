package racingcar.view;

import racingcar.dto.GameResultDto;

import java.util.List;

public class OutputView {
    public void printRequestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRequestGameCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printResult(GameResultDto gameResultDto) {
        List<GameResultDto.RoundResult> roundResults = gameResultDto.getRoundResults();
        List<String> winners = gameResultDto.getWinners();

        System.out.println("실행 결과");

        for (GameResultDto.RoundResult roundResult : roundResults) {
            List<GameResultDto.CarNameAndPosition> carNameAndPositions = roundResult.getCarNameAndPositions();
            for (GameResultDto.CarNameAndPosition carNameAndPosition : carNameAndPositions) {
                String carName = carNameAndPosition.getName();
                int position = carNameAndPosition.getPosition();

                System.out.println(carName + " : " + "-".repeat(position));
            }

            System.out.println();
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

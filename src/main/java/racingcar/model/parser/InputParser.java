package racingcar.model;

import racingcar.dto.GameInitDto;
import racingcar.validator.InputParserValidator;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public GameInitDto parseInput(String carNames, String gameCount) {
        List<String> cars = Arrays.stream(carNames.split(",", -1))
                .map(String::trim)
                .toList();
        InputParserValidator.validateCarNames(cars);

        int parsedGameCount;
        try {
            parsedGameCount = Integer.parseInt(gameCount);
            InputParserValidator.validateGameCount(parsedGameCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("게임 횟수는 1이상의 정수입니다.");
        }

        return new GameInitDto(cars, parsedGameCount);
    }
}

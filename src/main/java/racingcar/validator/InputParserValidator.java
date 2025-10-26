package racingcar.validator;

import java.util.List;

public class InputParserValidator {

    private static final String ALPHABET_PATTERN = "[a-zA-Z]+$";

    public static void validateCarNames(List<String> cars) {
        if(cars.size() < 2) {
            throw new IllegalArgumentException("참가하는 자동차는 2대 이상이어야 합니다.");
        }

        for(String carName : cars) {
            if(!carName.matches(ALPHABET_PATTERN) || carName.isBlank() || carName.length() > 5)
                throw new IllegalArgumentException("자동차명은 빈값 혹은 공백이 될 수 없으며, 5글자 이하의 알파벳으로만 구성되어야 합니다.");
        }
    }

    public static void validateGameCount(int parsedGameCount) {
        if(parsedGameCount < 1)
            throw new IllegalArgumentException("게임 횟수는 1이상의 정수입니다.");
    }
}

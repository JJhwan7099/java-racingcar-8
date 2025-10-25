package validator;

import java.util.List;

public class InputParserValidator {

    private static final String ALPHABET_PATTERN = "[a-zA-Z]+$";

    public static void validateCarNames(List<String> cars) {
        for(String carName : cars) {
            if(!carName.matches(ALPHABET_PATTERN) || carName.isBlank())
                throw new IllegalArgumentException("자동차명은 빈값 혹은 공백이 될 수 없으며, 알파벳으로만 구성되어야 합니다.");
        }
    }

    public static void validateGameCount(int parsedGameCount) {
        if(parsedGameCount < 1)
            throw new IllegalArgumentException("게임 횟수는 1이상의 정수입니다.");
    }
}

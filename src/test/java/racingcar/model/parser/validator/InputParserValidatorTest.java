package racingcar.model.parser.validator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputParserValidatorTest {

    @Test
    void 자동차_이름이_2대이상_통과() {
        List<String> carNames = List.of("carA", "carB");
        assertDoesNotThrow(() -> InputParserValidator.validateCarNames(carNames));
    }

    @Test
    void 자동차_이름이_1대이하_예외발생() {
        List<String> carNames = List.of("carA");
        assertThrows(IllegalArgumentException.class,
                () -> InputParserValidator.validateCarNames(carNames));
    }

    @Test
    void 자동차_이름이_5글자_초과_예외발생() {
        List<String> carNames = List.of("carA", "niceCar");
        assertThrows(IllegalArgumentException.class,
                () -> InputParserValidator.validateCarNames(carNames));
    }

    @Test
    void 자동차_이름이_공백일때_예외발생() {
        List<String> carNames = List.of("carA", " ");
        assertThrows(IllegalArgumentException.class,
                () -> InputParserValidator.validateCarNames(carNames));
    }

    @Test
    void 자동차_이름에_알파벳이_아닌_문자포함시_예외발생() {
        List<String> carNames = List.of("carA", "car1");
        assertThrows(IllegalArgumentException.class,
                () -> InputParserValidator.validateCarNames(carNames));
    }

    @Test
    void 게임횟수_1이상이면_통과() {
        assertDoesNotThrow(() -> InputParserValidator.validateGameCount(5));
    }

    @Test
    void 게임횟수_1미만이면_예외발생() {
        assertThrows(IllegalArgumentException.class,
                () -> InputParserValidator.validateGameCount(0));
        assertThrows(IllegalArgumentException.class,
                () -> InputParserValidator.validateGameCount(-1));
    }
}

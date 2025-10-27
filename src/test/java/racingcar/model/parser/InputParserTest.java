package racingcar.model.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.GameInitDto;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {

    private final InputParser inputParser = new InputParser();

    @Test
    void 쉼표로_구분된_자동차_이름과_게임횟수를_파싱한다() {
        GameInitDto gameInitDto = inputParser.parseInput("carA,carB,carC", "5");

        assertThat(gameInitDto.getCarNames()).containsExactly("carA", "carB", "carC");
        assertThat(gameInitDto.getGameCount()).isEqualTo(5);
    }

    @Test
    void 입력값의_자동차_이름의_앞뒤_공백은_제거된다() {
        GameInitDto gameInitDto = inputParser.parseInput(" carA,carB , carC ", "5");

        assertThat(gameInitDto.getCarNames()).containsExactly("carA", "carB", "carC");
        assertThat(gameInitDto.getGameCount()).isEqualTo(5);
    }
}

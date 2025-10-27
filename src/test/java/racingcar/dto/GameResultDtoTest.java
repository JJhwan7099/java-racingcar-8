package racingcar.dto;

import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultDtoTest {

    @Test
    void addRoundResult_정상작동() {
        //given
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        carA.moveForward();

        GameResultDto gameResultDto = new GameResultDto();
        GameResultDto.RoundResult roundResult = new GameResultDto.RoundResult(List.of(carA, carB));

        //when
        gameResultDto.addRoundResult(roundResult);

        //then
        assertThat(gameResultDto.getRoundResults()).hasSize(1);
        List<GameResultDto.CarNameAndPosition> results =
                gameResultDto.getRoundResults().get(0).getCarNameAndPositions();

        assertThat(results).hasSize(2);
        assertThat(results.get(0).getName()).isEqualTo("carA");
        assertThat(results.get(0).getPosition()).isEqualTo(1);
        assertThat(results.get(1).getName()).isEqualTo("carB");
        assertThat(results.get(1).getPosition()).isEqualTo(0);
    }

    @Test
    void 단일우승자일때_addWinners_정상작동() {
        //given
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        carA.moveForward();

        GameResultDto gameResultDto = new GameResultDto();

        //when
        gameResultDto.addWinners(List.of(carA));

        //then
        assertThat(gameResultDto.getWinners()).hasSize(1);
        assertThat(gameResultDto.getWinners()).containsExactly("carA");
    }

    @Test
    void 공동우승자일때_addWinners_정상작동() {
        //given
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        carA.moveForward();
        carB.moveForward();

        GameResultDto gameResultDto = new GameResultDto();

        //when
        gameResultDto.addWinners(List.of(carA, carB));

        //then
        assertThat(gameResultDto.getWinners()).hasSize(2);
        assertThat(gameResultDto.getWinners()).containsExactly("carA", "carB");
    }
}

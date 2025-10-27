package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.GameResultDto;
import racingcar.model.car.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    private OutputView outputView;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 라운드별_출력_정상동작_확인() {
        //given
        Car carA = new Car("carA");
        Car carB = new Car("carB");

        carA.moveForward();
        carA.moveForward();
        carB.moveForward();

        GameResultDto.RoundResult roundResult = new GameResultDto.RoundResult(List.of(carA, carB));
        GameResultDto gameResultDto = new GameResultDto();
        gameResultDto.addRoundResult(roundResult);

        //when
        outputView.printResult(gameResultDto);

        //then
        String output = outputStream.toString();

        assertThat(output).contains("실행 결과");
        assertThat(output).contains("carA : --");
        assertThat(output).contains("carB : -");
    }

    @Test
    void 최종우승자_출력_정상동작_확인() {
        //given
        Car carA = new Car("carA");
        Car carB = new Car("carB");

        GameResultDto gameResultDto = new GameResultDto();
        gameResultDto.addWinners(List.of(carA, carB));

        //when
        outputView.printResult(gameResultDto);

        //then
        String output = outputStream.toString();

        assertThat(output).contains("최종 우승자 : carA, carB");
    }
}

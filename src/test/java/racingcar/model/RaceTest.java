package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.GameInitDto;
import racingcar.dto.GameResultDto;
import racingcar.model.car.Car;
import racingcar.model.car.CarList;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 2;
    private CarList carList;

    @BeforeEach
    void setUp() {
        carList = new CarList();
    }

    @Test
    void 자동차_등록_정상작동() {
        //given
        GameInitDto gameInitDto = new GameInitDto(List.of("carA", "carB"), 3);

        //when
        Race race = new Race(carList, gameInitDto);

        //then
        assertThat(carList.getCars()).hasSize(2);
        assertThat(carList.getCars())
                .extracting(Car::getName)
                .containsExactly("carA", "carB");
    }

    @Test
    void 게임횟수만큼_라운드가_진행_정상작동() {
        //given
        GameInitDto gameInitDto = new GameInitDto(List.of("carA", "carB"), 3);
        Race race = new Race(carList, gameInitDto);

        //when
        assertRandomNumberInRangeTest(
                () -> {
                    GameResultDto result = race.startGame();

                    // then
                    assertThat(result.getRoundResults()).hasSize(3); // 3라운드 진행되었는지
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 랜덤값이_기준값이상이면_자동차가_이동한다() {
        //given
        GameInitDto gameInitDto = new GameInitDto(List.of("carA", "carB"), 3);
        Race race = new Race(carList, gameInitDto);

        //when
        assertRandomNumberInRangeTest(
                () -> {
                    GameResultDto result = race.startGame();

                    // then
                    List<Car> cars = carList.getCars();
                    Car carA = cars.get(0);
                    Car carB = cars.get(1);

                    assertThat(carA.getPosition()).isEqualTo(1);
                    assertThat(carB.getPosition()).isEqualTo(0);

                    GameResultDto.RoundResult roundResult = result.getRoundResults().get(0);
                    assertThat(roundResult.getCarNameAndPositions())
                            .extracting("name", "position")
                            .containsExactlyInAnyOrder(
                                    org.assertj.core.groups.Tuple.tuple("carA", 1),
                                    org.assertj.core.groups.Tuple.tuple("carB", 0)
                            );
                },
                MOVING_FORWARD, STOP
        );
    }
}

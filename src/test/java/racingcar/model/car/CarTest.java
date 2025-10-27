package racingcar.model.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    void 자동차는_이름과_초기위치를_가진다() {
        Car car = new Car("nice");
        assertThat(car.getName()).isEqualTo("nice");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차가_전진하면_position_1_증가() {
        Car car = new Car("nice");
        car.moveForward();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 여러번_moveForward를_호출하면_횟수만큼_position이_증가한다() {
        Car car = new Car("nice");
        car.moveForward();
        car.moveForward();
        car.moveForward();
        car.moveForward();

        assertThat(car.getPosition()).isEqualTo(4);
    }
}

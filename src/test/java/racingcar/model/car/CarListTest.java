package racingcar.model.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarListTest {

    private CarList carList;

    @BeforeEach
    void setUp() {
        carList = new CarList();
    }

    @Test
    void 자동차를_등록하면_cars에_추가된다() {
        Car car1 = new Car("car");
        carList.registerCar(car1);

        assertThat(carList.getCars()).hasSize(1);
        assertThat(carList.getCars()).contains(car1);
    }

    @Test
    void getCars를_호출하면_등록된_자동차들이_반환된다() {
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");

        carList.registerCar(carA);
        carList.registerCar(carB);
        carList.registerCar(carC);

        assertThat(carList.getCars()).hasSize(3);
        assertThat(carList.getCars()).contains(carA, carB, carC);
    }

    @Test
    void findCarsWithMaxPosition을_호출하면_position이_최대인_자동차_목록을_반환한다() {
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");

        carList.registerCar(carA);
        carList.registerCar(carB);
        carList.registerCar(carC);

        carA.moveForward();
        carA.moveForward();
        carB.moveForward();
        carC.moveForward();
        carC.moveForward();

        assertThat(carList.findCarsWithMaxPosition()).hasSize(2);
        assertThat(carList.findCarsWithMaxPosition()).contains(carA, carC);
    }
}

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
        Car car1 = new Car("car1");
        carList.registerCar(car1);

        assertThat(carList.getCars()).hasSize(1);
        assertThat(carList.getCars()).contains(car1);
    }

    @Test
    void getCars를_호출하면_등록된_자동차들이_반환된다() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        carList.registerCar(car1);
        carList.registerCar(car2);
        carList.registerCar(car3);

        assertThat(carList.getCars()).hasSize(3);
        assertThat(carList.getCars()).contains(car1, car2, car3);
    }

    @Test
    void findCarsWithMaxPosition을_호출하면_position이_최대인_자동차_목록을_반환한다() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        carList.registerCar(car1);
        carList.registerCar(car2);
        carList.registerCar(car3);

        car1.moveForward();
        car1.moveForward();
        car2.moveForward();
        car3.moveForward();
        car3.moveForward();

        assertThat(carList.findCarsWithMaxPosition()).hasSize(2);
        assertThat(carList.findCarsWithMaxPosition()).contains(car1, car3);
    }
}

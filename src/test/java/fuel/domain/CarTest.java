package fuel.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class CarTest {

    @Test
    @DisplayName("주입할 연료량 테스트")
    void getChargeFuel_Test() {
        Car car = mock(Car.class, withSettings().useConstructor("test", 10, 100).defaultAnswer(CALLS_REAL_METHODS));
        assertThat(car.getChargeFuel()).isEqualTo(10);
    }

    @Test
    @DisplayName("자동차 이름 반환 테스트")
    void getCarName_Test() {
        Car car = mock(Car.class, withSettings().useConstructor("test", 10, 100).defaultAnswer(CALLS_REAL_METHODS));
        assertThat(car.getCarName()).isEqualTo("test");
    }
}
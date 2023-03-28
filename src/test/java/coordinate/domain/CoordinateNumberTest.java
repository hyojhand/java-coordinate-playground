package coordinate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CoordinateNumberTest {

    @Test
    @DisplayName("좌표값이 같다면 같은 객체임을 테스트")
    void coordinateNumber_SameObject_Test() {
        CoordinateNumber coordinateNumber = CoordinateNumber.from(1);
        assertThat(coordinateNumber).isEqualTo(CoordinateNumber.from(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 45})
    @DisplayName("좌표값 범위 예외 테스트")
    void coordinateNumber_OutRange_Exception(int number) {
        assertThatThrownBy(() -> CoordinateNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 좌표값 입니다");
    }

    @Test
    @DisplayName("좌표값 차이의 제곱값 테스트")
    void coordinateNumber_DifferenceSquare_Test() {
        assertThat(CoordinateNumber.from(2).differenceSquare(CoordinateNumber.from(4))).isEqualTo(4);
    }
}
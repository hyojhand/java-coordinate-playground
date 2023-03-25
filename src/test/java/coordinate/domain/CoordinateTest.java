package coordinate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CoordinateTest {

    @Test
    @DisplayName("좌표가 같다면 같은 객체임을 테스트")
    void coordinate_SameObject_Test() {
        Coordinate coordinate = new Coordinate("1,2");
        assertThat(coordinate).isEqualTo(new Coordinate("1,2"));
    }

    @Test
    @DisplayName("좌표 값이 잘못된 예외 테스트")
    void coordinate_WrongCoordinateSize_Exception() {
        assertThatThrownBy(() -> new Coordinate("1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("좌표값은 2개 입니다");
    }

    @Test
    @DisplayName("두 점 사이의 거리 테스트")
    void calculateDistance_Test() {
        Coordinate coordinate = new Coordinate("1,2");
        Coordinate otherCoordinate = new Coordinate("2,3");
        assertThat(coordinate.calculateDistance(otherCoordinate)).isEqualTo(1.414, offset(0.00099));
    }

}
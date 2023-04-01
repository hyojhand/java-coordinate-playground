package coordinate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class CoordinateTest {

    @Test
    @DisplayName("좌표가 같다면 같은 객체임을 테스트")
    void coordinate_SameObject_Test() {
        Coordinate coordinate = new Coordinate(1, 2);
        assertThat(coordinate).isEqualTo(new Coordinate(1, 2));
    }

    @Test
    @DisplayName("두 점 사이의 거리 테스트")
    void coordinate_CalculateDistance_Test() {
        Coordinate coordinate = new Coordinate(1, 2);
        Coordinate otherCoordinate = new Coordinate(2, 3);
        assertThat(coordinate.calculateDistance(otherCoordinate)).isEqualTo(1.414, offset(0.00099));
    }

    @Test
    @DisplayName("두 좌표의 변화량 테스트")
    void coordinate_CoordinateDelta_Test() {
        Coordinate coordinate = new Coordinate(3, 4);
        assertThat(coordinate.calculateDelta(new Coordinate(1, 2))).isEqualTo(new Delta(4));
    }
}
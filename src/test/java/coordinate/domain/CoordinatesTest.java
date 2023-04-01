package coordinate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CoordinatesTest {

    @Test
    @DisplayName("같은 좌표값들은 같은 객체임을 테스트")
    void coordinates_SameObject_Test() {
        Coordinates coordinates = new Coordinates(List.of(new Coordinate(1, 2), new Coordinate(2, 3)));
        assertThat(coordinates).isEqualTo(new Coordinates(List.of(new Coordinate(1, 2), new Coordinate(2, 3))));
    }

    @Test
    @DisplayName("중복된 좌표값 예외 테스트")
    void coordinates_IsDuplicate_Exception() {
        assertThatThrownBy(() -> new Coordinates(List.of(new Coordinate(1, 2), new Coordinate(1, 2))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("좌표가 중복되었습니다");
    }

    @Test
    @DisplayName("두 인덱스를 가지는 좌표의 거리 테스트")
    void coordinates_IndexDistance_Test() {
        Coordinates coordinates = new Coordinates(List.of(new Coordinate(1, 2), new Coordinate(2, 3)));
        assertThat(coordinates.getIndexDistance(0, 1)).isEqualTo(1.414, offset(0.00099));
    }

    @Test
    @DisplayName("두 인덱스를 가지는 좌표의 변화량 테스트")
    void coordinates_IndexDelta_Test() {
        Coordinates coordinates = new Coordinates(List.of(new Coordinate(2, 3), new Coordinate(1, 2)));
        assertThat(coordinates.getIndexDelta(0, 1)).isEqualTo(new Delta(2));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,True", "2,1,False", "2,3,True", "3,2,False"}, delimiter = ',')
    @DisplayName("좌표를 포함하는지 확인하는 테스트")
    void coordinates_isContainCoordinate_Test(int coordinateX, int coordinateY, boolean expect) {
        Coordinates coordinates = new Coordinates(List.of(new Coordinate(1, 2), new Coordinate(2, 3)));
        assertThat(coordinates.isContainCoordinate(new Coordinate(coordinateX, coordinateY))).isEqualTo(expect);
    }

    @Test
    @DisplayName("좌표들의 개수 테스트")
    void coordinates_Size_Test() {
        Coordinates coordinates = new Coordinates(List.of(new Coordinate(1, 2), new Coordinate(2, 3)));
        assertThat(coordinates.getCoordinateSize()).isEqualTo(2);
    }
}
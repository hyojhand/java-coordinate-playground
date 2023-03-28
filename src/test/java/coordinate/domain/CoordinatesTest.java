package coordinate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinatesTest {

    @Test
    @DisplayName("같은 좌표값들은 같은 객체임을 테스트")
    void coordinates_SameObject_Test() {
        Coordinates coordinates = new Coordinates(List.of(new Coordinate(1, 2), new Coordinate(2, 3)));
        assertThat(coordinates).isEqualTo(new Coordinates(List.of(new Coordinate(1, 2), new Coordinate(2, 3))));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,True", "2,1,False", "2,3,True", "3,2,False"}, delimiter = ',')
    @DisplayName("좌표를 포함하는지 확인하는 테스트")
    void coordinates_isContainCoordinate_Test(int coordinateX, int coordinateY, boolean expect) {
        Coordinates coordinates = new Coordinates(List.of(new Coordinate(1, 2), new Coordinate(2, 3)));
        assertThat(coordinates.isContainCoordinate(new Coordinate(coordinateX, coordinateY))).isEqualTo(expect);
    }

    @Test
    @DisplayName("인덱스번째에 해당하는 좌표 반환 테스트")
    void coordinate_IndexOf_Test() {
        Coordinates coordinates = new Coordinates(List.of(new Coordinate(1, 2), new Coordinate(2, 3)));
        assertThat(coordinates.getCoordinateIndexOf(0)).isEqualTo(new Coordinate(1, 2));
    }

    @Test
    @DisplayName("좌표들의 개수 테스트")
    void coordinates_Size_Test() {
        Coordinates coordinates = new Coordinates(List.of(new Coordinate(1, 2), new Coordinate(2, 3)));
        assertThat(coordinates.getCoordinateSize()).isEqualTo(2);
    }
}
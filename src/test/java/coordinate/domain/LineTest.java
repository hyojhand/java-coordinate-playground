package coordinate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("같은 직선은 같은 객체임을 테스트")
    void line_SameObject_Test() {
        Coordinates coordinates = new Coordinates(List.of(new Coordinate(1, 2), new Coordinate(2, 3)));
        Line line = new Line(coordinates);
        assertThat(line).isEqualTo(new Line(coordinates));
    }

    @Test
    @DisplayName("직선의 거리 테스트")
    void line_calculateArea_Test() {
        Coordinates coordinates = new Coordinates(List.of(new Coordinate(1, 2), new Coordinate(2, 3)));
        Line line = new Line(coordinates);
        assertThat(line.calculateArea()).isEqualTo(1.414, offset(0.00099));
    }

    @Test
    @DisplayName("직선에 맞지 않는 좌표가 들어올 때 예외")
    void coordinateSize_Generator_Exception() {
        Coordinates coordinates = new Coordinates(List.of(new Coordinate(1, 2), new Coordinate(2, 3), new Coordinate(3, 4)));
        assertThatThrownBy(() -> new Line(coordinates))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("좌표의 개수가 잘못되었습니다");
    }
}
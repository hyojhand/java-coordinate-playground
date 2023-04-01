package coordinate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RectangleTest {

    @Test
    @DisplayName("같은 사각형은 같은 객체임을 테스트")
    void rectangle_SameObject_Test() {
        Coordinates coordinates = new Coordinates(List.of(new Coordinate(10, 10), new Coordinate(22, 10),
                new Coordinate(22, 18), new Coordinate(10, 18)));
        Rectangle rectangle = new Rectangle(coordinates);
        assertThat(rectangle).isEqualTo(new Rectangle(coordinates));
    }

    @Test
    @DisplayName("사각형에 맞지 않는 좌표가 들어올 때 예외")
    void rectangleSize_Generator_Exception() {
        Coordinates coordinates = new Coordinates(List.of(new Coordinate(10, 10), new Coordinate(22, 10),
                new Coordinate(22, 18)));
        assertThatThrownBy(() -> new Rectangle(coordinates))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("좌표의 개수가 잘못되었습니다");
    }

    @Test
    @DisplayName("사각형의 면적 테스트")
    void rectangle_CalculateArea_Test() {
        Coordinates coordinates = new Coordinates(List.of(new Coordinate(10, 10), new Coordinate(22, 10),
                new Coordinate(22, 18), new Coordinate(10, 18)));
        Rectangle rectangle = new Rectangle(coordinates);
        assertThat(rectangle.calculateArea()).isEqualTo(96);
    }

    @Test
    @DisplayName("정사각형의 면적 테스트")
    void square_CalculateArea_Test() {
        Coordinates coordinates = new Coordinates(List.of(new Coordinate(10, 10), new Coordinate(10, 15),
                new Coordinate(15, 15), new Coordinate(15, 10)));
        Rectangle rectangle = new Rectangle(coordinates);
        assertThat(rectangle.calculateArea()).isEqualTo(25);
    }

}
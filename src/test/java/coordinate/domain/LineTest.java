package coordinate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class LineTest {

    @Test
    @DisplayName("같은 직선은 같은 객체임을 테스트")
    void line_SameObject_Test() {
        Coordinates coordinates = new Coordinates(List.of("1,2", "2,3"));
        Line line = new Line(coordinates);
        assertThat(line).isEqualTo(new Line(coordinates));
    }

    @Test
    @DisplayName("직선의 거리 테스트")
    void line_calculateArea_Test() {
        Coordinates coordinates = new Coordinates(List.of("1,2", "2,3"));
        Line line = new Line(coordinates);
        assertThat(line.calculateArea()).isEqualTo(1.414, offset(0.00099));
    }
}
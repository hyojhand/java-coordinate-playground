package coordinate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FigureMatchTest {

    @ParameterizedTest
    @CsvSource(value = {"2:LINE", "4:RECTANGLE"}, delimiter = ':')
    @DisplayName("좌표 개수에 맞는 도형 타입 테스트")
    void figureMatch_Match_Test(int coordinatesSize, FigureMatch expect) {
        assertThat(FigureMatch.matchFigure(coordinatesSize)).isEqualTo(expect);
    }

    @Test
    @DisplayName("해당 도형 타입에 맞는 구현 클래스 반환 테스트")
    void figureMatch_CreateFigure_Test() {
        Coordinates coordinates = new Coordinates(List.of(new Coordinate(1, 2), new Coordinate(2, 3)));
        Figure figure = FigureMatch.LINE.create(coordinates);
        assertThat(figure).isInstanceOf(Line.class);
    }
}
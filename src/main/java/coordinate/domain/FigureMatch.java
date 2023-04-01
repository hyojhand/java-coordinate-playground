package coordinate.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum FigureMatch {

    LINE(Line.COORDINATE_SIZE, Line::new),
    RECTANGLE(Rectangle.COORDINATE_SIZE, Rectangle::new);

    private final int coordinateSize;
    private final Function<Coordinates, Figure> figure;

    FigureMatch(int coordinateSize, Function<Coordinates, Figure> figure) {
        this.coordinateSize = coordinateSize;
        this.figure = figure;
    }

    public static FigureMatch matchFigure(int size) {
        return Arrays.stream(FigureMatch.values())
                .filter(findMatch -> findMatch.coordinateSize == size)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 도형이 없습니다"));
    }

    public Figure create(Coordinates coordinates) {
        return figure.apply(coordinates);
    }
}

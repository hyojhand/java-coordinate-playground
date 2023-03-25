package coordinate.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum FigureMatch {

    LINE(Line.COORDINATE_SIZE, "두 점 사이의 거리는 ",Line::new);

    private final int coordinateSize;
    private final String message;
    private final Function<Coordinates, Figure> figure;

    FigureMatch(int coordinateSize, String message, Function<Coordinates, Figure> figure) {
        this.coordinateSize = coordinateSize;
        this.message = message;
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

    public String getMessage() {
        return message;
    }
}

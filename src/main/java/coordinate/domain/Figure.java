package coordinate.domain;

import java.util.Objects;

public abstract class Figure {

    final Coordinates coordinates;

    public Figure(Coordinates coordinates, int expectSize) {
        if (expectSize != coordinates.getCoordinateSize()) {
            throw new IllegalArgumentException("좌표의 개수가 잘못되었습니다");
        }

        this.coordinates = coordinates;
    }

    public abstract double calculateArea();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Objects.equals(coordinates, figure.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}

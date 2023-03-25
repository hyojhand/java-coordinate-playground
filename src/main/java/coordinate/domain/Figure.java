package coordinate.domain;

import java.util.Objects;

public abstract class Figure {

    final Coordinates coordinates;

    public Figure(Coordinates coordinates) {
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

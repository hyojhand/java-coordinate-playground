package coordinate.domain;

import java.util.Objects;

public class Coordinate {

    private final CoordinateNumber x;
    private final CoordinateNumber y;

    public Coordinate(CoordinateNumber x, CoordinateNumber y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate(int x, int y) {
        this(CoordinateNumber.from(x), CoordinateNumber.from(y));
    }

    public double calculateDistance(Coordinate otherCoordinate) {
        return Math.sqrt(x.getDelta(otherCoordinate.x).square() + y.getDelta(otherCoordinate.y).square());
    }

    public Delta calculateDelta(Coordinate otherCoordinate) {
        return x.getDelta(otherCoordinate.x).sum(y.getDelta(otherCoordinate.y));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

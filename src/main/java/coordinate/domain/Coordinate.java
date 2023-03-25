package coordinate.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Coordinate {

    public static final String DELIMITER = ",";
    private static final int COORDINATE_NUMBER_SIZE = 2;
    private static final int X_INDEX = 0;
    private static final int Y_INDEX = 1;
    private final CoordinateNumber x;
    private final CoordinateNumber y;

    public Coordinate(String numberValue) {
        List<Integer> coordinateNumbers = Arrays.stream(numberValue.trim().split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (coordinateNumbers.size() != COORDINATE_NUMBER_SIZE) {
            throw new IllegalArgumentException("좌표값은 2개 입니다");
        }

        this.x = CoordinateNumber.from(coordinateNumbers.get(X_INDEX));
        this.y = CoordinateNumber.from(coordinateNumbers.get(Y_INDEX));
    }

    public double calculateDistance(Coordinate otherCoordinate) {
        return Math.sqrt(Math.pow(x.minus(otherCoordinate.x), 2) + Math.pow(y.minus(otherCoordinate.y), 2));
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

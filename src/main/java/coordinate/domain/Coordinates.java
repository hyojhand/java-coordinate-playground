package coordinate.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Coordinates {

    private final List<Coordinate> coordinates;

    public Coordinates(List<String> coordinateValues) {
        this.coordinates = mappingCoordinate(coordinateValues);
    }

    private List<Coordinate> mappingCoordinate(List<String> coordinateValues) {
        return coordinateValues.stream()
                .map(Coordinate::new)
                .collect(Collectors.toList());
    }

    public boolean isContainCoordinate(Coordinate coordinate) {
        return coordinates.contains(coordinate);
    }

    public Coordinate getCoordinateIndexOf(int index) {
        return coordinates.get(index);
    }

    public int getCoordinateSize() {
        return coordinates.size();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(coordinates, that.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}

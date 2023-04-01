package coordinate.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Coordinates {

    private final static int START_INDEX = 0;
    private final List<Coordinate> coordinates;

    public Coordinates(List<Coordinate> coordinates) {
        if (isDuplicate(coordinates)) {
            throw new IllegalArgumentException("좌표가 중복되었습니다");
        }

        this.coordinates = sortCoordinates(coordinates);
    }

    private boolean isDuplicate(List<Coordinate> coordinates) {
        Set<Coordinate> distinct = new HashSet<>(coordinates);
        return distinct.size() != coordinates.size();
    }

    private List<Coordinate> sortCoordinates(List<Coordinate> coordinates) {
        Coordinate firstCoordinate = coordinates.get(START_INDEX);
        return coordinates.stream()
                .sorted((o1, o2) -> {
                    double distance = firstCoordinate.calculateDistance(o1);
                    double otherDistance = firstCoordinate.calculateDistance(o2);
                    return (int) (distance - otherDistance);
                })
                .collect(Collectors.toList());
    }

    public double getIndexDistance(int index, int otherIndex) {
        return coordinates.get(index).calculateDistance(coordinates.get(otherIndex));
    }

    public Delta getIndexDelta(int index, int otherIndex) {
        return coordinates.get(index).calculateDelta(coordinates.get(otherIndex));
    }

    public boolean isContainCoordinate(Coordinate coordinate) {
        return coordinates.contains(coordinate);
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

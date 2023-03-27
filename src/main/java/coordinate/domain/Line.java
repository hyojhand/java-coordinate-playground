package coordinate.domain;

public class Line extends Figure {

    public static final int COORDINATE_SIZE = 2;

    public Line(Coordinates coordinates) {
        super(coordinates, COORDINATE_SIZE);
    }

    @Override
    public double calculateArea() {
        return coordinates.getCoordinateIndexOf(0)
                .calculateDistance(coordinates.getCoordinateIndexOf(1));
    }
}

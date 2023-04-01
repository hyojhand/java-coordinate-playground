package coordinate.domain;

public class Rectangle extends Figure {

    public static final int COORDINATE_SIZE = 4;

    public Rectangle(Coordinates coordinates) {
        super(coordinates, COORDINATE_SIZE);
        if (!validateVertical()) {
            throw new IllegalArgumentException("사다리꼴이나 마름모는 허용하지 않습니다");
        }
    }

    @Override
    public double calculateArea() {
        return coordinates.getIndexDistance(0, 1) * coordinates.getIndexDistance(0, 2);
    }

    private boolean validateVertical() {
        return coordinates.getIndexDelta(0, 1).sum(coordinates.getIndexDelta(0, 2))
                .equals(coordinates.getIndexDelta(0, 3));
    }
}

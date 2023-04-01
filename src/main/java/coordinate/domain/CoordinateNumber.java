package coordinate.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CoordinateNumber {

    public static final int MIN_COORDINATE_NUMBER = 0;
    public static final int MAX_COORDINATE_NUMBER = 24;

    private static final List<CoordinateNumber> COORDINATE_NUMBERS = IntStream.rangeClosed(MIN_COORDINATE_NUMBER, MAX_COORDINATE_NUMBER)
            .mapToObj(CoordinateNumber::new)
            .collect(Collectors.toList());

    private final int number;

    private CoordinateNumber(int number) {
        this.number = number;
    }

    public static CoordinateNumber from(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException("잘못된 좌표값 입니다");
        }
        return COORDINATE_NUMBERS.get(number);
    }

    public Delta getDelta(CoordinateNumber otherCoordinateNumber) {
        return new Delta(number - otherCoordinateNumber.number);
    }

    private static boolean isOutOfRange(int number) {
        return number > MAX_COORDINATE_NUMBER || number < MIN_COORDINATE_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinateNumber that = (CoordinateNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

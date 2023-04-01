package coordinate.view;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String START_COORDINATE_SIGN = "(";
    private static final String END_COORDINATE_SIGN = ")";
    private static final String COORDINATE_DELIMITER = "-";

    public Set<String> inputCoordinates() {
        System.out.println("좌표를 입력하세요.");
        Set<String> coordinates = Arrays.stream(inputValue().split(COORDINATE_DELIMITER))
                .collect(Collectors.toSet());
        return extractCoordinates(coordinates);
    }

    private Set<String> extractCoordinates(Set<String> coordinates) {
        return coordinates.stream()
                .filter(coordinate -> coordinate.startsWith(START_COORDINATE_SIGN) &&
                        coordinate.endsWith(END_COORDINATE_SIGN))
                .map(coordinate -> coordinate.substring(1, coordinate.length() - 1))
                .collect(Collectors.toSet());
    }

    private String inputValue() {
        return Optional.of(SCANNER.nextLine())
                .orElseThrow(() -> new IllegalArgumentException("공백을 입력했습니다. 값을 입력해 주세요."));
    }
}

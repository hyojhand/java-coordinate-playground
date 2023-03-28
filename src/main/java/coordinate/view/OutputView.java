package coordinate.view;


import coordinate.domain.*;

public class OutputView {

    private static final String Y_AXIS = "|";
    private static final String X_AXIS = "＿＿";
    private static final String ORIGIN_COORDINATE = "+";
    private static final String COORDINATE_MARK = "*";
    private static final String SPACE = "%2s";
    private static final String LINE_MESSAGE = "두 점 사이 거리는 ";
    private static final String TRIANGLE_MESSAGE = "삼각형 넓이는 ";
    private static final String SQUARE_MESSAGE = "사각형 넓이는 ";

    public void printResult(int size, double result) {
        StringBuilder builder = new StringBuilder();
        builder.append(matchFigureMessage(size)).append(result).append(" 입니다.");
        System.out.print(builder);
    }

    private String matchFigureMessage(int size) {
        if (size == 2) {
            return LINE_MESSAGE;
        }
        if (size == 3) {
            return TRIANGLE_MESSAGE;
        }
        return SQUARE_MESSAGE;
    }

    public void printCoordinateSystem(Coordinates coordinates) {
        printYAxis(coordinates);
        printXAxis();
    }

    private void printYAxis(Coordinates coordinates) {
        for (int i = CoordinateNumber.MAX_COORDINATE_NUMBER; i > CoordinateNumber.MIN_COORDINATE_NUMBER; i--) {
            System.out.printf(SPACE, printEvenNumber(i));
            System.out.print(Y_AXIS);
            printCoordinate(coordinates, i);
            printNewLine();
        }
    }

    private void printCoordinate(Coordinates coordinates, int y) {
        for (int x = CoordinateNumber.MIN_COORDINATE_NUMBER + 1; x < CoordinateNumber.MAX_COORDINATE_NUMBER; x++) {
            System.out.printf(SPACE, containCoordinate(coordinates, x, y));
        }
    }

    private String containCoordinate(Coordinates coordinates, int x, int y) {
        if (coordinates.isContainCoordinate(new Coordinate(x + Coordinate.DELIMITER + y))) {
            return COORDINATE_MARK;
        }

        return " ";
    }

    private void printXAxis() {
        printBlank();
        System.out.printf(SPACE, ORIGIN_COORDINATE);
        for (int i = CoordinateNumber.MIN_COORDINATE_NUMBER; i <= CoordinateNumber.MAX_COORDINATE_NUMBER; i++) {
            System.out.print(X_AXIS);
        }
        printNewLine();
        printXNumber();
    }

    private void printXNumber() {
        printBlank();
        for (int i = CoordinateNumber.MIN_COORDINATE_NUMBER; i <= CoordinateNumber.MAX_COORDINATE_NUMBER; i++) {
            System.out.printf(SPACE, printEvenNumber(i));
        }
        printNewLine();
    }

    private String printEvenNumber(int number) {
        if (number % 2 == 0) {
            return String.valueOf(number);
        }

        return " ";
    }

    private void printNewLine() {
        System.out.println();
    }

    private void printBlank() {
        System.out.print(" ");
    }
}

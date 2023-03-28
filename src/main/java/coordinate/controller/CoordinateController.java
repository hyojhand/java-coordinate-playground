package coordinate.controller;

import coordinate.domain.Coordinate;
import coordinate.domain.Coordinates;
import coordinate.domain.Figure;
import coordinate.domain.FigureMatch;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoordinateController {

    private final InputView inputView;
    private final OutputView outputView;
    private static final String DELIMITER = ",";

    public CoordinateController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Coordinates coordinates = new Coordinates(mappingCoordinate(inputView.inputCoordinates()));
        outputView.printCoordinateSystem(coordinates);

        FigureMatch figureMatch = FigureMatch.matchFigure(coordinates.getCoordinateSize());
        Figure figure = figureMatch.create(coordinates);

        outputView.printResult(coordinates.getCoordinateSize(), figure.calculateArea());
    }

    private List<Coordinate> mappingCoordinate(List<String> coordinateValues) {
        return coordinateValues.stream()
                .map(value -> {
                    List<Integer> numbers = splitNumbers(value);
                    return new Coordinate(numbers.get(0), numbers.get(1));
                })
                .collect(Collectors.toList());
    }

    private List<Integer> splitNumbers(String numberValue) {
        return Arrays.stream(numberValue.trim().split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}

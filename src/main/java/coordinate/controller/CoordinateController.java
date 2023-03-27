package coordinate.controller;

import coordinate.domain.Coordinates;
import coordinate.domain.Figure;
import coordinate.domain.FigureMatch;
import coordinate.domain.Result;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateController {

    private final InputView inputView;
    private final OutputView outputView;

    public CoordinateController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Coordinates coordinates = new Coordinates(inputView.inputCoordinates());
        outputView.printCoordinateSystem(coordinates);

        FigureMatch figureMatch = FigureMatch.matchFigure(coordinates.getCoordinateSize());
        Figure figure = figureMatch.create(coordinates);

        Result result = new Result(figureMatch.getMessage(), figure.calculateArea());
        outputView.printResult(result);
    }
}

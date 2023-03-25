package coordinate;

import coordinate.controller.CoordinateController;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class Main {
    public static void main(String[] args) {
        CoordinateController controller = new CoordinateController(new InputView(),new OutputView());
        controller.start();
    }
}

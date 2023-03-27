package coordinate.domain;

public class Result {

    private final String result;

    public Result(String message, double area) {
        this.result = message + String.format("%.6f",area);
    }

    public String getResult() {
        return result;
    }
}

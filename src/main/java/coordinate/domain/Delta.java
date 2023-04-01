package coordinate.domain;

import java.util.Objects;

public class Delta {

    private final double delta;

    public Delta(double delta) {
        this.delta = delta;
    }

    public Delta sum(Delta otherDelta) {
        return new Delta(delta + otherDelta.delta);
    }

    public double square() {
        return Math.pow(delta, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delta delta1 = (Delta) o;
        return Double.compare(delta1.delta, delta) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(delta);
    }
}

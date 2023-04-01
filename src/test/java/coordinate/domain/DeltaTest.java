package coordinate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DeltaTest {

    @Test
    @DisplayName("변화량 더하기 테스트")
    void delta_Sum_Test() {
        Delta delta = new Delta(1);
        Delta otherDelta = new Delta(2);
        assertThat(delta.sum(otherDelta)).isEqualTo(new Delta(3));
    }

    @Test
    @DisplayName("변화량 제곱 테스트")
    void delta_Square_Test() {
        Delta delta = new Delta(2);
        assertThat(delta.square()).isEqualTo(4);
    }
}
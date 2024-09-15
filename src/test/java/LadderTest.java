import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    void basicTest() {
        Ladder ladder = new Ladder(3,4);

        ladder.drawLine(Position.of(2,3,1));

        assertThat(ladder.run(1)).isEqualTo(2);

    }
}
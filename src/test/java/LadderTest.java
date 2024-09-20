import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderTest {
    @Test
    void Ladder_init() {
        int row = 5, col = 5;

        Ladder ladder = new Ladder(row, col);

        assertThat(ladder).isNotNull();
    }

    @Test
    void Ladder() {

        Ladder ladder = new Ladder(3, 4);
        ladder.drawLine(0, 1);
        ladder.drawLine(1, 2);

        int result = ladder.run(1);
        assertThat(result).isEqualTo(2);
    }
}
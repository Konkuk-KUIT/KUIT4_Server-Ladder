import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    void normalGameTest() {
        Ladder ladder = new Ladder(5,5);

        ladder.drawLine(Position.of(2,3,Direction.LEFT));
        ladder.drawLine(Position.of(3,3,Direction.RIGHT));
        ladder.drawLine(Position.of(1,1,Direction.RIGHT));

        assertThat(ladder.run(1)).isEqualTo(4);
    }
    
    @Test
    void drawingOverlappedLine() {
        Ladder ladder = new Ladder(5,5);

        ladder.drawLine(Position.of(2,3,Direction.LEFT));


        assertThatThrownBy(() -> ladder.drawLine(Position.of(2,3,Direction.RIGHT))).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void drawingOutOfRangeLine() {
        Ladder ladder = new Ladder(5,5);

        ladder.drawLine(Position.of(2,3,Direction.LEFT));
        assertThatThrownBy(() -> ladder.drawLine(Position.of(4,4,Direction.RIGHT))).isInstanceOf(ArrayIndexOutOfBoundsException.class);

    }
}
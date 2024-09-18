import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private Ladder ladder;

    @Test
    public void initColumns() {
        ladder = new Ladder(4, 4);
    }

    @Test
    public void drawRows() {
        initColumns();
        ladder.drawLine(new Position(0, 0), new Position(0, 1));
        ladder.drawLine(new Position(0, 2), new Position(0, 3));
        ladder.drawLine(new Position(2, 1), new Position(2, 2));
        ladder.drawLine(new Position(1, 0), new Position(1, 1));
        ladder.drawLine(new Position(3, 2), new Position(3, 3));
    }

    @Test
    public void runLadder() {
        drawRows();

        int result = ladder.run(0);
        assertThat(result).isEqualTo(0);

        result = ladder.run(1);
        assertThat(result).isEqualTo(3);

        result = ladder.run(2);
        assertThat(result).isEqualTo(2);

        result = ladder.run(3);
        assertThat(result).isEqualTo(1);
    }
}
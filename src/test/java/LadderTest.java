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
        ladder.drawLine(new Position(1, 1), new Position(1, 2));
        ladder.drawLine(new Position(1, 3), new Position(1, 4));
        ladder.drawLine(new Position(3, 2), new Position(3, 3));
        ladder.drawLine(new Position(2, 1), new Position(2, 2));
        ladder.drawLine(new Position(4, 3), new Position(4, 4));
    }

    @Test
    public void runLadder() {
        drawRows();

        int result = ladder.run(1);
        assertThat(result).isEqualTo(1);

        result = ladder.run(2);
        assertThat(result).isEqualTo(4);

        result = ladder.run(3);
        assertThat(result).isEqualTo(3);

        result = ladder.run(4);
        assertThat(result).isEqualTo(2);
    }
}
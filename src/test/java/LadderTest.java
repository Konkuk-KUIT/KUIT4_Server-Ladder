import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void createLadder() {
        Ladder ladder = new Ladder(5, 7);
        int[] len = ladder.getLadderLength();

        Assertions.assertThat(len[0]).isEqualTo(5);
        Assertions.assertThat(len[1]).isEqualTo(7);

        /* Assertions.assertThat(len).hasSize(3); 도 있는데 열 크기 검사가 넘 귀찮은.. (반복문 써야함)
        Assertions.assertThat(len[0]).hasSize(3);   // 오류 뜸
        */
    }

    @Test
    void drawLine() {
        Ladder ladder = new Ladder(5, 7);

        PositionOfLine position = PositionOfLine.of(3, 2);

        ladder.drawLine(position);

        Assertions.assertThat(ladder.isLine(position)).isEqualTo(true);
    }

    @Test
    void arrive() {
        Ladder ladder = new Ladder(5, 7);

        ladder.drawLine(PositionOfLine.of(0, 0));
        ladder.drawLine(PositionOfLine.of(1, 1));
        ladder.drawLine(PositionOfLine.of(1, 3));
        ladder.drawLine(PositionOfLine.of(2, 0));
        ladder.drawLine(PositionOfLine.of(2, 2));
        ladder.drawLine(PositionOfLine.of(3, 0));
        ladder.drawLine(PositionOfLine.of(3, 4));
        ladder.drawLine(PositionOfLine.of(4, 2));
        ladder.drawLine(PositionOfLine.of(4, 5));

        int end = ladder.run(6);

        Assertions.assertThat(end).isEqualTo(5);        // 사람이 직접 검사?
    }
}
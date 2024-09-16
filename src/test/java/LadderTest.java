import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void createLadder() {
        Ladder ladder = new Ladder(3, 3);
        int[] len = ladder.getLadderLength();

        Assertions.assertThat(len[0]).isEqualTo(3);
        Assertions.assertThat(len[1]).isEqualTo(3);

        /* Assertions.assertThat(len).hasSize(3); 도 있는데 열 크기 검사가 넘 귀찮은..
        Assertions.assertThat(len[0]).hasSize(3);   // 오류 뜸
        */
    }

    @Test
    void drawLine() {
        Ladder ladder = new Ladder(3, 3);

        ladder.drawLine(PositionOfLine.of(2, 3));

        Assertions.assertThat(ladder.isLine(PositionOfLine.of(2,3))).isEqualTo(true);
    }

    @Test
    void arrive() {
        Ladder ladder = new Ladder(3, 3);

        ladder.drawLine(PositionOfLine.of(2, 0));

        int end = ladder.run(0);

        Assertions.assertThat(end).isEqualTo(1);
    }



}
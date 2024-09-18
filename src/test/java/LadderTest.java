import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리 라인 작성 확인")
    void printLadder() {
        Ladder ladder = new Ladder(4, 4);

        ladder.drawLine(0,0);
        ladder.drawLine(1,0);
        ladder.drawLine(2,1);
        ladder.drawLine(0,2);

        ladder.printLadder();
    }

    @Test
    @DisplayName("가장 바깥 사다리에는 라인을 그릴 수 없음")
    void cannotDrawOutermost() {
        Ladder ladder = new Ladder(4, 4);

        assertThatThrownBy(() -> ladder.drawLine(1,3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 범위 밖 접근")
    void ladderOutOfBound() {
        Ladder ladder = new Ladder(4, 4);

        assertThatThrownBy(() -> ladder.drawLine(-1,4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 타기 예시 (3->1)")
    void runLadder() {
        Ladder ladder = new Ladder(4, 4);

        ladder.drawLine(0,0);
        ladder.drawLine(1,0);
        ladder.drawLine(2,1);
        ladder.drawLine(0,2);

        assertThat(ladder.run(3)).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리 타기 예시 (0->0)")
    void runOneLineLadder() {
        Ladder ladder = new Ladder(1, 1);

        assertThat(ladder.run(0)).isEqualTo(0);
    }

}
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리 라인 작성 확인")
    void printLadder() {
        Ladder ladder = new Ladder(UnsignedInteger.from(4), UnsignedInteger.from(4));

        ladder.drawLine(new Coordinate(UnsignedInteger.from(0), UnsignedInteger.from(0)));
        ladder.drawLine(new Coordinate(UnsignedInteger.from(1), UnsignedInteger.from(0)));
        ladder.drawLine(new Coordinate(UnsignedInteger.from(2), UnsignedInteger.from(1)));
        ladder.drawLine(new Coordinate(UnsignedInteger.from(0), UnsignedInteger.from(2)));

        ladder.printLadder();
    }

    @Test
    @DisplayName("가장 바깥 사다리 라인 그리기 불가")
    void cannotDrawOutermost() {
        Ladder ladder = new Ladder(UnsignedInteger.from(4), UnsignedInteger.from(4));

        assertThatThrownBy(() -> ladder.drawLine(new Coordinate(UnsignedInteger.from(1), UnsignedInteger.from(3))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 범위 밖 접근")
    void ladderOutOfBound() {
        Ladder ladder = new Ladder(UnsignedInteger.from(4), UnsignedInteger.from(4));

        assertThatThrownBy(() -> ladder.drawLine(new Coordinate(UnsignedInteger.from(-1), UnsignedInteger.from(4))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 타기 예시 (3->1)")
    void runLadder() {
        Ladder ladder = new Ladder(UnsignedInteger.from(4), UnsignedInteger.from(4));

        ladder.drawLine(new Coordinate(UnsignedInteger.from(0), UnsignedInteger.from(0)));
        ladder.drawLine(new Coordinate(UnsignedInteger.from(1), UnsignedInteger.from(0)));
        ladder.drawLine(new Coordinate(UnsignedInteger.from(2), UnsignedInteger.from(1)));
        ladder.drawLine(new Coordinate(UnsignedInteger.from(0), UnsignedInteger.from(2)));

        assertThat(ladder.run(3)).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리 타기 예시 (0->0)")
    void runOneLineLadder() {
        Ladder ladder = new Ladder(UnsignedInteger.from(1), UnsignedInteger.from(1));

        assertThat(ladder.run(0)).isEqualTo(0);
    }

}
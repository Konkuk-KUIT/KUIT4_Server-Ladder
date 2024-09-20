import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void testRunWithoutLines() {
        Ladder ladder = new Ladder(5, 3);

        // 라인이 없는 경우 출발한 곳에서 도착
        assertEquals(0, ladder.run(0));
        assertEquals(1, ladder.run(1));
        assertEquals(2, ladder.run(2));

    }

    @Test
    void testRunWithSingleLine() {
        Ladder ladder = new Ladder(3, 3);

        ladder.drawLine(Position.create(1, 0)); // 첫 번째 줄 첫 번째 칸에 가로선

        assertEquals(1, ladder.run(0)); // 첫 번째 사람이 두 번째로 이동
        assertEquals(0, ladder.run(1)); // 두 번째 사람이 첫 번째로 이동
        assertEquals(2, ladder.run(2)); // 세 번째 사람은 그대로
    }

    @Test
    void testRunWithMultipleLines() {
        Ladder ladder = new Ladder(5, 7);

        // 여러 위치에 가로선 추가
        ladder.drawLine(Position.create(0, 0));
        ladder.drawLine(Position.create(0, 3));
        ladder.drawLine(Position.create(1, 2));
        ladder.drawLine(Position.create(2, 1));
        ladder.drawLine(Position.create(2, 4));
        ladder.drawLine(Position.create(3, 0));
        ladder.drawLine(Position.create(3, 4));
        ladder.drawLine(Position.create(4, 1));

        assertEquals(1, ladder.run(0));
        assertEquals(2, ladder.run(1));
        assertEquals(3, ladder.run(2));
        assertEquals(4, ladder.run(3));
        assertEquals(0, ladder.run(4));
        assertEquals(5, ladder.run(5));
    }
}

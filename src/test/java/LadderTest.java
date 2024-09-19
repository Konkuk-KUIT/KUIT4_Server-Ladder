import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void testLadderCreation() {
        Ladder ladder = new Ladder(5, 3);
        assertThat(ladder).isNotNull();
    }

    @Test
    @DisplayName("사다리 라인 생성 테스트")
    public void testDrawLine() {

        Ladder ladder = new Ladder(5, 3);
        int[][] rows = ladder.getRows();

        Line line = new Line(1, 2, 0, rows);

        assertThat(rows[0][0]).isEqualTo(1);
        assertThat(rows[0][1]).isEqualTo(1);

    }

    @Test
    @DisplayName("사다리 게임 테스트")
    void testRun() {
        Ladder ladder = new Ladder(5, 3);
        int[][] rows = ladder.getRows();

        rows[1][0] = 1;
        rows[1][1] = 1;
        rows[2][1] = 1;
        rows[2][2] = 1;
        rows[3][1] = 1;
        rows[3][2] = 1;

        assertThat(ladder.run(0)).isEqualTo(1);
        assertThat(ladder.run(1)).isEqualTo(0);
        assertThat(ladder.run(2)).isEqualTo(2);
        }

}
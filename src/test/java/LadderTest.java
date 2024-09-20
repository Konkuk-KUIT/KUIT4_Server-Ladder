import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {

    @Test
    @DisplayName("빈 사다리 테스트")
    void withoutLines() {
        Ladder ladder = new Ladder(3, 3);

        System.out.println("Empty Ladder:");
        ladder.printLadder();

        assertThat(ladder.run(1)).isEqualTo(1);
        assertThat(ladder.run(2)).isEqualTo(2);
        assertThat(ladder.run(3)).isEqualTo(3);
    }

    @Test
    @DisplayName("중복 라인 방지")
    public void testDrawLine() {
        Ladder ladder = new Ladder(4, 5);
        ladder.drawLine(0, 0);
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(0, 1));
        ladder.drawLine(1, 2);
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(1, 1));
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(1, 3));

        System.out.println("Ladder structure:");
        ladder.printLadder();
    }

    @Test
    @DisplayName("라인 추가 후 실행")
    void WithLines() {
        Ladder ladder = new Ladder(3, 4);
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 0);

        System.out.println("With Lines Ladder structure:");
        ladder.printLadder();

        assertThat(ladder.run(1)).isEqualTo(1);
        assertThat(ladder.run(2)).isEqualTo(2);
        assertThat(ladder.run(3)).isEqualTo(3);
        assertThat(ladder.run(4)).isEqualTo(4);
    }

    @Test
    @DisplayName("복잡한 사다리 테스트")
    public void testRunComplexLadder() {
        Ladder ladder = new Ladder(5, 6);
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 2);
        ladder.drawLine(2, 4);
        ladder.drawLine(3, 1);
        ladder.drawLine(4, 3);

        System.out.println("Complex Ladder structure:");
        ladder.printLadder();

        assertThat(ladder.run(1)).isEqualTo(3);
        assertThat(ladder.run(2)).isEqualTo(1);
        assertThat(ladder.run(3)).isEqualTo(5);
        assertThat(ladder.run(4)).isEqualTo(2);
        assertThat(ladder.run(5)).isEqualTo(6);
        assertThat(ladder.run(6)).isEqualTo(4);
    }

    @Test
    @DisplayName("잘못된 위치에 선 그리기 시도")
    public void testInvalidDrawLine() {
        Ladder ladder = new Ladder(3, 3);
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(3, 0));
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(0, -1));
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(0, 2));

        System.out.println("Invalid Ladder structure:");
        ladder.printLadder();
    }
}
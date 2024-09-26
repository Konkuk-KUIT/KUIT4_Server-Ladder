import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderRunnerTest {

    @Test
    @DisplayName("오른쪽 이동")
    void testMoveRight() {

        // Given
        Ladder ladder = new Ladder(5, 3);
        ladder.addLine(0, 1, 0);
        ladder.addLine(1, 2, 1);

        // When
        LadderRunner runner = new LadderRunner(ladder, 1);
        int finalPosition = runner.run()+1;

        //Then
        Assertions.assertEquals(3, finalPosition);
    }

    @Test
    @DisplayName("왼쪽 이동")
    void testMoveLeft() {
        // Given
        Ladder ladder = new Ladder(5, 3);
        ladder.addLine(1, 2, 0);
        ladder.addLine(0, 1, 1);
        LadderRunner runner = new LadderRunner(ladder, 3);

        // When
        int finalPosition = runner.run()+1;

        // Then
        Assertions.assertEquals(1, finalPosition);
    }

    @Test
    @DisplayName("사다리가 연달아 있는 경우")
    void testMoveBetween() {
        // Given
        Ladder ladder = new Ladder(5, 4);
        ladder.addLine(0, 1, 1);
        ladder.addLine(2, 3, 1);
        LadderRunner runner = new LadderRunner(ladder, 3);

        // When
        int finalPosition = runner.run() + 1;

        // Then
        Assertions.assertEquals(4, finalPosition);
    }


}
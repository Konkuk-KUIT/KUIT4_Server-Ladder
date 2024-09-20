import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

// All test should be done with Junit test code

// check Ladder class work normally
// check method of run return right value in various situation.
class LadderTest {
    // 모든 테스트의 인수는 수학적 좌표 형식으로 주어야 함 !

    @Test
    @DisplayName("사다리 생성검사")
    void createLadder() {
        Ladder ladder = Ladder.createLadder(NaturalNum.from(3), NaturalNum.from(4));
        // compare size of ladder with row * numberOfPerson
        assertThat(ladder.getRowsLength()).isEqualTo(ladder.getIntRow() * ladder.getIntNumberOfPerson());
    }

    // Test if drawingLine acts normally and especially check how drawingLine acts at the right end.
    @Test
    void testDrawLine() {
        Ladder ladder = Ladder.createLadder(NaturalNum.from(3), NaturalNum.from(4));
        ladder.drawLine(LadderLine.from(NaturalNum.from(2), NaturalNum.from(2)));
        ladder.drawLine(LadderLine.from(NaturalNum.from(3), NaturalNum.from(3)));
//        assertThat(ladder.getMatrixValue(2,2)).isEqualTo(1);
//        assertThat(ladder.getMatrixValue(3,2)).isEqualTo(-1);
    }
//
    // Test if it arrives right destination, when row is given
    @Test
    void testRunLadder() {
        Ladder ladder = Ladder.createLadder(NaturalNum.from(3), NaturalNum.from(4));
        ladder.drawLine(LadderLine.from(NaturalNum.from(2), NaturalNum.from(2)));
        ladder.drawLine(LadderLine.from(NaturalNum.from(3), NaturalNum.from(3)));
        assertThat(ladder.run(NaturalNum.from(2))).isEqualTo(4);
        // assertThat(ladder.run(NaturalNum.from(1))).isEqualTo(4);
    }



}
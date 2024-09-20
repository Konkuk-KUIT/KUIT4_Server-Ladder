import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import second.Ladder;
import third.LadderGameController;
import third.LadderWrapper;
import third.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ThirdTest {
    @Test
    @DisplayName("라인 생성 확인")
    void drawlineTest() {
        //given
        LadderWrapper ladder = LadderWrapper.rowPersonOf(3, 3);
        LadderGameController controller = LadderGameController.ladderFrom(ladder);

        //when
        controller.drawline(Position.rowColOf(0,0), Position.rowColOf(0,1));

        //then
        assertThat(ladder.getValue(Position.rowColOf(0,0))).isEqualTo(1);
        assertThat(ladder.getValue(Position.rowColOf(0,1))).isEqualTo(-1);
        assertThat(ladder.getValue(Position.rowColOf(0,2))).isEqualTo(0);
    }

    @Test
    @DisplayName("범위 초과로 인한 라인 생성 불가 확인1")
    void drawlineOutOfLimitTest1() {
        //given
        LadderWrapper ladder = LadderWrapper.rowPersonOf(3, 3);
        LadderGameController controller = LadderGameController.ladderFrom(ladder);

        //when
        //then
        assertThatThrownBy(()->controller.drawline(Position.rowColOf(-1,0), Position.rowColOf(-1,1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("범위 초과로 인한 라인 생성 불가 확인2")
    void drawlineOutOfLimitTest2() {
        //given
        LadderWrapper ladder = LadderWrapper.rowPersonOf(3, 3);
        LadderGameController controller = LadderGameController.ladderFrom(ladder);

        //when
        //then
        assertThatThrownBy(()->controller.drawline(Position.rowColOf(2,3), Position.rowColOf(2,4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("미인접 좌표로 설정으로 인한 라인 생성 불가 확인")
    void drawlineNotAvailPairTest() {
        //given
        LadderWrapper ladder = LadderWrapper.rowPersonOf(3, 3);
        LadderGameController controller = LadderGameController.ladderFrom(ladder);

        //when
        //then
        assertThatThrownBy(()->controller.drawline(Position.rowColOf(1,1), Position.rowColOf(2,3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복으로 인한 라인 생성 불가 확인")
    void drawDupLineTest() {
        //given
        LadderWrapper ladder = LadderWrapper.rowPersonOf(4, 3);
        LadderGameController controller = LadderGameController.ladderFrom(ladder);

        //when
        controller.drawline(Position.rowColOf(1,1), Position.rowColOf(1,2));

        //then
        assertThatThrownBy(()->controller.drawline(Position.rowColOf(1,2), Position.rowColOf(1,3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("runTest1")
    void runTest1() {
        //given
        LadderWrapper ladder = LadderWrapper.rowPersonOf(1, 1);
        LadderGameController controller = LadderGameController.ladderFrom(ladder);
        //when
        int end = controller.run(1);

        //then
        assertThat(end).isEqualTo(1);
    }

    @Test
    @DisplayName("runTest2")
    void runTest2() {
        //given
        LadderWrapper ladder = LadderWrapper.rowPersonOf(4, 3);
        LadderGameController controller = LadderGameController.ladderFrom(ladder);

        controller.drawline(Position.rowColOf(0,0), Position.rowColOf(0,1));

        //when
        int end = controller.run(1);

        //then
        assertThat(end).isEqualTo(2);
    }

    @Test
    @DisplayName("runTest3")
    void runTest3() {
        //given
        LadderWrapper ladder = LadderWrapper.rowPersonOf(4, 3);
        LadderGameController controller = LadderGameController.ladderFrom(ladder);

        controller.drawline(Position.rowColOf(0,0), Position.rowColOf(0,1));
        controller.drawline(Position.rowColOf(1,1), Position.rowColOf(1,2));

        //when
        int end1 = controller.run(1);
        int end2 = controller.run(2);
        int end3 = controller.run(3);

        //then
        assertThat(end1).isEqualTo(3);
        assertThat(end2).isEqualTo(1);
        assertThat(end3).isEqualTo(2);
    }
}

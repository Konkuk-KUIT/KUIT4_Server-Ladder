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
        LadderWrapper ladder = new LadderWrapper(3, 3);
        LadderGameController controller = new LadderGameController(ladder);

        //when
        controller.drawline(new Position(0,0), new Position(0,1));

        //then
        assertThat(ladder.rows[0][0]).isEqualTo(1);
        assertThat(ladder.rows[0][1]).isEqualTo(-1);
        assertThat(ladder.rows[0][2]).isEqualTo(0);
    }

    @Test
    @DisplayName("범위 초과로 인한 라인 생성 불가 확인1")
    void drawlineOutOfLimitTest1() {
        //given
        LadderWrapper ladder = new LadderWrapper(3, 3);
        LadderGameController controller = new LadderGameController(ladder);

        //when
        //then
        assertThatThrownBy(()->controller.drawline(new Position(-1,0), new Position(-1,1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("범위 초과로 인한 라인 생성 불가 확인2")
    void drawlineOutOfLimitTest2() {
        //given
        LadderWrapper ladder = new LadderWrapper(3, 3);
        LadderGameController controller = new LadderGameController(ladder);

        //when
        //then
        assertThatThrownBy(()->controller.drawline(new Position(2,3), new Position(2,4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("미인접 좌표로 설정으로 인한 라인 생성 불가 확인")
    void drawlineNotAvailPairTest() {
        //given
        LadderWrapper ladder = new LadderWrapper(3, 3);
        LadderGameController controller = new LadderGameController(ladder);

        //when
        //then
        assertThatThrownBy(()->controller.drawline(new Position(1,1), new Position(2,3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복으로 인한 라인 생성 불가 확인")
    void drawDupLineTest() {
        //given
        LadderWrapper ladder = new LadderWrapper(4, 3);
        LadderGameController controller = new LadderGameController(ladder);

        //when
        controller.drawline(new Position(1,1), new Position(1,2));

        //then
        assertThatThrownBy(()->controller.drawline(new Position(1,2), new Position(1,3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("runTest1")
    void runTest1() {
        //given
        LadderWrapper ladder = new LadderWrapper(1, 1);
        LadderGameController controller = new LadderGameController(ladder);
        //when
        int end = controller.run(1);

        //then
        assertThat(end).isEqualTo(1);
    }

    @Test
    @DisplayName("runTest2")
    void runTest2() {
        //given
        LadderWrapper ladder = new LadderWrapper(4, 3);
        LadderGameController controller = new LadderGameController(ladder);

        controller.drawline(new Position(0,0), new Position(0,1));

        //when
        int end = controller.run(1);

        //then
        assertThat(end).isEqualTo(2);
    }

    @Test
    @DisplayName("runTest3")
    void runTest3() {
        //given
        LadderWrapper ladder = new LadderWrapper(4, 3);
        LadderGameController controller = new LadderGameController(ladder);

        controller.drawline(new Position(0,0), new Position(0,1));
        controller.drawline(new Position(1,1), new Position(1,2));

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

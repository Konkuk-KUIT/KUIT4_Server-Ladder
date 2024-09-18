import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderPTest {

    @Test
    @DisplayName("라인 생성 확인")
    void drawlineTest() {
        //given
        LadderP ladder = new LadderP(4, 3);

        //when
        ladder.drawline(new PositionP(1,1), new PositionP(1, 2));

        //then
        assertThat(ladder.rows[1][1]).isEqualTo(1);
        assertThat(ladder.rows[1][2]).isEqualTo(1);
        assertThat(ladder.rows[1][3]).isEqualTo(0);
    }

    @Test
    @DisplayName("범위 초과로 인한 라인 생성 불가 확인1")
    void drawlineOutOfLimitTest1() {
        //given
        LadderP ladder = new LadderP(5, 3);

        //when
        //then
        assertThatThrownBy(()->ladder.drawline(new PositionP(0,1), new PositionP(0, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("범위 초과로 인한 라인 생성 불가 확인2")
    void drawlineOutOfLimitTest2() {
        //given
        LadderP ladder = new LadderP(5, 3);

        //when
        //then
        assertThatThrownBy(()->ladder.drawline(new PositionP(2,3), new PositionP(2, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("미인접 좌표로 설정으로 인한 라인 생성 불가 확인")
    void drawlineNotAvailPairTest() {
        //given
        LadderP ladder = new LadderP(5, 3);

        //when
        //then
        assertThatThrownBy(()->ladder.drawline(new PositionP(1,1), new PositionP(2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복으로 인한 라인 생성 불가 확인")
    void drawDupLineTest() {
        //given
        LadderP ladder = new LadderP(4, 3);

        //when
        ladder.drawline(new PositionP(1,1), new PositionP(1, 2));

        //then
        assertThatThrownBy(()->ladder.drawline(new PositionP(1,2), new PositionP(1, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("runTest1")
    void runTest1() {
        //given
        LadderP ladder = new LadderP(1, 1);

        //when
        int end = ladder.run(1);

        //then
        assertThat(end).isEqualTo(1);
    }

    @Test
    @DisplayName("runTest2")
    void runTest2() {
        //given
        LadderP ladder = new LadderP(4, 3);
        ladder.drawline(new PositionP(1,1), new PositionP(1, 2));

        //when
        int end = ladder.run(1);

        //then
        assertThat(end).isEqualTo(2);
    }

    @Test
    @DisplayName("runTest3")
    void runTest3() {
        //given
        LadderP ladder = new LadderP(5, 3);
        ladder.drawline(new PositionP(1,1), new PositionP(1, 2));
        ladder.drawline(new PositionP(2,2), new PositionP(2, 3));

        //when
        int end1 = ladder.run(1);
        int end2 = ladder.run(2);
        int end3 = ladder.run(3);

        //then
        assertThat(end1).isEqualTo(3);
        assertThat(end2).isEqualTo(1);
        assertThat(end3).isEqualTo(2);
    }
}

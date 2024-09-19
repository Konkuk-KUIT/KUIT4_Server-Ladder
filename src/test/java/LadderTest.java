import first.LadderP;
import first.PositionP;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import second.DrawPosition;
import second.Ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    @DisplayName("라인 생성 확인")
    void drawlineTest() {
        //given
        Ladder ladder = new Ladder(4, 3);

        //when
        ladder.drawline(0,0, 0, 1);

        //then
        assertThat(ladder.rows[0][0]).isEqualTo(1);
        assertThat(ladder.rows[0][1]).isEqualTo(-1);
        assertThat(ladder.rows[0][2]).isEqualTo(0);
    }

    @Test
    @DisplayName("범위 초과로 인한 라인 생성 불가 확인1")
    void drawlineOutOfLimitTest1() {
        //given
        Ladder ladder = new Ladder(5, 3);

        //when
        //then
        assertThatThrownBy(()->ladder.drawline(-1,1, -1, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("범위 초과로 인한 라인 생성 불가 확인2")
    void drawlineOutOfLimitTest2() {
        //given
        Ladder ladder = new Ladder(5, 3);

        //when
        //then
        assertThatThrownBy(()->ladder.drawline(2,3, 2, 4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("미인접 좌표로 설정으로 인한 라인 생성 불가 확인")
    void drawlineNotAvailPairTest() {
        //given
        Ladder ladder = new Ladder(5, 3);

        //when
        //then
        assertThatThrownBy(()->ladder.drawline(1,1, 2, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복으로 인한 라인 생성 불가 확인")
    void drawDupLineTest() {
        //given
        Ladder ladder = new Ladder(4, 3);

        //when
        ladder.drawline(1,1, 1, 2);

        //then
        assertThatThrownBy(()->ladder.drawline(1,2, 1, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("runTest1")
    void runTest1() {
        //given
        Ladder ladder = new Ladder(1, 1);

        //when
        int end = ladder.run(1);

        //then
        assertThat(end).isEqualTo(1);
    }

    @Test
    @DisplayName("runTest2")
    void runTest2() {
        //given
        Ladder ladder = new Ladder(4, 3);
        ladder.drawline(0,0, 0, 1);

        //when
        int end = ladder.run(1);

        //then
        assertThat(end).isEqualTo(2);
    }

    @Test
    @DisplayName("runTest3")
    void runTest3() {
        //given
        Ladder ladder = new Ladder(5, 3);
        ladder.drawline(0,0, 0, 1);
        ladder.drawline(1,1, 1, 2);

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

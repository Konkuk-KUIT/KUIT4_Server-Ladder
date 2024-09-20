import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리_생성() {
        //given
        int rowCount = 1;
        int personCount = 1;

        //when
        Ladder ladder = new Ladder(rowCount, personCount);

        //then
        assertThat(ladder).isNotNull();
    }

    @Test
    void 사다리_생성_rowCount_예외() {
        //given
        int rowCount = 0;
        int personCount = 1;

        //when
        //Ladder ladder = new Ladder(rowCount, personCount);

        //then
        assertThatThrownBy(() -> new Ladder(rowCount, personCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_생성_personCount_예외() {
        //given
        int rowCount = 1;
        int personCount = 0;

        //when
        //Ladder ladder = new Ladder(rowCount, personCount);

        //then
        assertThatThrownBy(() -> new Ladder(rowCount, personCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_1개_결과() {
        //given
        int rowCount = 1;
        int personCount = 1;
        Ladder ladder = new Ladder(rowCount, personCount);

        int ladderNumber = 0;

        //when
        int result = ladder.run(ladderNumber);

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 사다리_2개_결과() {
        //given
        int rowCount = 1;
        int personCount = 2;
        Ladder ladder = new Ladder(rowCount, personCount);

        int ladderNumber = 1;

        //when
        int result = ladder.run(ladderNumber);

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 사다리_drawLine_rowNumber_예외() {
        //given
        int rowCount = 1;
        int personCount = 2;
        Ladder ladder = new Ladder(rowCount, personCount);

        int rowNumber = 10;
        int columnNumber = 0;

        //when
        //ladder.drawLine(rowNumber, columnNumber);

        //then
        assertThatThrownBy(() -> ladder.drawLine(rowNumber, columnNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_3개_라인1개_결과() {
        //given
        int rowCount = 1;
        int personCount = 3;
        Ladder ladder = new Ladder(rowCount, personCount);

        int rowNumber = 0;
        int columnNumber = 0;
        ladder.drawLine(rowNumber, columnNumber);

        int ladderNumber1 = 0;
        int ladderNumber2 = 1;
        int ladderNumber3 = 2;

        //when
        int result1 = ladder.run(ladderNumber1);
        int result2 = ladder.run(ladderNumber2);
        int result3 = ladder.run(ladderNumber3);

        //then
        assertThat(result1).isEqualTo(1);
        assertThat(result2).isEqualTo(0);
        assertThat(result3).isEqualTo(2);
    }
}
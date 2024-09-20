import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class RowTest {

    @Test
    void row_생성() {
        //given
        int personCount = 1;

        //when
        Row row = new Row(personCount);

        //then
        assertThat(row).isNotNull();
    }

    @Test
    void row_라인그리기_범위밖columnNumber_예외() {
        //given
        int personCount = 3;
        Row row = new Row(personCount);

        int columnNumber = 2;

        //when
        //row.drawLine(columnNumber);

        //then
        assertThatThrownBy(() -> row.drawLine(columnNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void row_라인그리기_이미그려진columnNumber_예외() {
        //given
        int personCount = 5;
        Row row = new Row(personCount);

        int prevColumnNumber = 2;
        row.drawLine(prevColumnNumber);

        int columnNumber = 3;

        //when
        //row.drawLine(columnNumber);

        //then
        assertThatThrownBy(() -> row.drawLine(columnNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void row_nextLadderNumber_ladderNumber_예외() {
        //given
        int personCount = 5;
        Row row = new Row(personCount);

        int ladderNumber = 10;

        //when
        //row.nextLadderNumber(ladderNumber);

        //then
        assertThatThrownBy(() -> row.nextLadderNumber(ladderNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void row_nextLadderNumber_결과() {
        //given
        int personCount = 3;
        Row row = new Row(personCount);

        int columnNumber = 1;
        row.drawLine(columnNumber);

        int ladderNumber1 = 0;
        int ladderNumber2 = 1;
        int ladderNumber3 = 2;

        //when
        int result1 = row.nextLadderNumber(ladderNumber1);
        int result2 = row.nextLadderNumber(ladderNumber2);
        int result3 = row.nextLadderNumber(ladderNumber3);

        //then
        assertThat(result1).isEqualTo(0);
        assertThat(result2).isEqualTo(2);
        assertThat(result3).isEqualTo(1);
    }
}
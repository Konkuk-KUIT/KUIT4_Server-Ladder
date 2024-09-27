package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RowTest {

    @Test
    void 한_칸_사다리_이동() {
        //given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(2);
        Row row = new Row(numberOfPerson);

        //when
        LadderPosition ladderPosition = new LadderPosition(0, 0);
        row.nextPosition(ladderPosition);

        //then
        assertThat(ladderPosition.getValueY()).isEqualTo(0);
    }

    @Test
    void 두_칸_사다리_선_이동() {
        //given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(2);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(0));

        //when
        LadderPosition ladderPosition = new LadderPosition(0, 0);
        row.nextPosition(ladderPosition);

        //then
        assertThat(ladderPosition.getValueY()).isEqualTo(1);

        //when
        ladderPosition = new LadderPosition(0, 1);
        row.nextPosition(ladderPosition);

        //then
        assertThat(ladderPosition.getValueY()).isEqualTo(0);
    }

    @Test
    void 세_칸_사다리_선_이동() {
        //given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(0));

        //when
        LadderPosition ladderPosition = new LadderPosition(0, 0);
        row.nextPosition(ladderPosition);

        //then
        assertThat(ladderPosition.getValueY()).isEqualTo(1);

        //when
        ladderPosition = new LadderPosition(0, 1);
        row.nextPosition(ladderPosition);

        //then
        assertThat(ladderPosition.getValueY()).isEqualTo(0);

        //when
        ladderPosition = new LadderPosition(0, 2);
        row.nextPosition(ladderPosition);

        //then
        assertThat(ladderPosition.getValueY()).isEqualTo(2);
    }

    @Test
    void 사다리_사람수_예외_처리() {
        assertThatThrownBy(() -> new Row(GreaterThanOne.from(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_최대_사람수_초과_예외() {
        //given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);

        LadderPosition ladderPosition = new LadderPosition(0, 3);

        //when

        //then
        assertThatThrownBy(() -> row.nextPosition(ladderPosition))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_최소_사람수_미만_예외() {
        //given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);

        //when

        //then
        assertThatThrownBy(() -> row.nextPosition(new LadderPosition(0, -1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_그리기_위치_초과_예외() {
        //given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);

        //when
        Position position = Position.from(3);

        //then
        assertThatThrownBy(() -> row.drawLine(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_그리기_위치_미만_예외() {
        //given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);

        //when

        //then
        assertThatThrownBy(() -> row.drawLine(Position.from(-1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_그리기_좌측_선_중복_예외() {
        //given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(0));

        //then
        assertThatThrownBy(() -> row.drawLine(Position.from(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_그리기_우측_선_중복_예외() {
        //given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(1));

        //then
        assertThatThrownBy(() -> row.drawLine(Position.from(0)))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void rowString_확인() {
        //given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.from(1));

        //when
        String rowString = row.getRowString();

        //then
        assertThat(rowString).isEqualTo("0 1 -1 ");
    }
}
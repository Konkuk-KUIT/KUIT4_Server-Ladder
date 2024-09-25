package ladder;

import ladder.info.Row;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RowTest {

    @Test
    void 한_칸_사다리_이동() {

        //given
        GreaterThanOne greaterThanOne = GreaterThanOne.from(2);
        Row row = new Row(greaterThanOne);

        //when
        Position position = Position.of(0,0);
        row.nextPosition(position);

        //then
        assertThat(position.getCol()).isEqualTo(0);
    }

    @Test
    void 두_칸_사다리_선_이동() {

        //given
        GreaterThanOne greaterThanOne = GreaterThanOne.from(2);
        Row row = new Row(greaterThanOne);
        row.drawLine(Position.of(0,0));

        //when
        Position position = Position.of(0,0);
        row.nextPosition(position);

        //then
        assertThat(position.getCol()).isEqualTo(1);

        //whenn
        position = Position.of(0,1);
        row.nextPosition(position);

        //then
        assertThat(position.getCol()).isEqualTo(0);
    }

    @Test
    void 세_칸_사다리_선_이동() {

        //given
        GreaterThanOne greaterThanOne = GreaterThanOne.from(3);
        Row row = new Row(greaterThanOne);
        row.drawLine(Position.of(0,0));

        //when
        Position position = Position.of(0,0);
        row.nextPosition(position);

        //then
        assertThat(position.getCol()).isEqualTo(1);

        //when
        position =  Position.of(0,1);
        row.nextPosition(position);

        //then
        assertThat(position.getCol()).isEqualTo(0);

        //when
        position =  Position.of(0,2);
        row.nextPosition(position);

        //then
        assertThat(position.getCol()).isEqualTo(2);
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

        //when
        Position position = Position.of(0,3);

        //then
        assertThatThrownBy(() -> row.nextPosition(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_최소_사람수_미만_예외() {

        //given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);

        //then
        assertThatThrownBy(() -> row.nextPosition(Position.of(0,-1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_그리기_위치_초과_예외() {

        //given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);

        //when
        Position position = Position.of(0,3);

        //then
        assertThatThrownBy(() -> row.drawLine(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_그리기_위치_미만_예외() {

        //given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);


        //then
        assertThatThrownBy(() -> row.drawLine(Position.of(0,-1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_그리기_좌측_선_중복_예외() {

        //given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0,0));

        //then
        assertThatThrownBy(() -> row.drawLine(Position.of(0,-1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_그리기_우측_선_중복_예외() {

        //given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0,1));

        //then
        assertThatThrownBy(() -> row.drawLine(Position.of(0,0)))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 사다리_행_이동_확인() {

        //given
        GreaterThanOne numberOfPerson = GreaterThanOne.from(2);
        Row row = new Row(numberOfPerson);
        Position position = Position.of(0,0);

        //when
        row.moveRow(position);

        //then
        assertThat(position.getRow()).isEqualTo(1);
    }
}
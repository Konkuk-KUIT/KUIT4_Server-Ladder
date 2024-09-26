import ladder.Row;
import ladder.constants.Direction;
import ladder.constants.nodeState;
import ladder.wrapper.unsignedInt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RowTest {

    @Test
    @DisplayName("생성자로 Row 객체가 생성되는지 확인")
    void newRowTest() {
        //when
        int column = 5;

        //given
        Row row = new Row(column);

        //then
        assertThat(row).isNotNull().isInstanceOf(Row.class);
    }

    @Test
    @DisplayName("LineLength가 Row의 길이를 적절히 반환하는지 확인")
    void LineLengthTest() {
        //when
        int column = 5;
        Row row = new Row(column);

        //given
        int length = row.LineLength();

        //then
        assertThat(length).isEqualTo(column);
    }

    @Test
    @DisplayName("drawLineAt이 node 배열을 적절히 수정하는지 확인")
    void drawLineAtTest() {
        //when
        int column = 5;
        Row row = new Row(column);

        //given
        row.drawLineAt(unsignedInt.from(3), Direction.RIGHT);

        //then
        assertThat(row.currentState(3)).isEqualTo(nodeState.LEFT);
        assertThat(row.currentState(4)).isEqualTo(nodeState.RIGHT);
    }

    @Test
    @DisplayName("drawLineAt이 음수를 받았을 때 예외를 발생시키는지 확인")
    void drawLineAtExceptionTest_negativeValue() {
        //when
        int column = 5;
        Row row = new Row(column);

        //then
        assertThatThrownBy(() -> row.drawLineAt(unsignedInt.from(-1), Direction.LEFT)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("drawLineAt이 인덱스를 초과한 선을 받았을 때 예외를 발생시키는지 확인")
    void drawLineAtExceptionTest_outOfBoundsValue() {
        //when
        int column = 5;
        Row row = new Row(column);

        //then
        assertThatThrownBy(() -> row.drawLineAt(unsignedInt.from(9), Direction.LEFT)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("drawLineAt이 적절하지 않은 선을 받았을 때 예외를 발생시키는지 확인")
    void drawLineAtExceptionTest_invalidLine() {
        //when
        int column = 5;
        Row row = new Row(column);

        //then
        assertThatThrownBy(() -> row.drawLineAt(unsignedInt.from(0), Direction.LEFT)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("drawLineAt이 이미 존재하는 선에 다시 그리려 할 때 예외를 발생시키는지 확인")
    void drawLineAtExceptionTest_OverlappedLine() {
        //when
        int column = 5;
        Row row = new Row(column);
        row.drawLineAt(unsignedInt.from(1), Direction.RIGHT);

        //then
        assertThatThrownBy(() -> row.drawLineAt(unsignedInt.from(3), Direction.LEFT)).isInstanceOf(IllegalArgumentException.class);
    }


}

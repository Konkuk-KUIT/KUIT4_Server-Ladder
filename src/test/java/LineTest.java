import ladder.Line;
import ladder.constants.Direction;
import ladder.wrapper.unsignedInt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Line 객체 테스트")
public class LineTest {

    @Test
    @DisplayName("정적 팩토리 메서드로 Line 객체가 생성되는지 확인")
    void newLineTest() {
        //when
        int row = 5;
        int column = 5;
        Direction direction = Direction.RIGHT;

        //given
        Line line = Line.of(row, column, direction);

        //then
        assertThat(line).isNotNull().isInstanceOf(Line.class);
    }

    @Test
    @DisplayName("음수값을 주면 예외를 발생시키는지 확인")
    void newLineExceptionTest_NegativeValue() {
        //when
        int row = -5;
        int column = 5;
        Direction direction = Direction.RIGHT;

        //then
        assertThatThrownBy(() -> Line.of(row, column, direction)).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("getRow 메서드가 적절한 값을 반환하는지 확인")
    void Line_getRowTest() {
        //when
        int row = 5;
        int column = 5;
        Direction direction = Direction.RIGHT;
        Line line = Line.of(row, column, direction);

        //given
        int valueByGetRow = line.getRow();

        //then
        assertThat(valueByGetRow).isEqualTo(row);
    }

    @Test
    @DisplayName("getColumn 메서드가 적절한 값을 반환하는지 확인")
    void Line_getColumnTest() {
        //when
        int row = 5;
        int column = 5;
        Direction direction = Direction.RIGHT;
        Line line = Line.of(row, column, direction);

        //given
        int valueByGetColumn = line.getColumn();

        //then
        assertThat(valueByGetColumn).isEqualTo(row);
    }
}

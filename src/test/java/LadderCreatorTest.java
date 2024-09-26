import ladder.creator.LadderGameFactory;
import ladder.wrapper.ArrayIndex;
import ladder.LadderGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 게임 생성 확인 테스트")
class LadderCreatorTest {

    @Test
    @DisplayName("createPureLadderGame가 겍체를 생성하는지 테스트")
    void createPureLadderGameTest() {
        //when
        int row = 5;
        int column = 5;

        //given
        LadderGame pureGame = LadderGameFactory.createPureLadderGame(row, column);

        //then
        assertThat(pureGame).isNotNull();
    }

    @Test
    @DisplayName("createRandomLadderGame가 겍체를 생성하는지 테스트")
    void createRandomLadderGameTest() {
        //when
        int row = 5;
        int column = 5;

        //given
        LadderGame randomGame = LadderGameFactory.createRandomLadderGame(row, column);

        //then
        assertThat(randomGame).isNotNull();
    }

    @Test
    @DisplayName("Row가 1일때 예외를 발생시키는지 테스트")
    void createLadderGameExceptionTest_RowIsOne() {
        //when
        int row = 1;
        int column = 5;

        //then
        assertThatThrownBy(() -> LadderGameFactory.createRandomLadderGame(row, column)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Column이 1일때 예외를 발생시키는지 테스트")
    void createLadderGameExceptionTest_ColumnIsOne() {
        //when
        int row = 5;
        int column = 1;

        //then
        assertThatThrownBy(() -> LadderGameFactory.createRandomLadderGame(row, column)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("음수값을 주었을 때 예외를 발생시키는지 테스트")
    void createLadderGameExceptionTest_NegativeNumber() {
        //when
        int row = -5;
        int column = 5;

        //then
        assertThatThrownBy(() -> LadderGameFactory.createRandomLadderGame(row, column)).isInstanceOf(IllegalArgumentException.class);
    }

}
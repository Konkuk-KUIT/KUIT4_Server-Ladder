import ladder.Direction;
import ladder.LadderGame;
import ladder.Position;
import ladder.creator.LadderCreator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
    @Test
    void normalGameTest() {
        LadderGameFactory.setLadderCreator(LadderCreator.from(9,9));
        LadderGame laddergame2 = LadderGameFactory.createRandomLadderGame();
        assertThat(laddergame2.run(1)).isEqualTo(4);


//        LadderCreator ladderCreator= LadderCreator.from(5,5);
//        LadderGame ladderGame = new LadderGame(ladderCreator);
//
//        ladderCreator.drawLine(Position.of(2,3,Direction.LEFT));
//        ladderCreator.drawLine(Position.of(3,3,Direction.RIGHT));
//        ladderCreator.drawLine(Position.of(1,1,Direction.RIGHT));
//
//        assertThat(ladderGame.run(1)).isEqualTo(4);

    }

//    @Test
//    void invalidRowsAndColumns() {
//        assertThatThrownBy(() -> Ladder.of(-1,5)).isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @Test
//    @DisplayName("이미 생성된 줄에 줄을 추가할 경우")
//    void drawingOverlappedLine() {
//        Ladder ladder = Ladder.of(5,5);
//
//        ladder.drawLine(Position.of(2,3,Direction.LEFT));
//
//
//        assertThatThrownBy(() -> ladder.drawLine(Position.of(2,3,Direction.RIGHT))).isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @Test
//    @DisplayName("인덱스 오류 처리")
//    void drawingOutOfRangeLine() {
//        Ladder ladder = Ladder.of(5,5);
//
//        ladder.drawLine(Position.of(2,3, Direction.LEFT));
//        assertThatThrownBy(() -> ladder.drawLine(Position.of(4,4,Direction.RIGHT))).isInstanceOf(ArrayIndexOutOfBoundsException.class);
//
//    }
}
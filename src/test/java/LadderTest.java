import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리생성")
    void CreateLadder() {
        Ladder ladder = Ladder.creatLadder(1,3);
        assertThat(ladder).isNotNull();
    }

    @Test
    @DisplayName("사다리범위벗어난위치선택")
    void CreateLadderLineExp(){
        Ladder ladder = Ladder.creatLadder(4,4);
        assertThatThrownBy(()->ladder.drawLine(Position.createPosition(1,5),Direction.RIGHT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리오른쪽라인생성")
    void CreateLadderLineRight(){
        Ladder ladder = Ladder.creatLadder(4,4);
        ladder.drawLine(Position.createPosition(2,0),Direction.RIGHT);

        assertThat(ladder.getRows()[2][0]).isEqualTo(1);
        assertThat(ladder.getRows()[2][1]).isEqualTo(-1);
    }

    @Test
    @DisplayName("사다리맨마지막오른쪽예외")
    void CreateLadderLineRightExp(){
        Ladder ladder = Ladder.creatLadder(4,4);

        assertThatThrownBy(()->ladder.drawLine(Position.createPosition(1,3),Direction.RIGHT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리왼쪽라인생성")
    void CreateLadderLineLeft(){
        Ladder ladder = Ladder.creatLadder(4,4);
        ladder.drawLine(Position.createPosition(1,2),Direction.LEFT);

        assertThat(ladder.getRows()[1][2]).isEqualTo(-1);
        assertThat(ladder.getRows()[1][1]).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리맨처음왼쪽예외")
    void CreateLadderLineLeftExp(){
        Ladder ladder = Ladder.creatLadder(4,4);

        assertThatThrownBy(()->ladder.drawLine(Position.createPosition(1,0),Direction.LEFT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리이동")
    void LadderMove(){
        Ladder ladder = Ladder.creatLadder(4,4);
        ladder.drawLine(Position.createPosition(0,0),Direction.RIGHT);
        ladder.drawLine(Position.createPosition(0,2),Direction.RIGHT);
        ladder.drawLine(Position.createPosition(1,0),Direction.RIGHT);
        ladder.drawLine(Position.createPosition(2,1),Direction.RIGHT);
        ladder.drawLine(Position.createPosition(3,2),Direction.RIGHT);

        assertThat( ladder.run(1)).isEqualTo(3);

    }

    @Test
    @DisplayName("오른쪽연속적인사다리이동")
    void LadderMoveContinuousRight(){
        Ladder ladder = Ladder.creatLadder(4,4);
        ladder.drawLine(Position.createPosition(0,0),Direction.RIGHT);
        ladder.drawLine(Position.createPosition(0,1),Direction.RIGHT);
        ladder.drawLine(Position.createPosition(0,2),Direction.RIGHT);
        ladder.drawLine(Position.createPosition(1,0),Direction.RIGHT);
        ladder.drawLine(Position.createPosition(2,1),Direction.RIGHT);
        ladder.drawLine(Position.createPosition(3,2),Direction.RIGHT);

        assertThat( ladder.run(0)).isEqualTo(2);

    }

    @Test
    @DisplayName("왼쪽연속적인사다리이동")
    void LadderMoveContinuousLeft(){
        Ladder ladder = Ladder.creatLadder(4,4);
        ladder.drawLine(Position.createPosition(0,0),Direction.RIGHT);
        ladder.drawLine(Position.createPosition(0,1),Direction.RIGHT);
        ladder.drawLine(Position.createPosition(2,1),Direction.RIGHT);
        ladder.drawLine(Position.createPosition(2,0),Direction.RIGHT);

        assertThat(ladder.run(0)).isEqualTo(0);

    }


}
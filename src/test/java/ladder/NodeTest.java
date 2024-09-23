package ladder;

import org.junit.jupiter.api.Test;

import static ladder.Direction.*;
import static org.assertj.core.api.Assertions.*;

class NodeTest {

    @Test
    void 오른쪽_방향_위치_이동_확인() {
        //given
        Node node = Node.from(RIGHT);
        LadderPosition ladderPosition = new LadderPosition(0, 0);

        //when
        node.move(ladderPosition);

        //then
        assertThat(ladderPosition.getValueY()).isEqualTo(1);
    }

    @Test
    void NONE_방향_위치_이동_확인() {
        //given
        Node node = Node.from(NONE);
        LadderPosition ladderPosition = new LadderPosition(0, 0);

        //when
        node.move(ladderPosition);

        //then
        assertThat(ladderPosition.getValueY()).isEqualTo(0);
    }

    @Test
    void 왼쪽_방향_위치_이동_확인() {
        //given
        Node node = Node.from(LEFT);
        LadderPosition ladderPosition = new LadderPosition(0, 1);

        //when
        node.move(ladderPosition);

        //then
        assertThat(ladderPosition.getValueY()).isEqualTo(0);
    }

    @Test
    void toString_RIGHT_확인() {
        //given
        Node node = Node.from(RIGHT);

        //when
        String nodeString = node.toString();

        //then
        assertThat(nodeString).isEqualTo("1");
    }

    @Test
    void toString_NONE_확인() {
        //given
        Node node = Node.from(NONE);

        //when
        String nodeString = node.toString();

        //then
        assertThat(nodeString).isEqualTo("0");
    }

    @Test
    void toString_LEFT_확인() {
        //given
        Node node = Node.from(LEFT);

        //when
        String nodeString = node.toString();

        //then
        assertThat(nodeString).isEqualTo("-1");
    }

}
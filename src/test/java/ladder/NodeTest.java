package ladder;

import ladder.info.Node;
import org.junit.jupiter.api.Test;

import static ladder.Direction.*;
import static org.assertj.core.api.Assertions.*;

class NodeTest {

    @Test
    void 오른쪽_방향_위치_이동_확인() {
        Node node = Node.from(RIGHT);

        Position position = Position.of(0,0);

        node.move(position);

        assertThat(position.getCol()).isEqualTo(1);
    }

    @Test
    void NONE_방향_위치_이동_확인() {
        Node node = Node.from(NONE);

        Position position = Position.of(0,0);

        node.move(position);

        assertThat(position.getCol()).isEqualTo(0);
    }

    @Test
    void 왼쪽_방향_위치_이동_확인() {
        Node node = Node.from(LEFT);

        Position position = Position.of(0,1);

        node.move(position);

        assertThat(position.getCol()).isEqualTo(0);
    }

}
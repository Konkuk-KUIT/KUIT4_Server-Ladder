package ladder;

import ladder.core.Node;
import ladder.position.Position;
import org.junit.jupiter.api.Test;

import static ladder.core.Direction.*;
import static org.assertj.core.api.Assertions.*;

class NodeTest {

    @Test
    void 오른쪽_방향_위치_이동_확인() {
        Node node = Node.from(RIGHT);

        Position position = Position.from(0);

        node.move(position);

        assertThat(position.getValue()).isEqualTo(1);
    }

    @Test
    void NONE_방향_위치_이동_확인() {
        Node node = Node.from(NONE);

        Position position = Position.from(0);

        node.move(position);

        assertThat(position.getValue()).isEqualTo(0);
    }

    @Test
    void 왼쪽_방향_위치_이동_확인() {
        Node node = Node.from(LEFT);

        Position position = Position.from(1);

        node.move(position);

        assertThat(position.getValue()).isEqualTo(0);
    }


    @Test
    void 오른쪽_노드_심볼_추가() {
        StringBuilder sb = new StringBuilder();
        Node node = Node.from(RIGHT);
        node.appendSymbol(sb);
        assertThat(sb.toString()).isEqualTo("1");
    }

    @Test
    void 왼쪽_노드_심볼_추가() {
        StringBuilder sb = new StringBuilder();
        Node node = Node.from(LEFT);
        node.appendSymbol(sb);
        assertThat(sb.toString()).isEqualTo("-1");
    }

    @Test
    void 노드_심볼_추가() {
        StringBuilder sb = new StringBuilder();
        Node node = Node.from(NONE);
        node.appendSymbol(sb);
        assertThat(sb.toString()).isEqualTo("0");
    }
}
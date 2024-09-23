package ladder;
import static ladder.Direction.*;

// 사다리의 세로줄 (열), numberOFPerson
// 사다리의 실제 값 (방향)을 담는 클래스
public class Node {
    private Direction direction; // 사다리의 실제 값

    private Node(Direction direction) {
        this.direction = direction;
    }

    public static Node from(Direction direction) {
        return new Node(direction);
    }

    public void setRightNode(Position position) {
        direction = RIGHT;
    }

    public void setLeftNode(Position position) {
        direction = LEFT;
    }

    // 밖에서 안쓰므로 private으로 만들기
    private boolean isRight() {
        return direction == RIGHT;
    }

    private boolean isLeft() {
        return direction == LEFT;
    }

    public boolean isAlreadySetDirection() {
        return isNone();
    }

    private boolean isNone() {
        return direction == NONE;
    }

    // 노드값을 보고 하는 것이므로 node의 책임 (from Row클래스)
    public void move(Position position) {
        if (isRight()) {
            position.next(); // 이 곳에 return 삭제함 (1)
            return;
        }
        if (isLeft()) {
            position.prev();
            return;
        }
    }




}
